package com.ict.itClips;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import mybatis.dao.BoxOfficeDAO;
import mybatis.dao.YouTubeDAO;
import mybatis.vo.BoxOfficeVO;
import mybatis.vo.YouTubeVO;
import spring.util.Youtube_API;

@Controller
public class YouTubeController {
	
	@Autowired
	BoxOfficeDAO boxOfficeDao;
	
	@Autowired
	YouTubeDAO youTubeDao;
	
	@ResponseBody
	@GetMapping(value="/searchYouTube", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, String>>> searchYoutube(String searchTitleName) throws Exception{
		
		Youtube_API youtube = new Youtube_API();
		
		List<Map<String, String>> result = youtube.search(searchTitleName);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//작업해야할것
	//유튜브에서 검색한 내용을 DB에 spring.util의 Scheduler에서 DB에 저장하였고
	//userHome.jsp에서 boxoffice의 영화 포스터를 클릭하거나 검색하였을 때
	//DB의 YouTube 테이블에 접근하여 가져오는 함수이다.
	
	@ResponseBody
	@GetMapping(value="/getYouTubeList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<YouTubeVO[]> getYouTubeList(String searchTitle) throws Exception{
		
		//title을 받아서 boxOffice 테이블에서 검색하여 movieId 값을 받아서 YouTube 테이블로 가야된다.
		String movieId = boxOfficeDao.getMovieId(searchTitle);
		
		YouTubeVO[] result = youTubeDao.getYouTubeList(movieId);
		//문제점 : vo배열로 주어도 JSON으로 표현이 될까? : 확인하려면? => 표현됨
		
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
