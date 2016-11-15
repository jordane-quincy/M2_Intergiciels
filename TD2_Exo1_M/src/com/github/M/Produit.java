package com.github.M;

import java.io.Serializable;

public class Produit implements Serializable {

	private static final long serialVersionUID = 8967789855051491188L;

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

	public void augmenter(double p) {
		this.prix = this.prix * (1 + p / 100);
	}

}
