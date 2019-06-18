package httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpServer5 {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;

		// 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");

			socket = serverSocket.accept();

			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Sender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;

	public Sender(Socket socket) throws IOException {

		this.socket = socket;

		out = new DataOutputStream(socket.getOutputStream());
		name = "[" + socket.getInetAddress() + ":" + socket.getPort() + "]";
	}

	public void run() {

		Scanner sc = new Scanner(System.in);

		while (out != null) {
			try {
				out.writeUTF(name + sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Receiver extends Thread {

	Socket socket;
	DataInputStream in;

	public Receiver(Socket s) throws IOException {
		socket = s;
		in = new DataInputStream(s.getInputStream());
	}

	public void run() {

		while (in != null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
