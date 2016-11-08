package com.github.jordane_quincy;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Note implements Serializable {

	private static final long serialVersionUID = -1263091870841148920L;

	private Date date;
	private int idEcrivain;
	private transient String commentaire;

	private final String FORMAT_DATE = "yy/MM/dd";
	private final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(FORMAT_DATE);

	public Note() throws ParseException {
		// Scanner scanner = new Scanner(System.in);

		System.out.println("Veuillez saisir l'id");
		int idInput = Integer.parseInt(SaisieClavier.lire()); // scanner.nextInt();
		System.out.println("Veuillez saisir la date (format : " + FORMAT_DATE + ")");
		String dateInput = SaisieClavier.lire(); // scanner.nextLine();
		Date dateParsed = DATE_FORMATTER.parse(dateInput);
		System.out.println("Veuillez saisir commentaire");
		String commentaireInput = SaisieClavier.lire();// scanner.nextLine();

		// scanner.close();

		this.idEcrivain = idInput;
		this.date = dateParsed;
		this.commentaire = commentaireInput;

	}
}
