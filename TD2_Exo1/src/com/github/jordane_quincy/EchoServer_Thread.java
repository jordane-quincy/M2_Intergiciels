package com.github.jordane_quincy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer_Thread extends Thread {

	private static final int PORT = 8080;

	public EchoServer_Thread() {
	}

	void doService(Socket clientSocket) throws IOException {

		ObjectInputStream ios;
		ObjectOutputStream oos;
		try {
			ios = new ObjectInputStream(clientSocket.getInputStream());
			oos = new ObjectOutputStream(clientSocket.getOutputStream());

			try {
				Produit produitRecu = (Produit) ios.readObject();

				if (produitRecu != null) {
					System.out.println("[Serveur] \t" + "produitRecu : " + produitRecu);

					produitRecu.augmenter(15);

					System.out.println("[Serveur] \t" + "produitRecu une fois augmenter" + produitRecu);

					oos.writeObject(produitRecu);
				} else {
					System.err.println("[Serveur] \t" + "produitRecu est null :-/");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println("[Serveur] \t" + "outch : " + e);
		}

	}

	@Override
	public void run() {
		EchoServer_Thread echoServ = new EchoServer_Thread();
		ServerSocket listenSocket;
		try {
			System.out.println("[Serveur] \t" + "Serveur en écoute sur le port " + PORT);
			listenSocket = new ServerSocket(PORT);
			while (true) {
				Socket clientSocket = listenSocket.accept();
				System.err.println("[Serveur] \t" + "Connexion from : " + clientSocket.getInetAddress());
				echoServ.doService(clientSocket);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
