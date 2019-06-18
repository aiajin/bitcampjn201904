package httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {

	public static void main(String[] args) throws IOException {

		// URLConnection : http 기반의 통신 처리
		// URL 클래의 openConnection() 메서드로 URLConnection 객체 반환

		URL url = null;
		String urlStr = "http://www.ctware.net"; // index.html

		url = new URL(urlStr);
		
		URLConnection conn = url.openConnection();
		
		BufferedReader in = null;
		
		//in = new BufferedReader(new InputStreamReader(url.openStream()));
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String str = null;
		
		while(true) {
			
			str = in.readLine();
			
			if(str == null) {
				break;
			}
			
			System.out.println(str);
			
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			

		/*
		 * System.out.println("conn.toString():" + conn);
		 * System.out.println("getAllowUserInteraction():" +
		 * conn.getAllowUserInteraction()); System.out.println("getConnectTimeout():" +
		 * conn.getConnectTimeout()); System.out.println("getContent():" +
		 * conn.getContent()); System.out.println("getContentEncoding():" +
		 * conn.getContentEncoding()); System.out.println("getContentLength():" +
		 * conn.getContentLength()); System.out.println("getContentType():" +
		 * conn.getContentType()); System.out.println("getDate():" + conn.getDate());
		 * System.out.println("getDefaultAllowUserInteraction():" +
		 * conn.getDefaultAllowUserInteraction());
		 * System.out.println("getDefaultUseCaches():" + conn.getDefaultUseCaches());
		 * System.out.println("getDoInput():" + conn.getDoInput());
		 * System.out.println("getDoOutput():" + conn.getDoOutput());
		 * System.out.println("getExpiration():" + conn.getExpiration());
		 * System.out.println("getHeaderFields():" + conn.getHeaderFields());
		 * System.out.println("getIfModifiedSince():" + conn.getIfModifiedSince());
		 * System.out.println("getLastModified():" + conn.getLastModified());
		 * System.out.println("getReadTimeout():" + conn.getReadTimeout());
		 * System.out.println("getURL():" + conn.getURL());
		 * System.out.println("getUseCaches():" + conn.getUseCaches());
		 */
	}

}
