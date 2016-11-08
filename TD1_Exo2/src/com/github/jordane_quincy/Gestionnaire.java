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

				System.out.println(getTimestamp() + "Impression du doc de l'utilisateur "
						+ docToPrint.getIdUtilisateur() + " (" + docToPrint.getDureeImpression() + ")");

				try {
					Thread.currentThread().sleep(docToPrint.getDureeImpression());
				} catch (InterruptedException e) {
				}

				System.out.println(
						getTimestamp() + "Fin impression du doc de l'utilisateur " + docToPrint.getIdUtilisateur());

				fileAttente.remove(index);
			} else {
				System.err.println("La file d'impression est vide");

				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
				}
			}

		}
	}

	public synchronized boolean ajouterDoc(Document doc) {
		boolean isAjoutOk = false;
		if (fileAttente.size() <= TAILLE_FILE) {
			System.out.println(getTimestamp() + "fileAttente : " + fileAttente.size() + "/" + TAILLE_FILE
					+ ". Doc user : " + doc.getIdUtilisateur());
			fileAttente.add(doc);
			isAjoutOk = true;
		}
		return isAjoutOk;
	}

	public String getTimestamp() {
		return System.currentTimeMillis() + "\t";
	}

}
