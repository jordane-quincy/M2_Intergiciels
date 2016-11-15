package com.github.JDZ;

public class Document {
	int impressionTime;
	int utilisateurId;
	String nomUtilisateur;
	
	public Document(int _impressionTime, int _utilisateurId, String _nomUtilisateur) {
		impressionTime=  _impressionTime;
		utilisateurId = _utilisateurId;
		nomUtilisateur = _nomUtilisateur;
	}
	
	public int getImpressionTime() {
		return impressionTime;
	}

	public void setImpressionTime(int impressionTime) {
		this.impressionTime = impressionTime;
	}



	public int getUtilisateurId() {
		return utilisateurId;
	}



	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	@Override
	public String toString() {
		return "Document [impressionTime=" + impressionTime + ", utilisateurId=" + utilisateurId + "]";
	}
	
}
