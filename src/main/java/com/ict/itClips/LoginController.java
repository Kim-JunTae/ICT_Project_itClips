package com.ict.itClips;

import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import mybatis.dao.UserDAO;
import mybatis.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserDAO userDao;

	// user 정보를 담을 session
	@Autowired
	private HttpSession session;
	
	//logout할 request
	private HttpServletRequest request;
	
	@RequestMapping(value = "/checkLogin")
	@ResponseBody
	public Map<String, String> login(UserVO vo) {
		Map<String, String> check = new Hashtable<String, String>();
		
		
		Map<String, String> map = new Hashtable<String, String>();
		map.put("id", vo.getId());
		map.put("pw", vo.getPw());
		
		UserVO userVO = null;
		userVO = userDao.login(map);
		
		if(userVO != null) {//로그인 성공
			session.setAttribute("id", userVO.getId());
			session.setAttribute("nickname", userVO.getNickname());
			
			check.put("chk", "0");
			check.put("res","로그인 성공");
			System.out.println("로그인 성공!");
		}else{//로그인 실패
			check.put("chk", "1");
			check.put("res","로그인 실패");
			System.out.println("로그인 실패");
		}
		
		return check;
	}
	
	
  @RequestMapping(value="/logout") 
  public String logout(HttpSession session) { 
	  session.invalidate();
	  System.out.println("로그아웃 성공!"); 
	  return "userHome"; 
  }
	 
	
}
