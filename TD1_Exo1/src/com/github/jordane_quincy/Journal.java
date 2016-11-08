package com.github.jordane_quincy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Journal {
	protected Journal() throws IOException, SecurityException {
		super();
	}

	private final static String FILENAME = "data.ser";

	private static List<Note> lstNote = new ArrayList<Note>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			System.out.println("Note n° :" + i);

			Note note = new Note(i);
			lstNote.add(note);
		}

		System.out.println("Serialisation");
		try {
			writeNote();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Deserialisation");
		try {
			readNote();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void writeNote() throws FileNotFoundException, IOException, ParseException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));

		objectOutputStream.writeObject(lstNote);

		objectOutputStream.close();
	}

	@SuppressWarnings("unchecked")
	public static void readNote() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME));

		List<Note> lstNoteSerialized = (List<Note>) objectInputStream.readObject();

		for (Note noteSerialized : lstNoteSerialized) {
			System.out.println(noteSerialized);
		}

		objectInputStream.close();
	}
}
