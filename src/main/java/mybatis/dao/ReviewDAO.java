package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.ReviewVO;

public class ReviewDAO {
	@Autowired
	SqlSessionTemplate template;
	
	/* Scheduler Controller */
	//저장 전 리뷰 내용 중복 확인
	public boolean check(String movieId, String netizenName) {
		boolean check = false;
		Map<String, String> map = new Hashtable<String, String>();
		map.put("movieId", movieId);
		map.put("netizenName", netizenName);
		
		if(template.selectOne("review.check", map) == null)//중복값 없음
			check = true;
	
		return check;
	}
	
	//크롤링한 리뷰 정보 저장
	public int insert(ReviewVO vo) {
		return template.insert("review.insert", vo);
	}
	
	//리뷰 정보 리스트 가져오기
	public ReviewVO[] getReviewList(String movieId) {
		ReviewVO[] ar = null;
		
		List<ReviewVO> list = template.selectList("review.getReviewList", movieId);
		if(list != null && list.size()>0) {
			ar = new ReviewVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	//리뷰 정보 리스트 가져오기
	public ReviewVO[] reviewJSON(String movieId) {
		ReviewVO[] ar = null;
		
		List<ReviewVO> list = template.selectList("review.reviewJSON", movieId);
		if(list != null && list.size()>0) {
			ar = new ReviewVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	
}
