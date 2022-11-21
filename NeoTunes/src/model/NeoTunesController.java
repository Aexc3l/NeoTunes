package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
import java.util.Random;  

import java.util.ArrayList;

public class NeoTunesController {

	private ArrayList<User> usersCollection;
	private ArrayList<Audio> audioCollection;
	private ArrayList<Playlist> playlistCollection;
	private Random randomAd;

	public NeoTunesController() {
		super();
		this.usersCollection = new ArrayList<User>();
		this.audioCollection = new ArrayList<Audio>();
		this.playlistCollection = new ArrayList<Playlist>();
		this.randomAd = new Random();
		testCase();
	}

	public void testCase(){

		registerStandard("NickName", "10202");
		registerPremium("Socio", "900");

		registerArtist("A", "1003", "10", 0,0);
		registerArtist("B", "1004", "10", 0,0);
		registerContentCreator("AQ", "3045", "sdbjbwdknjk.com", 0,0);
		registerContentCreator("BQ", "3046", "sdbjbwdknjk.com", 0,0);


		int pos = 0;
		int pos1 = 0;
		int pos2 = 0;
		int pos3 = 0;
		int pos4 = 0;

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (usersCollection.get(i).getNickName().equals("NickName")) {

				pos = i;

			}
		}

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (usersCollection.get(i).getNickName().equals("Socio")) {

				pos = i;

			}
		}

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (usersCollection.get(i).getNickName().equals("Silvio")) {

				pos1 = i;

			}
		}

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (usersCollection.get(i).getNickName().equals("AQ")) {

				pos2 = i;

			}
		}

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (usersCollection.get(i).getNickName().equals("BQ")) {

				pos4 = i;

			}
		}

		registerSong("LIRIO", "LIRIO", 640, 0, "SSS", 1 ,100, 0, pos1 );
		registerSong("Oni", "Fire", 130, 0, "Rage", 1 ,100, 0, pos1 );
		registerPodcast("A new era", "ALION", 10420, 0,"Ivis",2, pos2);
		registerPodcast("The Boys", "JDKBCKDC.COM", 13210, 0, "You can see California with your Eyes",1, pos2);
		registerPodcast("TB", "JDKBCKDC.COM", 13210, 0, "You can see California with your Eyes",1, pos4);
		registerPlaylist("SSS", 1, pos);
		registerPlaylist("Sion", 1, pos3);

	}

	public boolean registerStandard(String nickName, String id) {

		LocalDate dates = java.time.LocalDate.now();

		return usersCollection.add( new Standard (nickName, id, dates));
	}

	public boolean registerPremium(String nickName, String id) {

		LocalDate dates = java.time.LocalDate.now();

		return usersCollection.add( new Premium (nickName, id, dates));
	}

	public boolean registerArtist(String nickName, String id, String imageURL, double acumulatedPlaybacks, double acumPlaysByConsumer) {

		LocalDate dates = java.time.LocalDate.now(); 

		return usersCollection.add( new Artist (nickName, id, dates, imageURL, acumulatedPlaybacks,
				acumPlaysByConsumer));
	}

	public boolean registerContentCreator(String nickName, String id, String imageURL, double acumulatedPlaybacks, double acumPlaysByConsume) {

		LocalDate dates = java.time.LocalDate.now();

		return usersCollection.add( new ContentCreator (nickName, id, dates, imageURL, acumulatedPlaybacks,
				acumPlaysByConsume));
	}

	public boolean registerSong(String name, String imageURL, int duration, double numberOfPlaybacks, String album, int genre,double saleValue, double allSales, int artistPos) {

		Audio newSong = new Song (name, imageURL, duration, numberOfPlaybacks, album, genre,saleValue, allSales);
		for (int i = 0; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i) == usersCollection.get(artistPos) && usersCollection.get(i) instanceof Artist) {
				(( Artist ) ( usersCollection.get(artistPos) )).addAudio(newSong);
			}
		}

		return audioCollection.add(newSong);
	}

	public boolean registerPodcast(String name, String imageURL, int duration, double numberOfPlaybacks, String description, int category, int artistPos) {

		Audio newPodcast = new Podcast (name, imageURL, duration, numberOfPlaybacks, description,
				category);
		for (int i = 0; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i) == usersCollection.get(artistPos) && usersCollection.get(i) instanceof ContentCreator) {
				(( ContentCreator ) ( usersCollection.get(artistPos) )).addAudio(newPodcast);
			}
		}

		return audioCollection.add(newPodcast);

	}

	public boolean registerPlaylist(String plName, int playlistType, int consumerId) {

		Playlist newPlaylist = new Playlist(plName, playlistType);
		playlistCollection.add(newPlaylist);

		for (int i = 0 ; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i) == usersCollection.get(consumerId) && usersCollection.get(i) instanceof Standard) {	

				(( Standard ) ( usersCollection.get(consumerId) )).addPlaylist(newPlaylist);

			}if (usersCollection.get(i) == usersCollection.get(consumerId) && usersCollection.get(i) instanceof Premium) {

				(( Premium ) ( usersCollection.get(consumerId) )).addPlaylist(newPlaylist);
			}	
		}
		return false;
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

				audioRegistered += "\nName: " + audioCollection.get(i).getName() + "\nDuration: " + audioCollection.get(i).calculateDuration()
						+ "\nNumber of Playbacks: " + audioCollection.get(i).getNumberOfPlaybacks() + audioCollection.get(i).toString() + "\n";			
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

	public String showAllplayList(int consumerPos) {

		String registeredPlaylist = "";

		for (int i = 0; (i < usersCollection.size()); i++) {

			if (!usersCollection.isEmpty() && usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				registeredPlaylist = (( Standard ) ( usersCollection.get(consumerPos) )).seeAllPlaylist() + "\n";

			}

			if (!usersCollection.isEmpty() && usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Premium) {

				registeredPlaylist = (( Premium ) ( usersCollection.get(consumerPos) )).seeAllPlaylist() + "\n";

			}

		}
		if (registeredPlaylist.equals("")) {
			registeredPlaylist = "There are not playlist registered yet";
		}

		return registeredPlaylist;
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

	public String seeAudioinPlaylist( int pos) {
		String audios = "";
		for (int i = 0; i < playlistCollection.size(); i++ ) {

			if (playlistCollection.get(i) == playlistCollection.get(pos)) {
				audios = ( playlistCollection.get(pos) ).seeAllAddedAudio();
			}	
		}

		if (audios.equals("")) {
			audios = "This Consumer hasn't added any audio.";
		}
		return audios;
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

	public int checkStandard(String consumerId){
		int verify = -1;
		for (int i = 0; i < usersCollection.size(); i++ ) {
			if (usersCollection.get(i).getId().equals(consumerId) && usersCollection.get(i) instanceof Standard) {
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

	public int checkAudioExistence(String name) {
		int pos = -1;

		for(int i = 0; i< audioCollection.size(); i++){
			if(audioCollection.get(i).getName().equals(name) && audioCollection.get(i) instanceof Song){
				pos = i;
			}else if (audioCollection.get(i).getName().equals(name) && audioCollection.get(i) instanceof Podcast) {
				pos = i;
			}
		}
		return pos;
	}

	public int searchPodcast(String name) {
		int pos = -1;

		for(int i = 0; i< audioCollection.size(); i++){
			if(audioCollection.get(i).getName().equals(name) && audioCollection.get(i) instanceof Podcast) {
				pos = i;
			}
		}
		return pos;
	}

	public boolean buySong(int songPos, int consumerPos) {

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Premium){

				((Song) audioCollection.get(songPos)).addPlayback();

				return (( Premium ) ( usersCollection.get(consumerPos) )).addAudio((Song)audioCollection.get(songPos));

			}else if (usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				((Song) audioCollection.get(songPos)).addPlayback();

				return (( Standard ) ( usersCollection.get(consumerPos) )).addAudio((Song)audioCollection.get(songPos));

			}
		}	
		return false;	
	}

	public boolean addPodcast(int podcastPos, int consumerPos) {

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Premium){

				return (( Premium ) ( usersCollection.get(consumerPos) )).addAudio((Podcast)audioCollection.get(podcastPos));

			}else if (usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				return (( Standard ) ( usersCollection.get(consumerPos) )).addAudio((Podcast)audioCollection.get(podcastPos));

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

	public void addAPodcastRep(int podcastPos) {

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) instanceof ContentCreator && (( ContentCreator ) ( usersCollection.get(i) )).checkExistence((Podcast)audioCollection.get(podcastPos))){

				(( ContentCreator ) ( usersCollection.get(i) )).addPlayback();

			}
		}
	}

	public String showAnnouncement() {

		String add = "";

		int ad_sel = randomAd.nextInt(3);
		switch (ad_sel) {
		case 0:	
			add = "\n<<<~~~~~~---->>> Nike - Just Do It <<<----~~~~~~>>>";
			break;
		case 1:	
			add = "\n<<<~~~~~~---->>> Coca-Cola - Open Happiness <<<----~~~~~~>>>";
			break;
		case 2:	
			add = "\n<<<~~~~~~---->>> M&Ms - Melts in Your Mouth, Not in Your Hands <<<----~~~~~~>>>";
			break;
		}
		return add;
	}

	public boolean hearAudio(int consumerPos, String audioName) {
		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Premium){

				(( Consumer ) ( usersCollection.get(consumerPos) )).getGenreOrCat(audioCollection.get(checkAudioExistence(audioName)));

				return (( Premium ) ( usersCollection.get(consumerPos) )).playAudio(audioName);

			}else if (usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				(( Consumer ) ( usersCollection.get(consumerPos) )).getGenreOrCat(audioCollection.get(checkAudioExistence(audioName)));

				return (( Standard ) ( usersCollection.get(consumerPos) )).playAudio(audioName);

			}
		}
		return false;	

	}


	public boolean addToPlaylist(int playPos, int consumerPos, String newAudio) {

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Premium){

				return (( Premium ) ( usersCollection.get(consumerPos) )).addtoPlaylist(newAudio,playlistCollection.get(playPos));

			}else if (usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				return (( Standard ) ( usersCollection.get(consumerPos) )).addtoPlaylist(newAudio,playlistCollection.get(playPos));

			}
		}	
		return false;	
	}

	public boolean removefromPlaylist(int playPos, int consumerPos, String name) {

		for(int i = 0; i< usersCollection.size(); i++){
			if(usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Premium){

				return (( Premium ) ( usersCollection.get(consumerPos) )).deletefromPlaylist(name,playlistCollection.get(playPos));

			}else if (usersCollection.get(i) == usersCollection.get(consumerPos) && usersCollection.get(i) instanceof Standard) {

				return (( Standard ) ( usersCollection.get(consumerPos) )).deletefromPlaylist(name,playlistCollection.get(playPos));

			}
		}	
		return false;
	}

	//First Report
	public String reportAcumulatePlays() { //Report of Acumulated Playbacks

		int songsPlays = 0;
		int podcastsPlays = 0;
		String report = "There are no reproductions on the platform.";

		for (int i = 0; i < audioCollection.size(); i++) {

			Audio checkAudio = audioCollection.get(i);
			if (checkAudio instanceof Song)
				songsPlays += checkAudio.getNumberOfPlaybacks();
			else if (checkAudio instanceof Podcast)
				podcastsPlays += checkAudio.getNumberOfPlaybacks();

		}

		if (songsPlays > 0 || podcastsPlays > 0)
			report = "Total Songs plays: " + songsPlays + "\nTota Podcasts plays: " + podcastsPlays;
		return report;
	}

	//Second Report
	public String reportMostListenedGenre(int consumerId, int option) {

		User userNick = usersCollection.get(consumerId);
		String report = null;

		String mostListenedGenre = null;
		int playsMostListenedGenre = 0;

		if (userNick != null && userNick instanceof Consumer) {
			((Consumer) userNick).calculateMostListenedGenre();

			report = "\nThis User has no plays.";

			String mostListenedGenreUser = ((Consumer) userNick).getMostListenedGenre();

			int playsMostListenedGenreUser = ((Consumer) userNick).getPlaysMostListenedGenre();

			if (mostListenedGenreUser != null) {
				report = "\nGenre most listened by " + userNick.getNickName() + ": " + mostListenedGenreUser
						+ "\nNumber of reproductions: " + playsMostListenedGenreUser +  "\n";
			}
		}

		int rock = 0, pop = 0, trap = 0, house = 0;
		for (int i = 0; i < audioCollection.size(); i++) {

			Audio insAudio = audioCollection.get(i);

			if (insAudio instanceof Song) {

				switch (((Song) insAudio).getGenre()) {
				case ROCK:
					rock += insAudio.getNumberOfPlaybacks();
					break;
				case POP:
					pop += insAudio.getNumberOfPlaybacks();
					break;
				case TRAP:
					trap += insAudio.getNumberOfPlaybacks();
					break;
				case HOUSE:
					house += insAudio.getNumberOfPlaybacks();
					break;
				}
			}
		}

		int[] reps = { rock, pop, trap, house };
		for (int i = 0; i < reps.length; i++) {
			if (reps[i] > playsMostListenedGenre) {
				playsMostListenedGenre = reps[i];
				if (i == 0)
					mostListenedGenre = "Rock";
				else if (i == 1)
					mostListenedGenre = "Pop";
				else if (i == 2)
					mostListenedGenre = "Trap";
				else if (i == 3)
					mostListenedGenre = "House";
			}
		}
		if (mostListenedGenre == null)
			report = "\nThere are no reproductions on the platform.";
		if (option == 1) {
			report += "\nGenre most listened on the platform: " + mostListenedGenre
					+ "\nNumber of reproductions: " + playsMostListenedGenre + "\n"; 
		}

		return report;
	}
	//Third Report
	public String reportMostListenedCategory(int consumerId, int option) {
		User userNick = usersCollection.get(consumerId);
		((Consumer) userNick).calculateMostListenedCategory();

		String report = null; 
		String mostListenedCategory = null;

		int playsMostListenedCategory = 0;

		if (userNick != null && userNick instanceof Consumer) {
			report = "\nUser has no plays.";
			String mostListenedCategoryUser = ((Consumer) userNick).getMostListenedCategory();
			int playsMostListenedCategoryUser = ((Consumer) userNick).getPlaysMostListenedCategory();
			if (mostListenedCategoryUser != null) {
				report = "\nCategory most listened by " + userNick.getNickName() + ": " + mostListenedCategoryUser
						+ "\nNumber of reproductions: " + playsMostListenedCategoryUser + "\n";
			}
		}
		int politic = 0, entertainment = 0, videoGame = 0, fashion = 0;
		for (int i = 0; i < audioCollection.size(); i++) {
			Audio insAudio = audioCollection.get(i);
			if (insAudio instanceof Podcast) {
				switch (((Podcast) insAudio).getCategory()) {
				case POLITICS:
					politic += insAudio.getNumberOfPlaybacks();
					break;
				case ENTERTAIMENT:
					entertainment += insAudio.getNumberOfPlaybacks();
					break;
				case VIDEOGAMES:
					videoGame += insAudio.getNumberOfPlaybacks();
					break;
				case FASHION:
					fashion += insAudio.getNumberOfPlaybacks();
					break;
				}
			}
		}

		int[] reps = { politic, entertainment, videoGame, fashion };

		for (int i = 0; i < reps.length; i++) {

			if (reps[i] > playsMostListenedCategory) {
				playsMostListenedCategory = reps[i];
				if (i == 0)
					mostListenedCategory = "Politic";
				else if (i == 1)
					mostListenedCategory = "Entertainment";
				else if (i == 2)
					mostListenedCategory = "Video games";
				else if (i == 3)
					mostListenedCategory = "Fashion";
			}
		}
		if (mostListenedCategory == null)
			report = "\nThere are no reproductions on the platform.";
		if (option == 1) {
			report += "\nCategory most listened on the platform: " + mostListenedCategory
					+ "\nNumber of reproductions: " + playsMostListenedCategory + "\n";        	
		}

		return report;
	}
	//Four Report
	public int getTopProducer(ArrayList<Producer> artists) {
		int position = -1;
		int plays = 0;
		for (int i = 0; i < artists.size(); i++) {
			Producer objProducer = artists.get(i);
			if (objProducer.getAcumulatedPlaybacks() >= plays) {
				plays = (int) objProducer.getAcumulatedPlaybacks();
				position = i;
			}
		}
		return position;
	}

	public String getTopFiveArtist() {
		ArrayList<Producer> artists = new ArrayList<Producer>();

		String report = "\nThere are no artists registered on the platform.";

		for (int i = 0; i < usersCollection.size(); i++) {
			User objUser = usersCollection.get(i);
			if (objUser instanceof Artist) {
				Artist objArtist = (Artist) objUser;
				objArtist.calculatePlaybacks();
				artists.add(objArtist);
			}
		}
		if (artists.size() > 0) {
			Artist[] topArtists = new Artist[5];

			for (int x = 0; x < topArtists.length; x++) {

				int pos = getTopProducer(artists);
				if (pos != -1) {
					topArtists[x] = (Artist) artists.get(pos);
					artists.remove(pos);
				}

			}

			if (topArtists.length > 0) {
				report = "\nArtists top five: \n";
				for (int m = 0; m < topArtists.length; m++) {
					if (topArtists[m] != null) {
						report += "( " + (m + 1) + " ) " + topArtists[m].getNickName() + " ("
								+ topArtists[m].getAcumulatedPlaybacks()
								+ " plays)\n";
					} else {
						report += "\nThere are no more registered artists.\n";
						m = topArtists.length;
					}
				}
			} else {
				report = "\nThere are no reproductions on the platform.";
			}
		}
		return report;
	}

	public String getTopFiveContentCreator() {
		ArrayList<Producer> contentCreators = new ArrayList<Producer>();
		String report = "\nThere are no content creators registered on the platform.";

		for (int i = 0; i < usersCollection.size(); i++) {
			User objUser = usersCollection.get(i);
			if (objUser instanceof ContentCreator) {
				ContentCreator objContentCreator = (ContentCreator) objUser;
				objContentCreator.calculatePlaybacks();
				contentCreators.add(objContentCreator);
			}
		}
		if (contentCreators.size() > 0) {
			ContentCreator[] topContentCreators = new ContentCreator[5];

			for (int x = 0; x < topContentCreators.length; x++) {

				int pos = getTopProducer(contentCreators);
				if (pos != -1) {
					topContentCreators[x] = (ContentCreator) contentCreators.get(pos);
					contentCreators.remove(pos);
				}

			}

			report = "\nContent creators top five: \n";
			for (int m = 0; m < topContentCreators.length; m++) {
				if (topContentCreators[m] != null) {
					report += "(" + (m + 1) + ")" + topContentCreators[m].getNickName() + " ("
							+ topContentCreators[m].getAcumulatedPlaybacks()
							+ " plays)\n";
				} else {
					report += "\nThere are no more content creators registered on the platform.\n";
					m = topContentCreators.length;
				}
			}
			if (report.equalsIgnoreCase(
					"\nContent creators top five: \nThere are no more content creators registered on the platform.\n"))
				report = "T\nhere are no content creator registered on the platform.";

		}
		return report;
	}
	//Five Report
	public int getTopAudio(ArrayList<Audio> audios) {
		int position = -1;
		int plays = 0;
		for (int i = 0; i < audios.size(); i++) {
			Audio objAudio = audios.get(i);
			if (objAudio.getNumberOfPlaybacks() >= plays) {
				plays = (int) objAudio.getNumberOfPlaybacks();
				position = i;
			}
		}
		return position;
	}

	public String getTopTenSongs(int option) {
		ArrayList<Audio> songs = new ArrayList<Audio>();
		String report = "There are no songs registered on the platform.";
		String topOne = "There are no songs registered on the platform.";

		for (int i = 0; i < audioCollection.size(); i++) {
			Audio neoAudio = audioCollection.get(i);
			if (neoAudio instanceof Song) {
				songs.add((Song) neoAudio);
			}
		}
		if (songs.size() > 0) {
			Song[] topSongs = new Song[10];

			for (int x = 0; x < topSongs.length; x++) {

				int pos = getTopAudio(songs);
				if (pos != -1) {
					topSongs[x] = (Song) songs.get(pos);
					songs.remove(pos);
				}

			}

			report = "Songs top ten: \n";
			for (int m = 0; m < topSongs.length; m++) {
				if (topSongs[m] != null) {
					report += "(" + (m + 1) + ")" + topSongs[m].reportString() + "\n";

					if (m == 0 && option == 2) {
						topOne = "\n" + topSongs[m].getName() + ((Song) topSongs[m]).toString();	
					}

				} else {
					report += "There are no more songs registered on the platform.\n";
					m = topSongs.length;
				}
			}
			if (report.equalsIgnoreCase(
					"Songs top ten: \nThere are no more songs registered on the platform.\n"))
				report = "There are no songs registered on the platform.";

		}
		if (option == 1) {
			return report;
		}
		if (option ==2) {
			return topOne;
		}
		return null;
	}

	public String getTopTenPodcasts() {
		ArrayList<Audio> podcasts = new ArrayList<Audio>();
		String report = "There are no podcasts registered on the platform.";

		for (int i = 0; i < audioCollection.size(); i++) {
			Audio neoAudio = audioCollection.get(i);
			if (neoAudio instanceof Podcast) {
				podcasts.add((Podcast) neoAudio);
			}
		}
		if (podcasts.size() > 0) {
			Podcast[] topPodcasts = new Podcast[10];

			for (int x = 0; x < topPodcasts.length; x++) {

				int pos = getTopAudio(podcasts);
				if (pos != -1) {
					topPodcasts[x] = (Podcast) podcasts.get(pos);
					podcasts.remove(pos);
				}

			}

			report = "Podcasts top ten: \n";
			for (int m = 0; m < topPodcasts.length; m++) {
				if (topPodcasts[m] != null) {
					report += "[ " + (m + 1) + " ] " + topPodcasts[m].reportString() + "\n";
				} else {
					report += "There are no more podcasts registered on the platform.\n";
					m = topPodcasts.length;
				}
			}
			if (report.equalsIgnoreCase(
					"Podcasts top ten: \nThere are no more podcasts registered on the platform.\n"))
				report = "There are no podcasts registered on the platform.";

		}
		return report;
	}

	public String reportByGenre() {
		String report = null;

		int rockSales = 0;
		int popSales = 0; 
		int trapSales = 0;
		int houseSales = 0;

		int rockIncome = 0, popIncome = 0, trapIncome = 0, houseIncome = 0;
		for (int i = 0; i < audioCollection.size(); i++) {
			Audio objAudio = audioCollection.get(i);
			if (objAudio instanceof Song) {
				Song objSong = (Song) objAudio;
				switch (objSong.getGenre()) {
				case ROCK:
					rockSales += objSong.getAllSales();
					rockIncome += (objSong.getAllSales() * objSong.getSaleValue());
					break;
				case POP:
					popSales += objSong.getAllSales();
					popIncome += (objSong.getAllSales() * objSong.getSaleValue());
					break;
				case TRAP:
					trapSales += objSong.getAllSales();
					trapIncome += (objSong.getAllSales() * objSong.getSaleValue());
					break;
				case HOUSE:
					houseSales += objSong.getAllSales();
					houseIncome += (objSong.getAllSales() * objSong.getSaleValue());
					break;
				}
			}
		}

		if ((rockSales + popSales + trapSales + houseSales) > 0) {
			report = "\n";
			if (rockSales > 0)
				report += "\nRock:\n   - Songs sold: " + rockSales + "\n   - Total sales value: " + rockIncome;
			if (popSales > 0)
				report += "\nPop:\n   - Songs sold: " + popSales + "\n   - Total sales value: " + popIncome;
			if (trapSales > 0)
				report += "\nTrap:\n   - Songs sold: " + trapSales + "\n   - Total sales value: " + trapIncome;
			if (houseSales > 0)
				report += "\nHouse:\n   - Songs sold: " + houseSales + "\n   - Total sales value: " + houseIncome;
		} else
			report = "\nError. There are no sales of songs registered on the platform.";

		return report;
	}	
}