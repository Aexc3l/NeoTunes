package model;

public interface AddedSongs {
	
	public boolean addSong(Audio newAudio);
	
	public boolean addtoPlaylist(Audio newAudio, Playlist createdPlaylist);

	public boolean addPlaylist(Playlist newPlaylist);
	
}
