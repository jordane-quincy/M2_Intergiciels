package com.github.jduriez;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class EchoClient {
	 Socket theSocket; DataInputStream theInputStream; DataInputStream userInput; PrintStream theOutputStream;
	 String theLine; try { theSocket = new Socket(args[0], Integer.parseInt(args[1])); theInputStream = new DataInputStream(theSocket.getInputStream()); theOutputStream = new PrintStream(theSocket.getOutputStream()); userInput = new DataInputStream(System.in); while (true) { theLine = userInput.readLine();
	 if (theLine.equals(".")) break; theOutputStream.println(theLine); System.out.println(theInputStream.readLine());
	 }
	 } catch (UnknownHostException e) { System.err.println(e);
	 } catch (IOException e) { System.err.println(e); } } } 
}
