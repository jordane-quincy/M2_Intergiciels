package com.github.jordane_quincy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient_Thread extends Thread {

	private int id;

	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	public EchoClient_Thread(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		Socket theSocket;

		Produit produit = new Produit("nom" + id, 100 * id);

		System.out.println("Produit avant envoi : " + produit);

		ObjectOutputStream oos = null;
		ObjectInputStream ios = null;
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
