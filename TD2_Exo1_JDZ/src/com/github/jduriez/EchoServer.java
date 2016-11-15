package com.github.jduriez;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer extends Thread{
	
	private static final int PORT = 8080;
	private static final String HOST = "localhost";
	
	void doService(Socket clientSocket) throws IOException, ClassNotFoundException {
		/*DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		PrintStream out = new PrintStream(clientSocket.getOutputStream());
		while (true) {
			@SuppressWarnings("deprecation")
			String theLine = in.readLine();
			out.println(theLine);
		}*/
		ObjectOutputStream outputToClient;
		ObjectInputStream inputFromClient;
		
		outputToClient = new ObjectOutputStream(clientSocket.getOutputStream());
		inputFromClient = new ObjectInputStream(clientSocket.getInputStream());
		
		System.out.println("Reception produit du client " + inputFromClient.readObject());
		Produit p = (Produit) inputFromClient.readObject();
		System.out.println("on récupère : " + p);
		p.augmenter(15);
		System.out.println("on renvoie : " + p);
		System.out.println("fin com");
		outputToClient.writeObject(p);		
		outputToClient.close();
		inputFromClient.close();	
	}

	public void run () {
		System.out.println("Lancement du thread Serveur");
		
		ServerSocket listenSocket;
		try {
			listenSocket = new ServerSocket(PORT); // port
			
			while(true) {
				Socket clientSocket = listenSocket.accept();
				System.err.println("Connexion from:" + clientSocket.getInetAddress());
				doService(clientSocket);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
}
