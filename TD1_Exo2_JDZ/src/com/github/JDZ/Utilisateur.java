package com.github.JDZ;

public class Utilisateur extends Thread{
	int id;
	String nom;
	Gestionnaire gestionnaire;
	
	public Utilisateur (int _id, String _nom, Gestionnaire _gestionnaire) {
		id = _id;
		nom = _nom;
		gestionnaire = _gestionnaire;
	}
	
	@Override
	public void run() {
		System.out.println("Run utilisateur :" + id + ", nom : " + nom);
		while (true) {			
			try {
				//attente avant de générer un doc à envoyé (entre 5 et 7 secondes)
				Thread.currentThread();
				Thread.sleep((int) ((int)( Math.random()*( 7000 - 5000 + 1 ) ) + 5000));
				Document doc = new Document((int)(Math.random()*( 10000 - 1000 + 1 ) ) + 1000, id, nom);
				while (!gestionnaire.ajouterDoc(doc)) {					
					Thread.currentThread();
					Thread.sleep(10);					
				}
				System.out.println("Ajout d'impression de doc de " + nom + ", file d'attente : " + gestionnaire.getFileAttente().size() + "/" + gestionnaire.getTailleFile());
				
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + "]";
	}
	
	
}
