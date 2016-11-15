package com.github.jduriez;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Produit extends UnicastRemoteObject implements ProduitItf{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1692453052438603307L;
	double prix;
	String nom;
	
	public Produit(String _nom, double _prix) throws RemoteException{
		this.prix = _prix;		
		this.nom = _nom;
	}
	
	@Override
	public double getPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return this.prix;
	}

	@Override
	public void augmenterPrix(double p) throws RemoteException {
		// TODO Auto-generated method stub
		this.prix += this.prix * (p / 100);
	}

}
