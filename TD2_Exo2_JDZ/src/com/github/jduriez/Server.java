package com.github.jduriez;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Hello {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5772476845127678270L;

	public Server() throws RemoteException{
		
	}
	public String sayHello() throws RemoteException {
		return "Hello, world!";
	}
	
	public static void main(String args[]) throws RemoteException, MalformedURLException, AlreadyBoundException {
		Server obj = new Server();
		//Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
		Registry registry = LocateRegistry.createRegistry(8080);
	    registry.bind("Hello", obj);
		System.out.println("Server ready");
		
	}
	
}
