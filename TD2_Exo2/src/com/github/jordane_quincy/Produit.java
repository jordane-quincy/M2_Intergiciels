package com.github.jordane_quincy;

import java.rmi.RemoteException;

public class Produit implements ProduitItf {

	private String nom;
	private double prix;

	public Produit(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + "]";
	}

	@Override
	public void augmenter(double p) {
		this.prix = this.prix * (1 + p / 100);
	}

	@Override
	public double recuperer() throws RemoteException {
		return this.prix;
	}

	@Override
	public String getNom() {
		return nom;
	}

}
