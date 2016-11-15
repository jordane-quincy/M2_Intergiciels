package com.github.jduriez;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class EchoClient {
	
	private static final String HOST = "localhost";
	private static final int PORT = 8080;
	
	public static void main(String[] args) throws ClassNotFoundException {
		Socket theSocket;
		DataInputStream theInputStream;
		DataInputStream userInput;
		PrintStream theOutputStream;
		String theLine;
		ObjectOutputStream toServer;
		ObjectInputStream fromServer;
		
		
		try {
			theSocket = new Socket(HOST, PORT);
			
			toServer = new ObjectOutputStream(theSocket.getOutputStream());
			fromServer = new ObjectInputStream(theSocket.getInputStream());
			Produit p = new Produit("ordi", 100);
			
			toServer.writeObject(p);
			//toServer.flush();
			System.out.println(fromServer.readObject());
			
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
		}
	}
}
