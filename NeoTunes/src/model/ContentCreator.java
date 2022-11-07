package model;

import java.sql.Date;
import java.util.ArrayList;

public class ContentCreator extends Producer {
	
	private ArrayList<Podcast> producedPodcastLists;

	public ContentCreator(String nickName, String id, Date linkingDate, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {
		super(nickName, id, linkingDate, imageURL, acumulatedPlaybacks, acumPlaysByConsumer);
		this.producedPodcastLists = new ArrayList<Podcast>();
	}

	public boolean addPodcast(Podcast podcastName) {

		return producedPodcastLists.add(podcastName);
		
	}
}
