package com.ict.itClips;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.util.Jsoup;
import spring.util.KOFIC_API;

@Controller
public class BoxOfficeController {
	
	@ResponseBody
	@GetMapping(value="/boxOfficeJSON1", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, String>>> searchWeeklyBoxOffice() throws Exception{
		
		//KOFIC_API kofic = new KOFIC_API(); 
		//String result = kofic.searchDailyBoxOffice();
		
		Jsoup jsoup = new Jsoup();
		List<Map<String, String>> result = jsoup.searchWeeklyBoxOffice();
		
		//System.out.println(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping(value="/boxOfficeJSON2", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, String>>> searchMonthlyBoxOffice() throws Exception{
		
		Jsoup jsoup = new Jsoup();
		List<Map<String, String>> result = jsoup.searchMonthlyBoxOffice();
		
		//System.out.println(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value="/boxOfficeJSON3", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, String>>> searchYearlyBoxOffice() throws Exception{
		
		Jsoup jsoup = new Jsoup();
		List<Map<String, String>> result = jsoup.searchYearlyBoxOffice();
		
		//System.out.println(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping(value="/testJSON") public String testPage() {
	 * 
	 * return "test"; }
	 */
	
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<Map<String, String>> aaa() {
	 * 
	 * Map<String, String> result = new HashMap<>();
	 * 
	 * result.put("name", "Hong Gil Dong"); result.put("test", " Dong");
	 * //System.out.println(result); return new ResponseEntity<>(result,
	 * HttpStatus.OK); }
	 */
	
	/*
	 * @RequestMapping(value = "/searchDailyBoxOffice", method = RequestMethod.GET)
	 * public ModelAndView searchDailyBoxOffice() throws Exception{ 
	 * ModelAndView mv = new ModelAndView(); 
	 * List<BoxOfficeVO> boxOfficeList = new ArrayList<BoxOfficeVO>();
	 * 
	 * KOFIC_API kofic = new KOFIC_API(); 
	 * String dailyBoxOffice = kofic.searchDailyBoxOffice(); //System.out.println(dailyBoxOffice);
	 * 
	 * JsonParser jsonParser = new JsonParser(); JsonObject object =
	 * (JsonObject)jsonParser.parse(dailyBoxOffice);
	 * 
	 * //1.boxOfficeResult JsonObject boxOfficeResult =
	 * (JsonObject)object.get("boxOfficeResult");
	 * 
	 * String boxofficeType = boxOfficeResult.get("boxofficeType").getAsString();
	 * String showRange= boxOfficeResult.get("showRange").getAsString();
	 * 
	 * //2. dailyBoxOfficeList JsonArray dailyBoxOfficeList =
	 * (JsonArray)boxOfficeResult.get("dailyBoxOfficeList");
	 * 
	 * //3. 각각의 데이터들 vo로 for(int i=0; i<dailyBoxOfficeList.size(); i++) { JsonObject
	 * dailyBoxOfficeItem = (JsonObject)dailyBoxOfficeList.get(i);
	 * 
	 * BoxOfficeVO vo = new BoxOfficeVO();
	 * 
	 * vo.setBoxofficeType(boxofficeType); vo.setShowRange(showRange);
	 * 
	 * vo.setRnum(dailyBoxOfficeItem.get("rnum").getAsString());
	 * vo.setRank(dailyBoxOfficeItem.get("rank").getAsString());
	 * vo.setRankInten(dailyBoxOfficeItem.get("rankInten").getAsString());
	 * vo.setRankOldAndNew(dailyBoxOfficeItem.get("rankOldAndNew").getAsString());
	 * vo.setMovieCd(dailyBoxOfficeItem.get("movieCd").getAsString());
	 * vo.setMovieNm(dailyBoxOfficeItem.get("movieNm").getAsString());
	 * vo.setOpenDt(dailyBoxOfficeItem.get("openDt").getAsString());
	 * vo.setSalesAmt(dailyBoxOfficeItem.get("salesAmt").getAsString());
	 * vo.setSalesShare(dailyBoxOfficeItem.get("salesShare").getAsString());
	 * vo.setSalesInten(dailyBoxOfficeItem.get("salesInten").getAsString());
	 * vo.setSalesChange(dailyBoxOfficeItem.get("salesChange").getAsString());
	 * vo.setSalesAcc(dailyBoxOfficeItem.get("salesAcc").getAsString());
	 * vo.setAudiCnt(dailyBoxOfficeItem.get("audiCnt").getAsString());
	 * vo.setAudiInten(dailyBoxOfficeItem.get("audiInten").getAsString());
	 * vo.setAudiChange(dailyBoxOfficeItem.get("audiChange").getAsString());
	 * vo.setAudiAcc(dailyBoxOfficeItem.get("audiAcc").getAsString());
	 * vo.setScrnCnt(dailyBoxOfficeItem.get("scrnCnt").getAsString());
	 * vo.setShowCnt(dailyBoxOfficeItem.get("showCnt").getAsString());
	 * 
	 * boxOfficeList.add(vo); }
	 * 
	 * mv.addObject("boxofficeType", boxofficeType); mv.addObject("showRange",
	 * showRange); mv.addObject("boxOfficeList", boxOfficeList);
	 * mv.setViewName("boxOfficeList");
	 * 
	 * 
	 * return mv; }
	 */
}
