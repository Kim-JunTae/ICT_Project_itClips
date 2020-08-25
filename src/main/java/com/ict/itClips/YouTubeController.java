package com.ict.itClips;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mybatis.vo.YouTubeVO;
import spring.util.Youtube_API;

@Controller
public class YouTubeController {
	
	@RequestMapping(value = "/searchYoutube", method = RequestMethod.GET)
	public ModelAndView searchYoutube() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<YouTubeVO> videoList = new ArrayList<YouTubeVO>();
		
		String search = "영화";
		Youtube_API youtube = new Youtube_API();
		String result = youtube.search(search);
		System.out.println(result);
		
		JsonParser jsonParser = new JsonParser();
		
		JsonObject object = (JsonObject) jsonParser.parse(result);
		JsonArray itemsArray = (JsonArray)object.get("items");
		
		//System.out.println("* items *");
		for(int i=0; i<itemsArray.size(); i++) {
			//System.out.println("=item_"+i+"=====================================");
			JsonObject itemObject = (JsonObject)itemsArray.get(i);
			
			YouTubeVO vo = new YouTubeVO();
			
			//JSON name으로 추출
			//1. id
			JsonObject id = (JsonObject)itemObject.get("id");
			vo.setVideoId(id.get("videoId").getAsString());
			
			//2. snippet
			JsonObject snippet = (JsonObject)itemObject.get("snippet");
			vo.setTitle(snippet.get("title").getAsString());
			vo.setDescription(snippet.get("description").getAsString());
			vo.setPublishedAt(snippet.get("publishedAt").getAsString());
			vo.setChannelId(snippet.get("channelId").getAsString());
			
			//3. thumbnail
			JsonObject thumbnail = (JsonObject)snippet.get("thumbnails");
			JsonObject thumbnail_default = (JsonObject)thumbnail.get("default");
			vo.setThumbnail(thumbnail_default.get("url").getAsString());
			
			videoList.add(vo);
		}
		
		mv.addObject("videoList", videoList);
		mv.setViewName("youTubeList");
		
		return mv;
	}
}
