package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import mybatis.vo.YouTubeVO;

public class YouTubeDAO {
	@Autowired
	SqlSessionTemplate template;
	
	/* YouTubeController */
	public YouTubeVO[] getYouTubeList(String movieId) {
		YouTubeVO[] ar = null;
		
		List<YouTubeVO> list = template.selectList("youTube.getYouTubeList", movieId);
		if(list != null && list.size() > 0) {
			ar = new YouTubeVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}//end getYouTubeList()
	
	/* Scheduler */
	//저장 전 유튜브 내용 중복 확인
	public boolean check(String	videoId) {
		boolean check = false;
		
		if(template.selectOne("youTube.check", videoId) == null)//중복값 없음
			check = true;
	
		return check;
	}
	
	//크롤링한 유튜브 정보 저장
	public int insert(YouTubeVO vo) {
		return template.insert("youTube.insert", vo);
	}
}
