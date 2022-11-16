package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;   

import java.util.ArrayList;

public class NeoTunesController {

	private ArrayList<User> usersCollection;
	private ArrayList<Audio> audioCollection;
	private ArrayList<Playlist> playlistCollection;

	public NeoTunesController() {
		super();
		this.usersCollection = new ArrayList<User>();
		this.audioCollection = new ArrayList<Audio>();
		this.playlistCollection = new ArrayList<Playlist>();
		testCase();
	}

	public void testCase(){

		registerStandard("NickName", "10202");
		registerPremium("Socio", "900");
		registerArtist("Silvio", "1003", "10", 0,0);

		int pos = 0;
		int pos1 = 0;
		for (int i = 0; (i < usersCollection.size()); i++) {

			if (usersCollection.get(i).getNickName().equals("NickName")) {

				pos = i;

			}
		}

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (usersCollection.get(i).getNickName().equals("Silvio")) {

				pos1 = i;

			}
		}

		registerSong("LIRIO", "LIRIO", 1240, 0, "SSS", 1 ,100, 0, pos1 );
		registerPlaylist("SSS", 1, pos);

	}

	public String getUserType(User userInstance) {

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (!usersCollection.isEmpty() && usersCollection.get(i) instanceof Artist && usersCollection.get(i) == userInstance) {

				return "Artist";

			}else if(!usersCollection.isEmpty() && usersCollection.get(i) instanceof ContentCreator && usersCollection.get(i) == userInstance){

				return "Content Creator";

			}else if(!usersCollection.isEmpty() && usersCollection.get(i) instanceof Premium && usersCollection.get(i) == userInstance){

				return "Premium Consumer";

			}else if(!usersCollection.isEmpty() && usersCollection.get(i) instanceof Standard && usersCollection.get(i) == userInstance){

				return "Standard Consumer";

			}
		}	
		return null;

	}

	public boolean registerStandard(String nickName, String id) {

		LocalDate dates = java.time.LocalDate.now();

		return usersCollection.add( new Standard (nickName, id, dates));
	}

	public boolean registerPremium(String nickName, String id) {

		LocalDate dates = java.time.LocalDate.now();

		return usersCollection.add( new Premium (nickName, id, dates));
	}

	public boolean registerArtist(String nickName, String id, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {

		LocalDate dates = java.time.LocalDate.now(); 

		return usersCollection.add( new Artist (nickName, id, dates, imageURL, acumulatedPlaybacks,
				acumPlaysByConsumer));
	}

	public boolean registerContentCreator(String nickName, String id, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsume) {

		LocalDate dates = java.time.LocalDate.now();

		return usersCollection.add( new ContentCreator (nickName, id, dates, imageURL, acumulatedPlaybacks,
				acumPlaysByConsume));
	}

	public boolean registerSong(String name, String imageURL, int duration, double numberOfPlaybacks, String album, int genre,
			double saleValue, double allSales, int artistPos) {

		Audio newSong = new Song (name, imageURL, duration, numberOfPlaybacks, album, genre,saleValue, allSales);
		for (int i = 0; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i) == usersCollection.get(artistPos) && usersCollection.get(i) instanceof Artist) {
				(( Artist ) ( usersCollection.get(artistPos) )).addAudio(newSong);
			}
		}

		return audioCollection.add(newSong);
	}

	public boolean registerPodcast(String name, String imageURL, int duration, double numberOfPlaybacks, String description,
			int category, int artistPos) {

		Audio newPodcast = new Podcast (name, imageURL, duration, numberOfPlaybacks, description,
				category);
		for (int i = 0; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i) == usersCollection.get(artistPos) && usersCollection.get(i) instanceof ContentCreator) {
				(( ContentCreator ) ( usersCollection.get(artistPos) )).addAudio(newPodcast);
			}
		}

		return audioCollection.add(newPodcast);

	}

	public String showUserList() {

		String usersRegistered = "";

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (!usersCollection.isEmpty()) {

				usersRegistered += "\n" + (i + 1) + ". " + usersCollection.get(i).toString() + "\nType: " + getUserType(usersCollection.get(i)) + "\n";

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

				audioRegistered += "\nName: " + audioCollection.get(i).getName() + "\nDuration: " + audioCollection.get(i).calculateDuration() 
						+ "\nNumber of Playbacks: " + audioCollection.get(i).getNumberOfPlaybacks()+ audioCollection.get(i).toString() + "\n";			
			}

			if (!audioCollection.isEmpty() && selection == 2 && audioCollection.get(i) instanceof Podcast ) {

				audioRegistered += "\nName: " + audioCollection.get(i).getName() + "\nDuration: " + audioCollection.get(i).getDuration()
						+ "\nNumber of Playbacks: " + audioCollection.get(i).getNumberOfPlaybacks() + audioCollection.get(i).toString();			
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

	public int checkArtistExistence(String artistId) {
		int pos = -1;

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i).getId().equals(artistId) && usersCollection.get(i) instanceof Artist){
				pos = i;
			}
		}
		return pos;
	}

	public int checkContentCreatorExistence(String contentCreatorId) {
		int pos = -1;

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i).getId().equals(contentCreatorId) && usersCollection.get(i) instanceof ContentCreator){
				pos = i;
			}
		}
		return pos;
	}

	public int checkConsumer(String consumerId){
		int verify = -1;
		for (int i = 0; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i).getId().equals(consumerId) && usersCollection.get(i) instanceof Consumer) {
				verify = i;
			}
		}
		return verify;
	}

	public int checkPlaylistExistence(String playlistName) {
		int pos = -1;

		for(int i = 0; i< playlistCollection.size(); i++){
			if(playlistCollection.get(i).getName().equals(playlistName)){
				pos = i;
			}
		}
		return pos;
	}

	public int checkSongExistence(String name) {
		int pos = -1;

		for(int i = 0; i< audioCollection.size(); i++){
			if(audioCollection.get(i).getName().equals(name) && audioCollection.get(i) instanceof Song){
				pos = i;
			}
		}
		return pos;
	}

	public String seeCreatedAudio(int userType, int pos) {
		String audios = "";
		switch (userType) {
		case 1:
			audios += (( Artist ) ( usersCollection.get(pos) )).showAudioList();
			break;
		case 2:
			audios += (( ContentCreator ) ( usersCollection.get(pos) )).showAudioList();
			break;
		}
		if (audios.equals("")) {
			audios = "This Producer hasn't added any audio.";
		}
		return audios;
	}

	public String seeAddedAudio( int pos) {
		String audios = "";
		for (int i = 0; i < usersCollection.size(); i++ ) {

			if (usersCollection.get(i) == usersCollection.get(pos) && usersCollection.get(i) instanceof Standard) {
				audios = (( Standard ) ( usersCollection.get(pos) )).seeAllAddedAudio();
			}else if (usersCollection.get(i) == usersCollection.get(pos) && usersCollection.get(i) instanceof Premium) {
				audios = (( Premium ) ( usersCollection.get(pos) )).seeAllAddedAudio();
			}	
		}

		if (audios.equals("")) {
			audios = "This Consumer hasn't added any audio.";
		}
		return audios;
	}

	public String showAllplayList(int consumerPos) {
		String registeredPlaylist = "";

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (!usersCollection.isEmpty() && usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				registeredPlaylist = (( Standard ) ( usersCollection.get(consumerPos) )).seeAllPlaylist();

			}

		}
		if (registeredPlaylist.equals("")) {
			registeredPlaylist = "There are not playlist registered yet";
		}

		return registeredPlaylist;
	}

	public boolean registerPlaylist(String plName, int playlistType, int consumerId) {

		Playlist newPlaylist = new Playlist(plName, playlistType);
		playlistCollection.add(newPlaylist);

		for (int i = 0 ; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i) == usersCollection.get(consumerId) && usersCollection.get(i) instanceof Standard) {	

				(( Standard ) ( usersCollection.get(consumerId) )).addPlaylist(newPlaylist);

			}else if (usersCollection.get(i) == usersCollection.get(consumerId) && usersCollection.get(i) instanceof Premium) {

				(( Premium ) ( usersCollection.get(consumerId) )).addPlaylist(newPlaylist);
			}	
		}
		return false;
	}

	public boolean buySong(int songPos, int consumerPos) {

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Premium){

				return (( Premium ) ( usersCollection.get(consumerPos) )).addSong((Song)audioCollection.get(songPos));

			}else if (usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				return (( Standard ) ( usersCollection.get(consumerPos) )).addSong((Song)audioCollection.get(songPos));

			}
		}	
		return false;	
	}

	public void addANewBuy(int songPos) {

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) instanceof Artist && (( Artist ) ( usersCollection.get(i) )).checkExistence((Song)audioCollection.get(songPos))){

				(( Artist ) ( usersCollection.get(i) )).addPlayback();
				(( Song ) ( audioCollection.get(songPos) )).addPlayback();

			}
		}


	}

}