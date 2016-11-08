package com.github.jordane_quincy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Note implements Serializable {

	private int idEcrivain;
	private Date date;
	private transient String commentaire;

	private static final long serialVersionUID = -1263091870841148920L;

	private transient final String FORMAT_DATE = "yy/MM/dd";
	private transient final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(FORMAT_DATE);

	public Note() throws ParseException {
		System.out.println("Veuillez saisir l'id");
		int idInput = Integer.parseInt(SaisieClavier.lire());
		System.out.println("Veuillez saisir la date (format : " + FORMAT_DATE + ")");
		String dateInput = SaisieClavier.lire();
		Date dateParsed = DATE_FORMATTER.parse(dateInput);
		System.out.println("Veuillez saisir commentaire");
		String commentaireInput = SaisieClavier.lire();

		this.idEcrivain = idInput;
		this.date = dateParsed;
		this.commentaire = commentaireInput;

	}

	public Note(int id) {
		this.idEcrivain = id;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, id);
		this.date = calendar.getTime();
		this.commentaire = "commentaire auteur " + id;
	}

	@Override
	public String toString() {
		return "Note [date=" + date + ", idEcrivain=" + idEcrivain + ", commentaire=" + commentaire + "]";
	}

	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException, ParseException {
		stream.defaultReadObject();
		this.commentaire = "commentaire inconnu";
	}
}
