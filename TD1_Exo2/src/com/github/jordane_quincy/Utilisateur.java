package com.github.jordane_quincy;

import java.util.Random;

public class Utilisateur extends Thread {

	private int id;
	private Gestionnaire gestionnaire;

	public Utilisateur(int id, Gestionnaire gestionnaire) {
		this.id = id;
		this.gestionnaire = gestionnaire;
	};

	@Override
	public void run() {
		System.out.println("Thread utilisateur n°" + id);
		while (true) {
			Document doc = new Document(id, generateDureeImpression());

			while (!gestionnaire.ajouterDoc(doc)) {
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
				}
			}

			System.out.println(getTimestamp() + "Utilisateur n°" + id + " ajout doc ok");

			try {
				Thread.currentThread().sleep(20000);
			} catch (InterruptedException e) {
			}
		}
	}

	private int generateDureeImpression() {
		Random r = new Random();
		int min = 1000;
		int max = 10000;
		int result = r.nextInt(max - min) + min;
		return result;
	}

	public String getTimestamp() {
		return System.currentTimeMillis() + "\t";
	}

}
