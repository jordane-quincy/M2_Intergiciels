package com.github.jordane_quincy;

public class Main {

	public static void main(String[] args) {
		Gestionnaire gestionnaire = new Gestionnaire();
		new Thread(gestionnaire).start();

		new Thread(new Utilisateur(0, gestionnaire)).start();
		new Thread(new Utilisateur(1, gestionnaire)).start();
		new Thread(new Utilisateur(2, gestionnaire)).start();
	}

}
