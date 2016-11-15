package com.github.jordane_quincy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	private static final int PORT = 8080;

	void doService(Socket clientSocket) throws IOException {
		// DataInputStream in = new
		// DataInputStream(clientSocket.getInputStream());
		// PrintStream out = new PrintStream(clientSocket.getOutputStream());
		// while (true) {
		// String theLine = in.readLine();
		// out.println(theLine);
		// }

		ObjectInputStream ios;
		ObjectOutputStream oos;
		try {
			ios = new ObjectInputStream(clientSocket.getInputStream());
			oos = new ObjectOutputStream(clientSocket.getOutputStream());

			try {
				Produit produitRecu = (Produit) ios.readObject();

				if (produitRecu != null) {
					System.out.println("produitRecu : " + produitRecu);

					produitRecu.augmenter(15);

					oos.writeObject(produitRecu);
				} else {
					System.err.println("produitRecu est null :-/");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println("outch : " + e);
		}

	}

	public static void main(String[] args) {
		EchoServer echoServ = new EchoServer();
		ServerSocket listenSocket;
		try {
			listenSocket = new ServerSocket(PORT);
			while (true) {
				Socket clientSocket = listenSocket.accept();
				System.err.println("Connexion from : " + clientSocket.getInetAddress());
				echoServ.doService(clientSocket);
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
