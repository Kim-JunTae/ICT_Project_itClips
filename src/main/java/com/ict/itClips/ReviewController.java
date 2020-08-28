package com.ict.itClips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mybatis.dao.BoxOfficeDAO;
import mybatis.dao.ReviewDAO;
import mybatis.vo.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired
	BoxOfficeDAO boxOfficeDao;
	
	@Autowired
	ReviewDAO reviewDao;

	//4개만 가져옴
	@ResponseBody
	@GetMapping(value="/reviewJSON", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReviewVO[]> reviewJSON(String searchTitle) throws Exception{
		
		//title을 받아서 boxOffice 테이블에서 검색하여 movieId 값을 받아서 YouTube 테이블로 가야된다.
		String movieId = boxOfficeDao.getMovieId(searchTitle);
		//System.out.println(movieId);
		
		ReviewVO[] result = reviewDao.reviewJSON(movieId);
		//System.out.println(result);//null값왜 나오지
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//다 가져옴
	@ResponseBody
	@GetMapping(value="/getReviewList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReviewVO[]> getReviewList(String searchTitle) throws Exception{
		
		//title을 받아서 boxOffice 테이블에서 검색하여 movieId 값을 받아서 YouTube 테이블로 가야된다.
		String movieId = boxOfficeDao.getMovieId(searchTitle);
		
		ReviewVO[] result = reviewDao.getReviewList(movieId);
		//문제점 : vo배열로 주어도 JSON으로 표현이 될까? : 확인하려면? => 표현됨
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
