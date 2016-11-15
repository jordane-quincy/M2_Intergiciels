package com.github.jordane_quincy;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;

public class EchoClient {

	private final static String FILENAME = "produit.ser";

	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	public static void main(String[] args) {
		Socket theSocket;
		DataInputStream theInputStream;
		DataInputStream userInput;
		PrintStream theOutputStream;
		String theLine;
		// Produit produit = null;
		//
		// try {
		// produit = readProduit();
		// } catch (Exception e) {
		// System.out.println("Création d'un nouveau produit");
		// produit = new Produit("nom", 100);
		//
		// try {
		// writeProduit(produit);
		// } catch (Exception e1) {
		// System.err.println("Exception a l'enregistrement :" +
		// e1.getMessage());
		// }
		//
		// }

		Produit produit = new Produit("nom", 100);

		System.out.println("Produit avant envoi : " + produit);

		ObjectOutputStream oos;
		ObjectInputStream ios;
		try {
			theSocket = new Socket(HOST, PORT);
			// theInputStream = new DataInputStream(theSocket.getInputStream());
			// theOutputStream = new PrintStream(theSocket.getOutputStream());
			// userInput = new DataInputStream(System.in);

			oos = new ObjectOutputStream(theSocket.getOutputStream());
			ios = new ObjectInputStream(theSocket.getInputStream());
			// while (true) {
			// theLine = userInput.readLine();
			// if (theLine.equals(".")) {
			// break;
			// }
			// theOutputStream.println(theLine);
			// System.out.println(theInputStream.readLine());
			// }

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

	public static void writeProduit(Produit produit) throws FileNotFoundException, IOException, ParseException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));

		objectOutputStream.writeObject(produit);

		objectOutputStream.close();
	}

	@SuppressWarnings("unchecked")
	public static Produit readProduit() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME));

		Produit produit = (Produit) objectInputStream.readObject();

		objectInputStream.close();

		return produit;
	}
}
