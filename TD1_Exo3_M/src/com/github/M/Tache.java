package com.github.M;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
/*
 * @name nom de la tache
 * @exec_time_ temps d'execution de la tache avant dodo en ms
 */
public class Tache implements Runnable{

	private String name_;
	private int exec_time_;
	@Override
	public void run() {
		System.out.println("Debut " + name_);
		try {
            MILLISECONDS.sleep(exec_time_);
        } catch (InterruptedException e) {
            // that's shit
        }
		System.out.println("Fin " + name_);
	}
	public Tache(String name_, int exec_time_) {
		super();
		this.name_ = name_;
		setExec_time_(exec_time_);
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public int getExec_time_() {
		return exec_time_;
	}
	public void setExec_time_(int exec_time_) {
		if(exec_time_ >= 500 && exec_time_ <= 2500)
			this.exec_time_ = exec_time_;
	}
}
