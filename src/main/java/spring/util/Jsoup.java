package spring.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup {
	
	public List<Map<String, String>> searchDailyBoxOffice() throws Exception{
		
		//StringBuffer response = new StringBuffer();
		List<Map<String, String>> response = new ArrayList<Map<String,String>>();
	
		Document doc = org.jsoup.Jsoup.connect("https://movie.daum.net/boxoffice/weekly").get();
		
		//System.out.println(doc);
		
		Elements lis = doc.select(".list_movie li");
		
		for (Element li : lis) {
			Map<String, String> map = new Hashtable<String, String>();
			
			String title = li.select(".wrap_movie .name_movie").get(0).text();
			map.put("title", title);
			System.out.println(title);
			
			String src = li.select(".thumb_movie img").attr("src");
			map.put("src", src);
			System.out.println(src);
			
			String movieId = li.select(".wrap_desc a").get(0).attr("data-tiara-id");
			map.put("movieId", movieId);
			System.out.println(movieId);
			response.add(map);
		}
		
		return response;
	}
}
