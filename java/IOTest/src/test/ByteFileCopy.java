package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy {

	public static void main(String[] args) throws IOException {
		
		InputStream in = new FileInputStream("penguins.jpg");
		OutputStream out = new FileOutputStream("copy.jpg");
		
		int copyByte = 0; // 전송된 사이즈 카운트
		int bData = 0;    // 스트림을 통해 전송받은 데이터 : byte
		int readLen = 0;
		byte[] buf = new byte[1024];
		
		while(true) {
			// 파일 데이터 읽기
			//bData = in.read(); 
			// byte 사이즈의 데이터, 모두 전송된 후에는 -1
			
			readLen = in.read(buf);
			
			/*
			 * if(bData<0) { break; }
			 */
			if (readLen == -1) {
				break;
			}
			
			// 파일 쓰기
			//out.write(bData);
			out.write(buf, 0, readLen);
			
			//copyByte++;
			
			copyByte += readLen;
			
		}
		
		// 스트림 닫기
		in.close();
		out.close();
		
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 Byte 크기 : " + copyByte);

	}

	
	
	
	
	
	
	
	
	
	
}
