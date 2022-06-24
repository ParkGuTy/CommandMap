package first.company.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
public class CoronaController {
	
	//2022-06-24
	//능력단위명 : 리눅스 서버
	//능력단위요소 : 리눅스 서버
	
	@GetMapping("/corona.do")
	public String corona() throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1790387/covid19CurrentStatusKorea/covid19CurrentStatusKoreaJason");
		String servicekey = "bqB%2BI0UZ%2B5ICb0BNDyrCVSsyl4Ay9wi7GYgVbG%2Fch9x8iNFRC7cr%2BkhvUdsSOzZGZAWi0qiSq6ByBndRcG2%2F2A%3D%3D";
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + servicekey);
		
		
		//System.out.println(urlBuilder.toString());///url?=key
		
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		System.out.println("응답코드 : " + conn.getResponseCode() );
		
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ( ( line = rd.readLine()) != null ) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println("결과 : " + sb.toString());
		
		
		return "corona";
	}
	@GetMapping("/corona2.do")
	public ModelAndView corona2() throws Exception {
		ModelAndView mv = new ModelAndView("corena");
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1790387/covid19CurrentStatusKorea/covid19CurrentStatusKoreaJason");
		String servicekey = "bqB%2BI0UZ%2B5ICb0BNDyrCVSsyl4Ay9wi7GYgVbG%2Fch9x8iNFRC7cr%2BkhvUdsSOzZGZAWi0qiSq6ByBndRcG2%2F2A%3D%3D";
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + servicekey);
		
		
		//System.out.println(urlBuilder.toString());///url?=key
		
		
		URL url = new URL(urlBuilder.toString());
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(url.openStream()));		
		
		Map<String, Object> map = (Map<String, Object>) jsonObject.get("response");
		System.out.println("맵으로 바꿀 결과 response : " + map); //?
		
		//map = (Map<String, Object>) map.get("body");
		JSONArray arr = (JSONArray) map.get("result");
		System.out.println("map으루 바꾼 결과 result : " + arr); //?
		System.out.println(arr.size());//?
		System.out.println(arr.get(0));
		
		map = (Map<String, Object>) arr.get(0);
		System.out.println("array에서 뽑은 map : " + map);
		
		mv.addObject("map", map);
		return mv;
	}
	
	@GetMapping("/corona3.do")
	public ModelAndView corona3() throws Exception {
		ModelAndView mv = new ModelAndView("corona3");
		String key = "bqB%2BI0UZ%2B5ICb0BNDyrCVSsyl4Ay9wi7GYgVbG%2Fch9x8iNFRC7cr%2BkhvUdsSOzZGZAWi0qiSq6ByBndRcG2%2F2A%3D%3D";
		
		StringBuilder sb = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson");
		sb.append("?" + URLEncoder.encode("servicekey","UTF-8") + "=" + key );
		sb.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + 100 );
		sb.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=1" );
		sb.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=20220601" );
		sb.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=20220624" );
		
		URL url = new URL(sb.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("content-type", "application/json");
		System.out.println("응답코드 : " + conn.getResponseCode());
		
		BufferedReader br = null;
		
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder result = new StringBuilder();
		String line = null;
		
		while ( ( line = br.readLine()) != null ) {
			result.append(line);
		}
		br.close();
		conn.disconnect();
		
		System.out.println(result);
		return mv;
	}
	
	@GetMapping("/corona4.do")
	public ModelAndView corona4() throws ParserConfigurationException, SAXException, IOException {
		ModelAndView mv = new ModelAndView("corona4");
		//xml파일을 불러서 화면에 출력하기
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("c:\\Temp\\corona.xml");
		document.getDocumentElement().normalize();
		
		System.out.println("읽어온 문서 : " + document.getDocumentElement().getNodeName());
		Element root = document.getDocumentElement();
		System.out.println("root : " + root);
		
		NodeList list = document.getElementsByTagName("item");
		System.out.println("list의 길이 : " + list.getLength()); //22
		System.out.println("list의 내용 : " + list.toString());
		
		ArrayList<Map<String, Object>> coronaList = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.getLength(); i++) {
			NodeList childList = list.item(i).getChildNodes();
			Map<String, Object> value = new HashMap<String, Object>();
			for (int j = 0; j < childList.getLength(); j++) {
				Node node = childList.item(j);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					value.put(node.getNodeName(), node.getTextContent());
					
				}
			}
			System.out.println("map 내용 : " + value);
			coronaList.add(value);
		}
			
		mv.addObject("coronaList", coronaList);
		return mv;
	}
}
