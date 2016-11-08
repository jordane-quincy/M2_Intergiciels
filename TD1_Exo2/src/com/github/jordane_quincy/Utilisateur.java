package com.github.jordane_quincy;

public class Utilisateur extends Thread {

	private int id;

	public Utilisateur(int id) {
		this.id = id;
	};

	@Override
	public void run() {
		System.out.println("Run utilisateur n°" + id);
		while (true) {
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
