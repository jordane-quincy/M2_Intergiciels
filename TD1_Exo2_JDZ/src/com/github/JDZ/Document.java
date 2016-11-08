package com.github.JDZ;

public class Document {
	int impressionTime;
	int utilisateurId;
	
	public Document(int _impressionTime, int _utilisateurId) {
		impressionTime=  _impressionTime;
		utilisateurId = _utilisateurId;
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



	@Override
	public String toString() {
		return "Document [impressionTime=" + impressionTime + ", utilisateurId=" + utilisateurId + "]";
	}
	
}
