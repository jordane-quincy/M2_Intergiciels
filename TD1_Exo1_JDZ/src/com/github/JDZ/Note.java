package com.github.JDZ;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Note implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4454945283422554294L;
	Date date;
	int idEcrivain;
	transient String commentaire;
	Role role;
	
	private final String DateFormat = "dd/mm/yyyy";
	private final SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy"); 
	
	public Note () throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est l'id de l'écrivain pour votre note ?");
		int _idEcrivain = sc.nextInt();
		sc.nextLine();
		idEcrivain = _idEcrivain;
		System.out.println("Quel est le commentaire pour votre note ?");
		String comment = sc.nextLine();
		commentaire = comment;
		System.out.println("Quelle est la date pour la note ? (format : " + DateFormat + ")");
		String stringDate = sc.nextLine();
		Date _date = format.parse(stringDate);
		date = _date;
		System.out.println("Quel est le role pour la note ?");
		String theRole = sc.nextLine();
		role = new Role(theRole);
	}

	@Override
	public String toString() {
		return "Note [date=" + date + ", idEcrivain=" + idEcrivain + ", commentaire=" + commentaire + ", role=" + role
				+ "]";
	}
	
	private void readObject(java.io.ObjectInputStream stream) throws ClassNotFoundException, IOException {
		stream.defaultReadObject();
		this.commentaire = "commentaire inconnu";
    }

	
}
