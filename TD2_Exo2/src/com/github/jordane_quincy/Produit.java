package com.github.jordane_quincy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Produit extends UnicastRemoteObject implements ProduitItf {

	private static final long serialVersionUID = 3488966906210038383L;

	private String nom;
	private double prix;

	public Produit(String nom, double prix) throws RemoteException {
		this.nom = nom;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + "]";
	}

	@Override
	public void augmenter(double p) throws RemoteException {
		this.prix = this.prix * (1 + p / 100);
	}

	@Override
	public double recuperer() throws RemoteException {
		return this.prix;
	}

	@Override
	public String getNom() throws RemoteException {
		return nom;
	}

}
