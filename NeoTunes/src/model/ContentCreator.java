package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ContentCreator extends Producer {

	private ArrayList<Podcast> producedPodcastLists;

	public ContentCreator(String nickName, String id, LocalDate dates, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {
		super(nickName, id, dates, imageURL, acumulatedPlaybacks, acumPlaysByConsumer);
		this.producedPodcastLists = new ArrayList<Podcast>();
		
	}

	public String showAudioList() {

		String audioRegistered = "";

		for (int i = 0; (i < producedPodcastLists.size()); i++) {

			if (!producedPodcastLists.isEmpty()) {

				audioRegistered += "\nName: " + producedPodcastLists.get(i).getName() + "\nDuration: " + producedPodcastLists.get(i).getDuration()
						+ "\nNumber of Playbacks: " + producedPodcastLists.get(i).getNumberOfPlaybacks() + producedPodcastLists.get(i).toString();			
			}
		}
		return audioRegistered;
	}

	@Override
	public boolean addAudio(Audio newAudio) {
		return producedPodcastLists.add((Podcast) newAudio);
	}

	public boolean checkExistence(Podcast checkPodcast) {
		for (int i = 0; (i < producedPodcastLists.size()); i++) {

			if (!producedPodcastLists.isEmpty() && producedPodcastLists.get(i) == checkPodcast) {

				return true;			
			}
		}
		return false;
	}

	public void addPlayback() {
		
		acumulatedPlaybacks = acumulatedPlaybacks + 1;
		acumPlaysByConsumer = acumPlaysByConsumer + 1;
		
	}
}
