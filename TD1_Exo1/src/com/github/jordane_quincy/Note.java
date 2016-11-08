package com.github.jordane_quincy;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Serializable {

	private static final long serialVersionUID = -1263091870841148920L;

	private int idEcrivain;
	private Date date;
	private transient String commentaire;

	private final String FORMAT_DATE = "yy/MM/dd";
	private final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(FORMAT_DATE);

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

	@Override
	public String toString() {
		return "Note [date=" + date + ", idEcrivain=" + idEcrivain + ", commentaire=" + commentaire + "]";
	}

	// private void readObject(java.io.ObjectInputStream stream) throws
	// IOException, ClassNotFoundException {
	// this.idEcrivain = stream.readInt();
	// this.date = (Date) stream.readObject();
	// this.commentaire = "commentaire inconnu";
	// }
}
