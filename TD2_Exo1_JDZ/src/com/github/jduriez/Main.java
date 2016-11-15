package com.github.jduriez;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EchoServer server = new EchoServer();		
		new Thread(server).start();
		new Thread(new EchoClient(1, "ordi", (double)100)).start();		
		new Thread(new EchoClient(2, "tablette", (double)50)).start();
		new Thread(new EchoClient(3, "téléphone", (double)800)).start();
	}

}
