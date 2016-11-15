package com.github.jordane_quincy;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	void doService(Socket clientSocket) {
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		PrintStream out = new PrintStream(clientSocket.getOutputStream());
		while (true) {
			String theLine = in.readLine();
			out.println(theLine);
		}
	}

	public static void main(String[] args) {
		EchoServer echoServ = new EchoServer();
		ServerSocket listenSocket;
		try {
			listenSocket = new ServerSocket(Integer.parseInt(args[0])); // port
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
