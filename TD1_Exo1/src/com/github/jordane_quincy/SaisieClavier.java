package com.github.jordane_quincy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SaisieClavier {
	public static String lire() {

		String ligne = null;
		BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));

		try {
			ligne = entree.readLine();
		} catch (Exception e) {
			System.err.println("Erreur dans la saisie : " + e);
		}

		return ligne;
	}
}
