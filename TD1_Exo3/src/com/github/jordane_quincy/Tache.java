package com.github.jordane_quincy;

public class Tache implements Runnable {

	private String nom;
	private int duree;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Tache(String nom, int duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}

	@Override
	public void run() {
		System.out.println("Run de '" + nom + "'");

		try {
			Thread.currentThread().sleep(duree);
		} catch (InterruptedException e) {
		}
	}
}
