package com.ict.itClips;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mybatis.dao.BoxOfficeDAO;
import mybatis.vo.BoxOfficeVO;
import spring.util.Jsoup;

@Component
public class SchedulerController {
	
//	@Autowired
//	BoxOfficeDAO boxOfficeDao;
//	
//	//새벽 2시 스케줄러 가동하여 정보들 저장
//	@Scheduled(cron = "*/30 * * * * *")
//	public void insertDB() throws Exception{
//		System.out.println("scheduler testing.....");
//		
//		//Jsoup을 이용하여 Daum 영화 주간 박스오피스 정보를 저장하자.
//		Jsoup jsoup = new Jsoup();
//		List<Map<String, String>> boxOfficeList = jsoup.searchWeeklyBoxOffice();
//		
//		for(int i=0; i<boxOfficeList.size(); i++) {
//			BoxOfficeVO vo = new BoxOfficeVO();
//			vo.setMovieId(boxOfficeList.get(i).get("movieId"));
//			vo.setTitle(boxOfficeList.get(i).get("title"));
//			vo.setSrc(boxOfficeList.get(i).get("src"));
//			
//			if(boxOfficeDao.check(vo.getMovieId())) {
//				boxOfficeDao.insert(vo);
//				System.out.println("박스오피스 정보 저장 성공");
//			}
//		}
//	}//end insertdB();
	
}