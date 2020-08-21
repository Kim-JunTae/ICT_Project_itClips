package mybatis.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.UserVO;

public class UserDAO {
	@Autowired
	SqlSessionTemplate template;
	
	/* LoginController */
	//로그인
	public UserVO login(Map<String, String> map) {
		return template.selectOne("user.login", map);
	}//end login()
	
	/* JoinController */
	//아이디 중복 체크
	public UserVO getUser(String id) {
		return template.selectOne("user.get_user", id);
	}//end getUser()
	
	//아이디 중복 체크
	public UserVO getNickname(String nickname) {
		return template.selectOne("user.get_nickname", nickname);
	}//end getNickname()
	
	//이메일 중복 체크
	public UserVO getEmail(String email) {
		return template.selectOne("user.get_email", email);
	}//end getEmail()
	
	//회원가입
	public int join(UserVO vo) {
		return template.insert("user.join", vo);
	}//end join()
}
