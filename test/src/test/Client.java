package test;

import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 1080;
		Scanner userIn = new Scanner(System.in);
		try {
			Socket socket = new Socket(host, port);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String userInput;
			while(!"exit".equals(userInput=userIn.nextLine())){
				out.println(userInput);
				System.out.println("收到服务端回应："+ in.readLine());
			}
			userIn.close();
			socket.close();
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
