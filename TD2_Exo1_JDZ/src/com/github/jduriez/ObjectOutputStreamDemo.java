package com.github.jduriez;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
	public static void main(String[] args) {

	      String s = "Hello world!";
	      int i = 897648764;
	      Produit p = new Produit("ordi", 1230.5);
	      try {

	         // create a new file with an ObjectOutputStream
	         FileOutputStream out = new FileOutputStream("test.txt");
	         ObjectOutputStream oout = new ObjectOutputStream(out);

	         // write something in the file
	         oout.writeObject(s);
	         oout.writeObject(i);
	         oout.writeObject(p);

	         // close the stream
	         oout.close();

	         // create an ObjectInputStream for the file we created before
	         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));

	         // read and print what we wrote before
	         System.out.println("" + (String) ois.readObject());
	         System.out.println("" + ois.readObject());
	         System.out.println("" + ois.readObject());
	         
	         ois.close();


	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }

	   }
}
