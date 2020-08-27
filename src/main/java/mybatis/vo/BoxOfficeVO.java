package mybatis.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoxOfficeVO {
	private String 	movieId,
					title,
					src;

	@Override
	public String toString() {
		return "BoxOfficeVO [movieId=" + movieId + ", title=" + title + ", src=" + src + "]";
	}
	

	/*
	 * String boxofficeType, showRange, rnum, rank, rankInten, rankOldAndNew,
	 * movieCd, movieNm, openDt, salesAmt, salesShare, salesInten, salesChange,
	 * salesAcc, audiCnt, audiInten, audiChange, audiAcc, scrnCnt, showCnt;
	 */
}
