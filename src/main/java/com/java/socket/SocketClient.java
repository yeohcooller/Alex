package com.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author Alex
 * @version 1.0
 * @since
 *
 */
public class SocketClient {
	public static void main(String args[]) {
		try {
			Socket socket = new Socket("127.0.0.1", 2048);

			BufferedReader msgIn = new BufferedReader(new InputStreamReader(System.in));

			PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String readLine;

			readLine = msgIn.readLine();

			while (!readLine.equals("bye")) {
				System.out.println("Client:\t" + readLine);
				socketOut.println(readLine);
				socketOut.flush();
				System.out.println("Server:\t" + socketIn.readLine());
				readLine = msgIn.readLine();
			}
			socketOut.close();
			socketIn.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
