package httptest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		int cnt =0;
		
		serverSocket = new ServerSocket(7777);
		System.out.println(getTime() + " 서버가 준비되었습니다.");
		
		while(true) {
			System.out.println(getTime()+ " 연결을 기다립니다.");
			
			Socket socket = serverSocket.accept();// 기다린다!!!
			// 요청을 받으면 ServerSocket기 새로운 연결 Socket을 생성
			
			System.out.println(getTime() + socket.getInetAddress() + "로 부터 연결 요청이 있습니다. 연결합니다.");
			
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeUTF("안녕하세요. from Server (" + cnt++ + ")" );
			System.out.println(getTime() + " 메시지 전송");
			
			dos.close();
			socket.close();
			
		}

	}
	
	public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");
		
		return format.format(new Date());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
