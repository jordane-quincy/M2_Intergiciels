package com.github.jordane_quincy;

import java.util.ArrayList;
import java.util.List;

public class Gestionnaire extends Thread {

	private static final int TAILLE_FILE = 4;
	private List<Document> fileAttente = new ArrayList<Document>(TAILLE_FILE);

	@Override
	public void run() {
		System.out.println("Thread Gestionnaire");
		while (true) {
			if (!fileAttente.isEmpty()) {
				int index = 0;
				Document docToPrint = fileAttente.get(index);

				System.out.println("Impression du doc de l'utilisateur " + docToPrint.getIdUtilisateur() + " ("
						+ docToPrint.getDureeImpression() + ")");

				try {
					Thread.currentThread().sleep(docToPrint.getDureeImpression());
				} catch (InterruptedException e) {
				}

				System.out.println("Fin impression du doc de l'utilisateur " + docToPrint.getIdUtilisateur());

				fileAttente.remove(index);
			}

			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

	public synchronized boolean ajouterDoc(Document doc) {
		boolean isAjoutOk = false;
		if (fileAttente.size() <= TAILLE_FILE) {
			fileAttente.add(doc);
			isAjoutOk = true;
		}
		return isAjoutOk;
	}

}
