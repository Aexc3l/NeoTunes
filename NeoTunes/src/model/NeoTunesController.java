package model;

import java.sql.Date;
import java.util.ArrayList;

public class NeoTunesController {

	private ArrayList<User> usersCollection;
	private ArrayList<Audio> audioCollection;

	public NeoTunesController() {
		super();
		this.usersCollection = new ArrayList<User>();
		this.audioCollection = new ArrayList<Audio>();
	}

	public void testCase() {
		Playlist pl  = new Playlist("A", 1);
		
		pl.createNumericMatrix();
		
	}
	
	public boolean registerStandard(String nickName, String id, String linkingDate) {

		Date dates = Date.valueOf(linkingDate);
		
		return usersCollection.add( new Standard (nickName, id, dates));
	}

	public boolean registerPremium(String nickName, String id, String linkingDate) {
		
		Date dates = Date.valueOf(linkingDate);
		
		return usersCollection.add( new Premium (nickName, id, dates));
	}

	public boolean registerArtist(String nickName, String id, String linkingDate, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {
		
		Date dates = Date.valueOf(linkingDate);
		
		return usersCollection.add( new Artist (nickName, id, dates, imageURL, acumulatedPlaybacks,
				acumPlaysByConsumer));
	}
	
	public boolean registerContentCreator(String nickName, String id, String linkingDate, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsume) {
		
		Date dates = Date.valueOf(linkingDate);

		return usersCollection.add( new ContentCreator (nickName, id, dates, imageURL, acumulatedPlaybacks,
				acumPlaysByConsume));
	}

	public boolean registerSong(String name, String imageURL, String duration, double numberOfPlaybacks, String album, int genre,
			double saleValue, double allSales) {

		return audioCollection.add( new Song (name, imageURL, duration, numberOfPlaybacks, album, genre,
				saleValue, allSales));
	}
	
	public boolean registerPodcast(String name, String imageURL, String duration, double numberOfPlaybacks, String description,
			int category, double saleValue, double allSales) {

		return audioCollection.add( new Podcast (name, imageURL, duration, numberOfPlaybacks, description,
				category, saleValue, allSales));
	}

	public String showUserList() {

		String usersRegistered = "";

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (!usersCollection.isEmpty()) {

				usersRegistered += "\n" + (i + 1) + ". " + usersCollection.get(i).getNickName();

			}

		}
		if (usersRegistered.equals("")) {
			usersRegistered = "There are not users registered yet";
		}

		return usersRegistered;

	}


	public String showAudioList(int selection) {

		String audioRegistered = "";

		for (int i = 0; (i < audioCollection.size()); i++) {

			if (!audioCollection.isEmpty() && selection == 1 &&  audioCollection.get(i) instanceof Song  ) {

				audioRegistered += "\nName: " + audioCollection.get(i).getName() + "\nDuration: " + audioCollection.get(i).getDuration();			
			}

			if (!audioCollection.isEmpty() && selection == 2 && audioCollection.get(i) instanceof Podcast ) {

				audioRegistered += "\nName: " + audioCollection.get(i).getName() + "\nDuration: " + audioCollection.get(i).getDuration();			
			}

		}
		
		if (audioRegistered.equals("") && selection == 1) {
			audioRegistered = "There are not songs registered yet";
		}
		
		if (audioRegistered.equals("") && selection == 2) {
			audioRegistered = "There are not podcasts registered yet";
		}
		return audioRegistered;
	}
}

