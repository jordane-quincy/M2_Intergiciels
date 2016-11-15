package com.github.jordane_quincy;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
	private ClientRMI() {
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String host = "localhost";
		Registry registry = LocateRegistry.getRegistry(host, 8080);

		// ProduitItf stub = (ProduitItf) registry.lookup("bindStubTable");
		// double prixAvant = stub.recuperer();
		// System.out.println("prixAvant : " + prixAvant);
		// stub.augmenter(1000);
		// double prixApres = stub.recuperer();
		// System.out.println("prixApres : " + prixApres);
		//
		// ProduitItf stubCrayon = (ProduitItf)
		// registry.lookup("bindStubCrayon");
		// double prixCrayonAvant = stubCrayon.recuperer();
		// System.out.println("prixCrayonAvant : " + prixCrayonAvant);
		// stub.augmenter(1000);
		// double prixCrayonApres = stubCrayon.recuperer();
		// System.out.println("prixCrayonApres : " + prixCrayonApres);

		lookupProduitInRegistry("table", registry);
		lookupProduitInRegistry("crayon", registry);

	}

	private static void lookupProduitInRegistry(String bindNameProduit, Registry registry)
			throws RemoteException, NotBoundException {
		ProduitItf stub = (ProduitItf) registry.lookup(bindNameProduit);
		double prixAvant = stub.recuperer();
		System.out.println("prixAvant : " + prixAvant);

		if (prixAvant < 20) {
			stub.augmenter(30);
		}

		double prixApres = stub.recuperer();
		System.out.println("prixApres : " + prixApres);
	}

}
