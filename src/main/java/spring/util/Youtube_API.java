package spring.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Youtube_API {
	public List<Map<String, String>> search(String search) throws IOException {
		List<Map<String, String>> response = new ArrayList<Map<String,String>>();
		
		String apiurl = "https://www.googleapis.com/youtube/v3/search";
		//apiurl += "?key=AIzaSyCNY8isLFGtuy_mRV23YNPdJRY0-TrwVZk";	//내꺼
		apiurl += "?key=AIzaSyCeJAeERHKe0jkfUaL1czciAEtdHyXGD0A";	//현진씨꺼
		apiurl += "&part=snippet&type=video&maxResults=10&videoEmbeddable=true";
		apiurl += "&q="+URLEncoder.encode(search,"UTF-8");
		
		URL url = new URL(apiurl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		String inputLine;
		StringBuffer result = new StringBuffer();
		while((inputLine = br.readLine()) != null) {
			result.append(inputLine);
		}
		br.close();
		
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject) jsonParser.parse(result.toString());
		JsonArray itemsArray = (JsonArray)object.get("items");
		
		for(int i=0; i<itemsArray.size(); i++) {
			JsonObject itemObject = (JsonObject)itemsArray.get(i);
			
			Map<String, String> map = new Hashtable<String, String>();
			
			//JSON name으로 추출
			//1. id
			JsonObject id = (JsonObject)itemObject.get("id");
			map.put("videoId", id.get("videoId").getAsString());
			
			//2. snippet
			JsonObject snippet = (JsonObject)itemObject.get("snippet");
			map.put("title", snippet.get("title").getAsString());
			map.put("description", snippet.get("description").getAsString());
			map.put("publishedAt", snippet.get("publishedAt").getAsString());
			map.put("channelId", snippet.get("channelId").getAsString());
			
			//3. thumbnail
			JsonObject thumbnail = (JsonObject)snippet.get("thumbnails");
			JsonObject thumbnail_default = (JsonObject)thumbnail.get("default");
			
			map.put("thumbnail", thumbnail_default.get("url").getAsString());
			
			response.add(map);
		}
		return response;
	}
	
	public String getVideoInfo(String movieId) throws IOException {
		
		String apiurl = "https://www.googleapis.com/youtube/v3/videos";
		apiurl += "?key=AIzaSyCNY8isLFGtuy_mRV23YNPdJRY0-TrwVZk";
		apiurl += "&part=snippet,statistics";
		apiurl += "&id="+URLEncoder.encode(movieId,"UTF-8");
		
		URL url = new URL(apiurl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		
		return response.toString();
	}
	
	

//	public String search(String search) throws IOException {
//		
//		String apiurl = "https://www.googleapis.com/youtube/v3/search";
//		apiurl += "?key=AIzaSyCNY8isLFGtuy_mRV23YNPdJRY0-TrwVZk";
//		apiurl += "&part=snippet&type=video&maxResults=20&videoEmbeddable=true";
//		apiurl += "&q="+URLEncoder.encode(search,"UTF-8");
//		
//		URL url = new URL(apiurl);
//		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//		con.setRequestMethod("GET");
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//		while((inputLine = br.readLine()) != null) {
//			response.append(inputLine);
//		}
//		br.close();
//		
//		return response.toString();
//	}
}
