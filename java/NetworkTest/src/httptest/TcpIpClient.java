package httptest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// 연결하기위한 소켓 생성
		Socket socket = new Socket("10.10.10.10", 7777);
		
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		
		System.out.println("[Server] " + din.readUTF());
		
		din.close();
		socket.close();
		
	
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
