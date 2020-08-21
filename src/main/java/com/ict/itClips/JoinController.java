package com.ict.itClips;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.CategoryDAO;
import mybatis.dao.UserDAO;
import mybatis.vo.CategoryVO;
import mybatis.vo.UserVO;

@Controller
public class JoinController {
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	//회원가입 폼으로 이동
	@RequestMapping(value="join", method = RequestMethod.GET)
	public ModelAndView join() {
		ModelAndView mv = new ModelAndView();
		
		//카테고리 리스트 가져오기
		CategoryVO[] ar = categoryDao.getCategoryList();
		
		mv.addObject("clist", ar);
		mv.addObject("clistLength", ar.length);
		mv.setViewName("join");
		return mv;
	}
	
	//회원가입
	@RequestMapping(value="join", method = RequestMethod.POST)
	public ModelAndView join(UserVO vo) {
		ModelAndView mv = new ModelAndView();
		
		//UserVO 받아서 UserDAO에서 insert문을 user.xml 
		//mapper에서 가져와서 회원가입한 후 UserHome으로 돌아간다.
		int joinCheck = userDao.join(vo);
		
		if(joinCheck == 1) {
			System.out.println("회원가입 성공");
			mv.addObject("message", "회원가입을 축하합니다! 로그인을 해주세요");
		}else{
			System.out.println("회원가입 실패");
		}
		
		mv.setViewName("userHome");
		
		return mv;
	}//end join()
	
	
	//아이디 중복 검사
	@RequestMapping(value="/checkId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> checkId(String id){
		Map<String, String> map = new Hashtable<String, String>();
		
		//인자로 넘어온 id값이 이미 있다면 UserVO가 null이 아니고,
		//사용할 수 없는 아이디가 된다. 하지만 UserVO가 null이면
		//사용가능한 아이디가 된다.
		UserVO vo = userDao.getUser(id);
		if(vo != null) {
			map.put("chk","0");
			map.put("res", "<span class='red_txt'>아이디 사용불가(중복)</span>");
		}else{
			map.put("chk","1");
			map.put("res", "<span class='blue_txt'>아이디 사용가능</span>");
		}
		return map;
	}
	
	//닉네임 중복 검사
	@RequestMapping(value="/checkNickname", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> checkNickname(String nickname){
		Map<String, String> map = new Hashtable<String, String>();
		
		//인자로 넘어온 id값이 이미 있다면 UserVO가 null이 아니고,
		//사용할 수 없는 아이디가 된다. 하지만 UserVO가 null이면
		//사용가능한 아이디가 된다.
		UserVO vo = userDao.getNickname(nickname);
		if(vo != null) {
			map.put("chk","0");
			map.put("res", "<span class='red_txt'>이미 사용하고 있는 닉네임입니다.</span>");
		}else{
			map.put("chk","1");
			map.put("res", "<span class='blue_txt'>사용 가능한 닉네임입니다.</span>");
		}
		return map;
	}
	
	//이메일 중복 검사
	@RequestMapping(value="/checkEmail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> checkEmail(String email){
		Map<String, String> map = new Hashtable<String, String>();
		
		//인자로 넘어온 id값이 이미 있다면 UserVO가 null이 아니고,
		//사용할 수 없는 아이디가 된다. 하지만 UserVO가 null이면
		//사용가능한 아이디가 된다.
		UserVO vo = userDao.getEmail(email);
		if(vo != null) {
			map.put("chk","0");
			map.put("res", "<span class='red_txt'>이미 사용하고 있는 이메일입니다.</span>");
		}else{
			map.put("chk","1");
			map.put("res", "<span class='blue_txt'>사용 가능한 이메일입니다.</span>");
		}
		return map;
	}
	
	
}
