package com.github.jordane_quincy;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	private final static int NB_TACHE_MAX = 5;

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (int i = 0; i < NB_TACHE_MAX; i++) {
			Tache tache = new Tache("tache " + i, generateDureeExecution());
			executorService.submit(tache);
		}

		executorService.shutdown();
	}

	private static int generateDureeExecution() {
		Random r = new Random();
		int min = 500;
		int max = 2500;
		int result = r.nextInt(max - min) + min;
		return result;
	}

}
