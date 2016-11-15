package com.github.jordane_quincy;

public class Main_Thread {

	public static void main(String[] args) {
		EchoServer_Thread serveur = new EchoServer_Thread();
		new Thread(serveur).start();

		new Thread(new EchoClient_Thread(1)).start();
		new Thread(new EchoClient_Thread(2)).start();
		new Thread(new EchoClient_Thread(3)).start();

	}
}
