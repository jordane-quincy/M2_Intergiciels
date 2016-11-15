package com.github.jordane_quincy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	private final static String FILENAME = "produit.ser";

	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	public static void main(String[] args) {
		Socket theSocket;

		Produit produit = new Produit("nom", 100);

		System.out.println("Produit avant envoi : " + produit);

		ObjectOutputStream oos;
		ObjectInputStream ios;
		try {
			System.out.println("Creation de la connexion à " + HOST + ":" + PORT);
			theSocket = new Socket(HOST, PORT);

			oos = new ObjectOutputStream(theSocket.getOutputStream());
			ios = new ObjectInputStream(theSocket.getInputStream());

			oos.writeObject(produit);

			try {
				Produit produitDuServeur = (Produit) ios.readObject();

				if (produitDuServeur != null) {
					System.out.println("produitDuServeur : " + produitDuServeur);
				} else {
					System.err.println("produitDuServeur est null :-/");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

}
