package mybatis.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.CategoryVO;

public class CategoryDAO {
	@Autowired
	SqlSessionTemplate template;
	
	//취향 리스트 가져오기: CategoryController, 등등
	public CategoryVO[] getCategoryList() {
		CategoryVO[] ar = null;
		
		List<CategoryVO> list = template.selectList("category.get_categoryHighList");
		if(list != null && list.size() > 0) {
			ar = new CategoryVO[list.size()];
			list.toArray(ar);
		}
	
		return ar;
	}
	
}
