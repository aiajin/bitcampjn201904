package httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {

	// 1. 접속한 사용자들을 Map 저장 -> 모든 사용자에 메시지 전송
	// 2. name, 사용자별 소켓을 이용한 쓰레스(기능:받고, 전체 사용자에게 전송 )
	// 쓰레드 생성 : 1. 전체 메시지 보내기 2. Map 저장
	// 3. 멀티 쳇 : 누가 언제 들어와도 체팅이 가능한 체팅 기능 - while(true) , socket.accept()

	HashMap<String,Object> clients;

	public TcpIpMultichatServer() {
		clients = new HashMap<String,Object>();
		Collections.synchronizedMap(clients);
	}

	public void start() throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;

		serverSocket = new ServerSocket(7777);
		System.out.println("서버가 시작되었습니다.");

		while (true) {
			socket = serverSocket.accept();
			System.out.println("["+socket.getInetAddress() 
			+ ":" + socket.getPort() +"] 사용자가 접속했습니다.");
			
			ServerReceiver receiver = new ServerReceiver(socket);
			receiver.start();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new TcpIpMultichatServer().start();
	}

	
	void sendToAll(String msg) {
		Iterator itr = clients.keySet().iterator();
		while(itr.hasNext()) {
			DataOutputStream dout = (DataOutputStream) clients.get(itr.next());
			try {
				dout.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		public ServerReceiver(Socket s) {
			socket = s;
			try {
				in = new DataInputStream(s.getInputStream());
				out = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void run() {
			String name = "";
			
			
			
			try {
				name = in.readUTF();
				clients.put(name, out);
				// 전체 사용자에게 접속 안내 메시지를 보내기
				
				sendToAll("###" + name + "님이 접속하셨습니다.");
				
				
				
				while(in!=null) {
					sendToAll(in.readUTF());
				}
				
				
				
				
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println(name + "님이 나가셨습니다.");
				clients.remove(name);
			}
		}
		
		
	}

}














