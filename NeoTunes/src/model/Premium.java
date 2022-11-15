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
}
