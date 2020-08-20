package com.ict.itClips;

import java.util.Hashtable;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import mybatis.dao.CategoryDAO;
import mybatis.vo.CategoryVO;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDao;
	
	@RequestMapping(value="/getCategoryList")
	@ResponseBody
	public Map<String, StringBuffer> getCategoryList(){
		Map<String, StringBuffer> map = new Hashtable<String, StringBuffer>();
		
		CategoryVO[] ar = categoryDao.getCategoryList();
		
		StringBuffer sb = new StringBuffer();
		
		if(ar != null) {
			for(CategoryVO vo : ar) {
				sb.append(vo.getCategory_high());
				sb.append(",");
			}
		}
		
		map.put("categoryList", sb);
		return map;
	}
}
