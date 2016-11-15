package com.github.jduriez;

public interface ProduitItf extends java.rmi.Remote {
	double getPrice() throws java.rmi.RemoteException;
	void augmenterPrix(double p) throws java.rmi.RemoteException;
}
