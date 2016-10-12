package com.java.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Alex
 * @version 1.0
 * @since
 *
 */
public class SocketServer {

	public static void main(String[] args) {
		try {
			ServerSocket server = null;
			int port = 2048;
			try {
				server = new ServerSocket(port);
			} catch (IOException e) {
				System.out.println("can not lisent to " + port);
				e.printStackTrace();
			}

			Socket socket = null;

			socket = server.accept();

			String line;

			BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

			BufferedReader msgIn = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Client:\t" + socketIn.readLine());

			line = msgIn.readLine();

			while (!line.equals("bye")) {
				// 向客户端输出该字符串
				socketOut.println(line);
				// 刷新输出流，使Client马上收到该字符串
				socketOut.flush();
				System.out.println("Server:\t" + line);
				System.out.println("Client:\t" + socketIn.readLine());
				line = msgIn.readLine();
			}
			socketOut.close();
			socketIn.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

}
