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
		ProduitItf stub = (ProduitItf)registry.lookup("Produit1");
		double price = stub.getPrice();
		System.out.println("Prix du produit1 : " + price);
		if (price < 20) {
			stub.augmenterPrix(30);
		}
		ProduitItf stub2 = (ProduitItf) registry.lookup("Produit1");
		System.out.println("Nouveau prix du produit1 : " + stub2.getPrice());
		
		
		ProduitItf stub3 = (ProduitItf) registry.lookup("Produit2");
		System.out.println("Prix du produit 2 : " + stub3.getPrice());
		if (stub3.getPrice() < 20) {
			stub3.augmenterPrix(30);
		}
		
		ProduitItf stub4 = (ProduitItf) registry.lookup("Produit2");
		System.out.println("Nouveau prix du produit2 : " + stub4.getPrice());
	}

}
