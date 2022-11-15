package model;

import java.time.LocalDate;

public class Standard extends Consumer {

	private Playlist[] createdPlaylist;
	private Song[] purchasedSongs;

	public Standard(String nickName, String id, LocalDate dates) {
		super(nickName, id, dates);
		this.createdPlaylist = new Playlist[20];
		this.purchasedSongs = new Song[100];
	}

	@Override
	public boolean addSong(Audio newAudio) {
		for (int i = 0; i < purchasedSongs.length; i++ ) {
			if (newAudio instanceof Song && purchasedSongs[i] == null) {
				purchasedSongs[i] = ((Song)(newAudio));
				return true;
			}	
		}
		return false;
	}

	@Override
	public boolean addtoPlaylist(Audio newAudio, Playlist createdPlaylist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPlaylist(Playlist newPlaylist) {
		for (int i = 0; i < createdPlaylist.length; i++ ) {
			if (createdPlaylist[i] == null) {
				createdPlaylist[i] = newPlaylist;
				return true;
			}	
		}
		return false;
	}

}
