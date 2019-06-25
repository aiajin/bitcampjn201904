package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	
	// Cookie 데이터들을 Map에 저장해서 관리
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	
	// 생성자 : 초기화 -> request 객체에서 Cookie[] 받아서 cookieMap 에 저장
	public CookieBox(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length>0) {
			// 반복처리 : Cookie 객체를 Map에 저장
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				
				cookieMap.put(c.getName(), c);
			}
		}
		
	}
	
	// 쿠키 생성하는 메서드 : 이름, 데이터
	public static Cookie createCookie(String name, String value) {
		Cookie c = new Cookie(name, value);
		return c;
	}
	
	// 쿠키 생성 메서드 : 이름, 데이터, 유효시간
	public static Cookie createCookie(String name, String value, int macAge) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(macAge);
		return c;
	}
	
	// 쿠키 생성 메서드 : 이름, 데이터, 유효시간, 경로(path)
	public static Cookie createCookie(String name, String value, int macAge, String path) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(macAge);
		c.setPath(path);
		return c;
	}
	
	// 쿠키 생성 메서드 : 이름, 데이터, 유효시간, 경로(path), 도메인
	public static Cookie createCookie(String name, String value, int macAge, String path, String domain) {
		Cookie c = new Cookie(name, value);
		c.setMaxAge(macAge);
		c.setPath(path);
		c.setDomain(domain);
		return c;
	}
	
	// 쿠키 정보 반환하는 메서드
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	// 쿠키의 데이터 반환메서드
	public String getValue(String name) {
		Cookie c = cookieMap.get(name);
		
		if(c == null) {
			return null;
		}
		
		return c.getValue();
	}
	
	// 쿠키 존재 여부 확인 메서드
	public boolean exists(String name) {
		return cookieMap.get(name) != null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
