package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Premium extends Consumer {

	private ArrayList<Playlist> createdPlaylist;
	private ArrayList<Song> purchasedSongs;


	public Premium(String nickName, String id, LocalDate dates) {
		super(nickName, id, dates);
		this.createdPlaylist = new ArrayList<Playlist>();
		this.purchasedSongs = new ArrayList<Song>();
	}

	@Override
	public boolean addSong(Audio newAudio) {
		if (newAudio instanceof Song) {
			return purchasedSongs.add((Song)(newAudio));
		}
		return true;
	}

	@Override
	public boolean addtoPlaylist(Audio newAudio, Playlist createdPlaylist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPlaylist(Playlist newPlaylists) {
		return createdPlaylist.add(newPlaylists);
	}
	public String seeAllPlaylist() {
			String allPlaylist = "";
		
		for (int i = 0; i < createdPlaylist.size(); i++ ) {
			
			if (!createdPlaylist.isEmpty()) {
				allPlaylist += "\n" + (i + 1) + ". " + createdPlaylist.get(i).toString();
			}
			
		}
		
		return allPlaylist;
	}

	public String seeAllAddedAudio() {
		String allAudio = "";
		
		for (int i = 0; i < purchasedSongs.size(); i++ ) {
			
			if (!purchasedSongs.isEmpty()) {
				allAudio += "\n" + (i + 1) + ". " + purchasedSongs.get(i).getName();
			}
			
		}
		
		return allAudio;
	}
}
