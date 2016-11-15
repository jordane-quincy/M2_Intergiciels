package com.github.JDZ;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gestionnaire gestionnaire = new Gestionnaire();
		new Thread(gestionnaire).start();
		
		new Thread(new Utilisateur(1, "Jordane", gestionnaire)).start();
		new Thread(new Utilisateur(2, "JB", gestionnaire)).start();
		new Thread(new Utilisateur(3, "Maxime", gestionnaire)).start();

	}

}
