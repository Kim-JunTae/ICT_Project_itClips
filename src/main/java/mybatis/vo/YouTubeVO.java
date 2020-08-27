package mybatis.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class YouTubeVO {
	private String 	videoId,
					title,
					description,
					thumbnail,
					publishedAt, 
					channelId,
					movieId;

	@Override
	public String toString() {
		return "YouTubeVO [videoId=" + videoId + ", title=" + title + ", description=" + description + ", thumbnail="
				+ thumbnail + ", publishedAt=" + publishedAt + ", channelId=" + channelId + ", movieId=" + movieId
				+ "]";
	}

}
