package com.github.M;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) {
		Socket theSocket;
		DataInputStream theInputStream;
		DataInputStream userInput;
		PrintStream theOutputStream;
		String theLine;
		try {
			theSocket = new Socket("localhost", 9876);//(args[0], Integer.parseInt(args[1]));
			theInputStream = new DataInputStream(theSocket.getInputStream());
			theOutputStream = new PrintStream(theSocket.getOutputStream());
			userInput = new DataInputStream(System.in);
			
			ObjectOutputStream oos = new ObjectOutputStream(theOutputStream);
			ObjectInputStream ois = new ObjectInputStream(theInputStream);
			while (true) {
				System.out.println("Envoi du produit depuis le client");
				Produit produit = new Produit("Computer", 560.5);
				oos.writeObject(produit);
				
				produit = (Produit)ois.readObject();
				
				System.out.println("Nouveau produit recu sur le client: " + produit);
			}
		} catch (UnknownHostException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
