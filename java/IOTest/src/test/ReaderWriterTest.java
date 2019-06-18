package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriterTest {

	public static void main(String[] args) throws IOException {

		char c1 = 'A';
		char c2 = 'B';

		Writer writer = new FileWriter("test.txt");

		writer.write(c1);
		writer.write(c2);
		writer.write(c1);
		writer.write(c2);
		writer.write(c1);
		writer.write(c2);
		writer.write(c1);
		writer.write(c2);

		writer.close();

		System.out.println("파일이 작성/생성되었습니다.");

		Reader reader = new FileReader("test.txt");

		char[] cBuf = new char[10];
		int readCnt = 0;

		readCnt = reader.read(cBuf, 0, cBuf.length);

		for (int i = 0; i < readCnt; i++) {
			System.out.println(cBuf[i]);
		}

		reader.close();

		BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"));
		out.write("손흥민 – 리버플전에 골을 넣는데 집중하겠다.");
		out.newLine();
		out.write("올 시즌은 나에게 있어 최고의 시즌이다.");
		out.newLine();
		out.write("팀이 승리하는 것을 돕기 위해 최선을 다하겠다.");
		out.newLine();
		out.write("환상적인 결승전이 될 것이다.");
		out.newLine();
		out.newLine();
		out.write("기사 제보 및 보도자료");
		out.newLine();
		out.write("press@goodnews.co.kr");
		out.close();
		System.out.println("기사 입력 완료.");
		
		
		System.out.println("기사 읽기 시작");
		
		BufferedReader reader2 = new BufferedReader(new FileReader("String.txt"));
		
		String str = null;
		
		while(true) {
			str = reader2.readLine();
			if(str == null) {
				break;
			}
			System.out.println(str);
		}
		
		reader2.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
