package com.github.jduriez;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	private Client() {}
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		String host = "localhost";
		Registry registry = LocateRegistry.getRegistry(host, 8080);
		Hello stub = (Hello)registry.lookup("Hello");
		String response = stub.sayHello();
		System.out.println("response : " + response);
		
	}

}
