package httptest;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient5 {

	public static void main(String[] args){
		
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("서버 연결 성공!");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
				
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
}
