package spring.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class KOFIC_API {
	
	public String getYesterday() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		
		String yesterday = dateFormat.format(cal.getTime());
		
		return yesterday;
	}//end getYesterday()
	
	public String searchDailyBoxOffice() throws Exception{
		
		String apiurl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		apiurl += "?key=3fb8a3781613708291f377177803cf97";
		apiurl += "&targetDt=" + getYesterday();
		
		System.out.println(getYesterday());
		
		URL url = new URL(apiurl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		
		return response.toString();
	}
	
}
