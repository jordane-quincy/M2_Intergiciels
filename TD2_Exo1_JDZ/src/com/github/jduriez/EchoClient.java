package com.github.jduriez;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class EchoClient extends Thread {
	
	private static final String HOST = "localhost";
	private static final int PORT = 8080;
	
	String nomProduit;
	double prixProduit;
	int id;
	
	public EchoClient(int _id, String _nomProduit, double _prixProduit) {
		this.nomProduit = _nomProduit;
		this.prixProduit = _prixProduit;
		this.id = _id;
	}
	
	public void run() {
		System.out.println("Lancement du thread Client " + id);
		Socket theSocket;
		ObjectOutputStream toServer;
		ObjectInputStream fromServer;
		
		
		try {
			theSocket = new Socket(HOST, PORT);
			
			toServer = new ObjectOutputStream(theSocket.getOutputStream());
			fromServer = new ObjectInputStream(theSocket.getInputStream());
			Produit p = new Produit(nomProduit, prixProduit);
			System.out.println("Le client " + id + " envoie le produit : " + p);
			toServer.writeObject(id);
			toServer.writeObject(p);
			//toServer.flush();
			System.out.println("Le client " + id + " reçoit le produit : "  + fromServer.readObject());
			
			toServer.close();
			fromServer.close();
			
			/*theInputStream = new DataInputStream(theSocket.getInputStream());
			theOutputStream = new PrintStream(theSocket.getOutputStream());
			userInput = new DataInputStream(System.in);*/
	        
			/*while (true) {
				theLine = userInput.readLine();
				if (theLine.equals(".")) {
					break;
				}
				theOutputStream.println(theLine);
				System.out.println(theInputStream.readLine());
			}*/
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
