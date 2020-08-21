package mybatis.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserVO {
	String 	id,
			pw,
			nickname,
			email,
			birthday,
			gender,
			profile_image,
			join_Date,
			withdraw_Date,
			grade,
			category;
}
