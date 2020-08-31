package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.BoxOfficeVO;
import mybatis.vo.CategoryVO;

public class BoxOfficeDAO {
	@Autowired
	SqlSessionTemplate template;
	
	/* Scheduler Controller */
	//저장 전 박스오피스 내용 중복 확인
	public boolean check(String movieId) {
		boolean check = false;
		
		if(template.selectOne("boxOffice.check", movieId) == null)//중복값 없음
			check = true;
	
		return check;
	}
	
	//크롤링한 박스오피스 정보 저장
	public int insert(BoxOfficeVO vo) {
		return template.insert("boxOffice.insert", vo);
	}
	
	//박스오피스 정보 가져오기
	public String getMovieId(String title) {
		return template.selectOne("boxOffice.getMovieId", title);
	}
	
	//박스오피스 정보 리스트 가져오기
	public BoxOfficeVO[] getBoxOfficeList() {
		BoxOfficeVO[] ar = null;
		
		List<BoxOfficeVO> list = template.selectList("boxOffice.select");
		if(list != null && list.size() > 0) {
			ar = new BoxOfficeVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	//박스오피스 정보 리스트 가져오기
	public BoxOfficeVO[] getMovieIdList() {
		BoxOfficeVO[] ar = null;
		
		List<BoxOfficeVO> list = template.selectList("boxOffice.getMovieIdList");
		if(list != null && list.size() > 0) {
			ar = new BoxOfficeVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
}
