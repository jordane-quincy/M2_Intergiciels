package com.github.JDZ;

public class Utilisateur extends Thread{
	int id;
	String nom;
	
	public Utilisateur (int _id, String _nom) {
		id = _id;
		nom = _nom;
	}
	
	@Override
	public void run() {
		System.out.println("Run utilisateur :" + id + ", nom : " + nom);
		while (true) {
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
