package com.github.JDZ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;


public class Journal {
	private final static String FILENAME = "data.ser";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			writeNote();
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			readNote();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void writeNote() throws ParseException, FileNotFoundException, IOException {
		Note note = new Note();
		System.out.println("On va écrire la note suivant :");
		System.out.println(note);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
		objectOutputStream.writeObject(note);
		
		ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream(FILENAME, true)) {
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        };
        note = new Note();
        System.out.println("On va écrire la note suivant :");
		System.out.println(note);
        os2.writeObject(note);
        os2.close();
		
		objectOutputStream.close();
	}
	
	public static void readNote() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME));
		Note noteSerialized = (Note) objectInputStream.readObject();
		Note noteSerialized2 = (Note) objectInputStream.readObject();
		System.out.println(noteSerialized);
		System.out.println(noteSerialized2);
		objectInputStream.close();
	}
}
