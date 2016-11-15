package com.github.jduriez;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	private static final int PORT = 8080;
	private static final String HOST = "localhost";
	
	void doService(Socket clientSocket) throws IOException {
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		PrintStream out = new PrintStream(clientSocket.getOutputStream());
		while (true) {
			@SuppressWarnings("deprecation")
			String theLine = in.readLine();
			out.println(theLine);
		}
	}

	public static void main(String[] args) {
		EchoServer echoServ = new EchoServer();
		ServerSocket listenSocket;
		try {
			listenSocket = new ServerSocket(PORT); // port
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
