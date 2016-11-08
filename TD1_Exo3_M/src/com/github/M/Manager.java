package com.github.M;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager {

	private final static int NB_MAX_THREADS_SYNC_ = 2;
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(NB_MAX_THREADS_SYNC_);

        executor.execute(new Thread(new Tache("tache 1", 3000)));
        executor.execute(new Thread(new Tache("tache 2", 2000)));
        executor.execute(new Thread(new Tache("tache 3", 1500)));
        executor.execute(new Thread(new Tache("tache 4", 1000)));
        executor.execute(new Thread(new Tache("tache 5", 4000)));
        
        executor.shutdown();
	}
}
