package model;

public interface AddedSongs {
	
	public boolean addAudio(Audio newAudio);
	
	public boolean addtoPlaylist(String newAudio, Playlist createdPlaylist);

	public boolean addPlaylist(Playlist newPlaylist);
	
}
