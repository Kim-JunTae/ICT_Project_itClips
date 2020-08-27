package spring.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mybatis.dao.BoxOfficeDAO;
import mybatis.dao.YouTubeDAO;
import mybatis.vo.BoxOfficeVO;
import mybatis.vo.YouTubeVO;

@Component
public class Scheduler {

	@Autowired
	BoxOfficeDAO boxOfficeDao;
	
	@Autowired
	YouTubeDAO youTubeDao;
	
	//매일 새벽 2시 스케줄러 가동하여 정보들 저장
	@Scheduled(cron="0 0 02 * * ?")
	public void insertDB_BoxOffice() throws Exception{
		System.out.println("scheduler : insertDB_BoxOffice");
		
		//Jsoup을 이용하여 Daum 영화 주간 박스오피스 정보를 저장하자.
		Jsoup jsoup = new Jsoup();
		List<Map<String, String>> boxOfficeList = jsoup.searchWeeklyBoxOffice();
		
		for(int i=0; i<boxOfficeList.size(); i++) {
			BoxOfficeVO vo = new BoxOfficeVO();
			vo.setMovieId(boxOfficeList.get(i).get("movieId"));
			vo.setTitle(boxOfficeList.get(i).get("title"));
			vo.setSrc(boxOfficeList.get(i).get("src"));
			
			if(boxOfficeDao.check(vo.getMovieId())) {
				boxOfficeDao.insert(vo);
				System.out.println("박스오피스 정보 저장 성공");
			}
		}
	}//end insertdB_BoxOffice();
	
	@Scheduled(cron = "0 0 02 * * ?")
	public void insertDB_YouTube() throws Exception{
		System.out.println("scheduler : insertDB_YouTube");
		
		//Jsoup을 이용하여 Daum 영화 주간 박스오피스 정보를 가져오고
		BoxOfficeVO[] boxOfficeList = boxOfficeDao.getBoxOfficeList();
		
		//YoutubeAPI를 이용하여 Youtube 영상들을 검색(1)하고 : search()
		//영상의 정보들을 저장(2)한다 : getVideoInfo()
		Youtube_API youtube = new Youtube_API();
		
		for(int i=0; i<boxOfficeList.length; i++) {
			//DB에서 영화 제목들 가져오고
			String search = boxOfficeList[i].getTitle();
			//youtube에서 검색
			List<Map<String, String>> youTubeList = new ArrayList<Map<String,String>>();
			youTubeList = youtube.search(search);
			
			for(int j=0; j<youTubeList.size(); j++) {
				YouTubeVO vo = new YouTubeVO();
				vo.setVideoId(youTubeList.get(j).get("videoId"));
				vo.setTitle(youTubeList.get(j).get("title"));
				vo.setDescription(youTubeList.get(j).get("description"));
				vo.setThumbnail(youTubeList.get(j).get("thumbnail"));
				vo.setPublishedAt(youTubeList.get(j).get("publishedAt"));
				vo.setChannelId(youTubeList.get(j).get("channelId"));
				
				//외래키 지정
				vo.setMovieId(boxOfficeList[i].getMovieId());
				//System.out.println(vo.getVideoId());
				
				if(youTubeDao.check(vo.getVideoId())) {
					youTubeDao.insert(vo);
					System.out.println("유튜브 정보 저장 성공");
				}
			}
		}
	}//end insertdB_YouTube();
	
}