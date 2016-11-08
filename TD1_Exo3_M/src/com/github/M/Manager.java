package com.github.M;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager {

	private final static int NB_MAX_THREADS_SYNC_ = 2;
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NB_MAX_THREADS_SYNC_);
		
		System.out.println("Création d'une tache");
		Tache tache = new Tache("tache 1", 1000);
		System.out.println("Lancement de la tache");
	}
}
