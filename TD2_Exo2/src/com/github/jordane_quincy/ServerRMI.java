package com.github.jordane_quincy;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {
	public ServerRMI() throws RemoteException {

	}

	public static void main(String args[]) throws RemoteException, MalformedURLException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(8080);

		// Produit table = new Produit("table", 100);
		// ProduitItf stubTable = (ProduitItf)
		// UnicastRemoteObject.exportObject(table, 0);
		// System.out.println("bind du produit :" + table);
		// registry.bind("bindStubTable", stubTable);
		//
		// Produit crayon = new Produit("crayon", 20);
		// ProduitItf stubCrayon = (ProduitItf)
		// UnicastRemoteObject.exportObject(crayon, 0);
		// System.out.println("bind du produit :" + crayon);
		// registry.bind("bindStubCrayon", stubCrayon);

		Produit table = new Produit("table", 100);
		enregistrerProduitDansLeRegistre(table, registry);

		Produit crayon = new Produit("crayon", 18);
		enregistrerProduitDansLeRegistre(crayon, registry);

		System.out.println("Server ready");
	}

	private static void enregistrerProduitDansLeRegistre(Produit produit, Registry registry)
			throws AccessException, RemoteException, AlreadyBoundException {
		// Plus necessaire car l'implementation Produit extends
		// UnicastRemoteObject :

		// ProduitItf stubProduit = (ProduitItf)
		// UnicastRemoteObject.exportObject(produit, 8080);

		System.out.println("bind du produit :" + produit);
		registry.bind(produit.getNom(), produit);
	}

}
