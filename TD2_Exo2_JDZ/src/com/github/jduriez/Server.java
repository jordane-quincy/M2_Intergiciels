package com.github.jduriez;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public static void main(String args[]) throws RemoteException, MalformedURLException, AlreadyBoundException {
		
		Produit p = new Produit("ordi", 10);
		Produit p2 = new Produit("telephone", 800);
		//Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
		Registry registry = LocateRegistry.createRegistry(8080);
	    registry.bind("Produit1", p);
	    registry.bind("Produit2", p);
		System.out.println("Server ready");
		
	}
	
}
