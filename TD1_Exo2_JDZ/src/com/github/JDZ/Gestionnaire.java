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
			try {
				Thread.currentThread();
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
