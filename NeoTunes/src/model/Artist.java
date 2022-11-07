package model;

import java.sql.Date;
import java.util.ArrayList;

public class Artist extends Producer {

	private ArrayList<Song>  producedSongLists;

	public Artist(String nickName, String id, Date linkingDate, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {
		super(nickName, id, linkingDate, imageURL, acumulatedPlaybacks, acumPlaysByConsumer);
		this.producedSongLists = new ArrayList<Song>();
	}

	public boolean addPodcast(Song songName) {

		return producedSongLists.add(songName);
		
	}
	
}
