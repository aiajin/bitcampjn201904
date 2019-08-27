package com.bitcamp.rc;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestfulClientController {
	
	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public List<MemberInfo> getAllList() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberInfo[] members = restTemplate.getForObject(
				"http://localhost:8080/mm/rest/members", 
				MemberInfo[].class);
		
		List<MemberInfo> list = Arrays.asList(members);
		
		for(MemberInfo m : list) {
			System.out.println(m);
		}
		
		
		return list;
	}
	
	
	@RequestMapping("/member/{idx}")
	@ResponseBody
	public String getMemember(
			@PathVariable("idx") int idx
			) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberInfo info = restTemplate.getForObject(
				"http://localhost:8080/mm/rest/members/{id}", 
				MemberInfo.class,
				idx);
		
		System.out.println(info);
		
		
		
		
		return null;
		
	}


	
	@RequestMapping("/member/xml/list")
	@ResponseBody
	public ListViewDataXml getMememberXml() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//restTemplate.postForObject(url, request, responseType, uriVariables)
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();

		params.add("stype", "name");
		params.add("keyword", "restApi - Test");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, new HttpHeaders());
		
		
		ListViewDataXml data = restTemplate.getForObject(
				"http://localhost:8080/mm/member/xml/memberList.xml", 
				ListViewDataXml.class,
				request);
		
		
		
//		(
//				"http://localhost:8080/mm/member/xml/memberList.xml", 
//				ListViewDataXml.class,request);
//		
		System.out.println(data.getTotalCount());
		System.out.println(data.getCurrentPageNumber());
		
		for(MemberInfoXml m : data.getMemberList()) {
			System.out.println(m);
		}
		
		
		
		
		return data;
		
	}
	

	
	@RequestMapping("/dog/xml/list")
	@ResponseBody
	public DogRestResponse getDogXml() {
		
		RestTemplate restTemplate = new RestTemplate();
		
//		DogRestResponse data = restTemplate.getForObject(
//				"http://localhost:8080/client/dog.xml", 
//				DogRestResponse.class);
		
		DogRestResponse data = restTemplate.getForObject(
				"http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?bgnde=20140301&endde=20140430&pageNo=1&numOfRows=10&upkind=417000&ServiceKey=w6tghMtfkPZl5OXy9wZ9CkT5WTgS0LAnwimWMdM2Bdqma5ru5Zf6vRLWPxELbS6A%2FZEU4mr333w4PAaHsdixGQ%3D%3D", 
				DogRestResponse.class);
		
		//System.out.println(data.getHeader().getResultCode());
		//System.out.println(data.getHeader().getResultMsg());
		System.out.println(data.getBody().getTotalCount());
		
		for(Item i : data.getBody().getItems()) {
			System.out.println(i);
		}
		
		
		
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
}
