package model;

import java.time.LocalDate; 
import java.util.ArrayList;

public class Artist extends Producer {

	private ArrayList<Song>  producedSongLists;

	public Artist(String nickName, String id, LocalDate linkingDate, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {
		super(nickName, id, linkingDate, imageURL, acumulatedPlaybacks, acumPlaysByConsumer);
		this.producedSongLists = new ArrayList<Song>();
	}

	@Override
	public boolean addAudio(Audio newAudio) {
		
		return producedSongLists.add((Song) newAudio);
		
	}

	public String showAudioList() {
	
			String audioRegistered = "";

			for (int i = 0; (i < producedSongLists.size()); i++) {

				if (!producedSongLists.isEmpty()) {

					audioRegistered += "\nName: " + producedSongLists.get(i).getName() + "\nDuration: " + producedSongLists.get(i).getDuration() 
							+ "\nNumber of Playbacks: " + producedSongLists.get(i).getNumberOfPlaybacks()+ producedSongLists.get(i).toString() + "\n";			
				}
			}
			return audioRegistered;
		
	}

	public boolean checkExistence(Song checkSong) {
		for (int i = 0; (i < producedSongLists.size()); i++) {

			if (!producedSongLists.isEmpty() && producedSongLists.get(i) == checkSong) {

				return true;			
			}
		}
		return false;
	}
	
	public void addPlayback() {
		
		acumPlaysByConsumer = acumPlaysByConsumer + 1;

	}

	public void calculatePlaybacks() {
		int plays = 0;
		for (int i = 0; i < producedSongLists.size(); i++) {
			plays += producedSongLists.get(i).getNumberOfPlaybacks();
		}
		super.setAcumulatedPlaybacks(plays);
	}
}
