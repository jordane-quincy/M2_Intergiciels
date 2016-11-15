package com.github.jduriez;

import java.io.Serializable;

public class Produit implements Serializable {
	String nom;
	double prix;
	
	public Produit(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Produit [nom=" + nom + ", prix=" + prix + "]";
	}
	
	public void augmenter(double p) {
		this.prix += this.prix * (p / 100); 
	}
}
