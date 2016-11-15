package com.github.M;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	void doService(Socket clientSocket) throws IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
		
		while (true) {
			Produit produit;
			try {
				produit = (Produit)ois.readObject();
				System.out.println("Produit recu sur le serveur: " + produit);
				
				produit.augmenter(10.5);
				
				oos.writeObject(produit);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		EchoServer echoServ = new EchoServer();
		ServerSocket listenSocket;
		try {
			listenSocket = new ServerSocket(9876);//(Integer.parseInt(args[0])); // port
			while (true) {
				Socket clientSocket = listenSocket.accept();
				System.err.println("Connexion from:" + clientSocket.getInetAddress());
				echoServ.doService(clientSocket);
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
