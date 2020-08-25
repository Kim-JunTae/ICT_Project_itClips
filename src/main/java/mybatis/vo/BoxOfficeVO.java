package mybatis.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoxOfficeVO {
	String 	boxofficeType,
			showRange,
			rnum,
			rank,
			rankInten,
			rankOldAndNew,
			movieCd,
			movieNm,
			openDt,
			salesAmt,
			salesShare,
			salesInten,
			salesChange,
			salesAcc,
			audiCnt,
			audiInten,
			audiChange,
			audiAcc,
			scrnCnt,
			showCnt;

	@Override
	public String toString() {
		return "BoxOfficeVO [boxofficeType=" + boxofficeType + ", showRange=" + showRange + ", rnum=" + rnum + ", rank="
				+ rank + ", rankInten=" + rankInten + ", rankOldAndNew=" + rankOldAndNew + ", movieCd=" + movieCd
				+ ", movieNm=" + movieNm + ", openDt=" + openDt + ", salesAmt=" + salesAmt + ", salesShare="
				+ salesShare + ", salesInten=" + salesInten + ", salesChange=" + salesChange + ", salesAcc=" + salesAcc
				+ ", audiCnt=" + audiCnt + ", audiInten=" + audiInten + ", audiChange=" + audiChange + ", audiAcc="
				+ audiAcc + ", scrnCnt=" + scrnCnt + ", showCnt=" + showCnt + "]";
	}
	
	
}
