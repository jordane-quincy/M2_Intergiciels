package com.github.JDZ;

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
				System.out.println("Impression du document de " + docToPrint.getNomUtilisateur() + "(" + docToPrint.getImpressionTime() + ")");				
				try {
					Thread.currentThread();
					Thread.sleep(docToPrint.getImpressionTime());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Fin d'impression du doc de " + docToPrint.getNomUtilisateur());
				fileAttente.remove(index);
			}
			try {
				Thread.currentThread();
				Thread.sleep(100);
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

	public List<Document> getFileAttente() {
		return fileAttente;
	}

	public void setFileAttente(List<Document> fileAttente) {
		this.fileAttente = fileAttente;
	}

	public static int getTailleFile() {
		return TAILLE_FILE;
	}
	
	
}
