package DistributedProgramming.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {

	private BufferedReader in;
	private PrintWriter out;

	void doConnections(Socket socket) throws IOException {
		in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream())),
				true);
	}

	private void serve() throws IOException {
		while (true) {
			String str = in.readLine();
			if (str.equals("FIM"))
				break;
			System.out.println("Eco:" + str);
			out.println(str);
		}
	}

	public static final int PORTO = 8080;
	public static void main(String[] args) {
		try {
			new SimpleServer().startServing();
		} catch (IOException e) {
			// ...
		}
	}

	public void startServing() throws IOException {
		ServerSocket ss = new ServerSocket(PORTO);
		try {
			Socket socket = ss.accept();
			try {//Conexao aceite
				doConnections(socket);
				serve();
			} finally {//a fechar
				socket.close();
			}
		} finally {
			ss.close();
		}
	}
}
