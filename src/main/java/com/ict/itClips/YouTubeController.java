package com.ict.itClips;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.util.Youtube_API;

@Controller
public class YouTubeController {
	
	@ResponseBody
	@GetMapping(value="/searchYoutube", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, String>>> searchYoutube(String searchTitleName) throws Exception{
		
		Youtube_API youtube = new Youtube_API();
		
		List<Map<String, String>> result = youtube.search(searchTitleName);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/searchYoutube", method = RequestMethod.GET)
//	public ModelAndView searchYoutube(String searchTitleName) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		List<YouTubeVO> videoList = new ArrayList<YouTubeVO>();
//		
//		//searchTitleName = "영화제목";
//		Youtube_API youtube = new Youtube_API();
//		String result = youtube.search(searchTitleName);
//		System.out.println(result);
//		
//		JsonParser jsonParser = new JsonParser();
//		
//		JsonObject object = (JsonObject) jsonParser.parse(result);
//		JsonArray itemsArray = (JsonArray)object.get("items");
//		
//		//System.out.println("* items *");
//		for(int i=0; i<itemsArray.size(); i++) {
//			//System.out.println("=item_"+i+"=====================================");
//			JsonObject itemObject = (JsonObject)itemsArray.get(i);
//			
//			YouTubeVO vo = new YouTubeVO();
//			
//			//JSON name으로 추출
//			//1. id
//			JsonObject id = (JsonObject)itemObject.get("id");
//			vo.setVideoId(id.get("videoId").getAsString());
//			
//			//2. snippet
//			JsonObject snippet = (JsonObject)itemObject.get("snippet");
//			vo.setTitle(snippet.get("title").getAsString());
//			vo.setDescription(snippet.get("description").getAsString());
//			vo.setPublishedAt(snippet.get("publishedAt").getAsString());
//			vo.setChannelId(snippet.get("channelId").getAsString());
//			
//			//3. thumbnail
//			JsonObject thumbnail = (JsonObject)snippet.get("thumbnails");
//			JsonObject thumbnail_default = (JsonObject)thumbnail.get("default");
//			vo.setThumbnail(thumbnail_default.get("url").getAsString());
//			
//			videoList.add(vo);
//		}
//		
//		mv.addObject("videoList", videoList);
//		mv.setViewName("youTubeList");
//		
//		return mv;
//	}
}
