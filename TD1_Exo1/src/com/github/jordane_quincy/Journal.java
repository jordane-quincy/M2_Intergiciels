package com.github.jordane_quincy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

public class Journal {
	protected Journal() throws IOException, SecurityException {
		super();
	}

	private final static String FILENAME = "data.ser";

	public static void main(String[] args) {
		try {
			writeNote();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			readNote();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeNote() throws FileNotFoundException, IOException, ParseException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));

		Note maNote = new Note();

		objectOutputStream.writeObject(maNote);

		objectOutputStream.close();
	}

	public static void readNote() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME));

		Note noteSerialized = (Note) objectInputStream.readObject();

		System.out.println(noteSerialized);

		objectInputStream.close();
	}
}
