package mybatis.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.UserVO;

public class UserDAO {
	@Autowired
	SqlSessionTemplate template;
	
	//로그인 : LoginController
	public UserVO login(Map<String, String> map) {
		return template.selectOne("user.login", map);
	}
	
}
