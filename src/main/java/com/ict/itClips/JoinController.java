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
	
	@RequestMapping(value="join", method = RequestMethod.GET)
	public ModelAndView join() {
		ModelAndView mv = new ModelAndView();
		
		CategoryVO[] ar = categoryDao.getCategoryList();
		
		mv.addObject("clist", ar);
		mv.setViewName("join");
		return mv;
	}
	
	@RequestMapping(value="/checkId")
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
	
}
