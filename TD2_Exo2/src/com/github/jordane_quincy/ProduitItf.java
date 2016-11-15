package com.github.jordane_quincy;

public interface ProduitItf extends java.rmi.Remote {
	void augmenter(double p) throws java.rmi.RemoteException;

	double recuperer() throws java.rmi.RemoteException;

	String getNom() throws java.rmi.RemoteException;
}
