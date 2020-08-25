package mybatis.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class YouTubeVO {
	private String 	videoId, 
					publishedAt, 
					channelId, 
					title, 
					description,
					thumbnail;

	@Override
	public String toString() {
		return "YouTubeVO [videoId=" + videoId + ", publishedAt=" + publishedAt + ", channelId=" + channelId
				+ ", title=" + title + ", description=" + description + ", thumbnail=" + thumbnail + "]";
	}
}
