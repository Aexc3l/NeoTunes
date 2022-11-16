package ui;

import java.util.Scanner;

import model.NeoTunesController;

public class NeoTunesManager {

	public Scanner reader;
	public NeoTunesController controller;

	public static void main(String[] args) {
		NeoTunesManager neoTunes = new NeoTunesManager();
		neoTunes.showMainMenu();
	}

	public NeoTunesManager() {

		reader = new Scanner(System.in);
		controller = new NeoTunesController();
	}

	public void showMainMenu() {

		System.out.println("\n<<- - - - - - - - Welcome to NeoTunes ™- - - - - - - ->>");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. User's Config");
			System.out.println("2. Audio's Config");
			System.out.println("3. Playlist's Config");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 0:
				System.out.println("\nThanks for using our system");
				stopFlag = true;
				break;
			case 1:
				userConfig();
				break;
			case 2:
				audioConfig();
				break;
			case 3:
				playlistConfig();
				break;
			default:
				System.out.println("\nYou must type a valid option");
				break;

			}

		}
	}

	private void playlistConfig() {
		System.out.println("\nType an option");
		System.out.println("1. Create a User's Playlist");
		System.out.println("2. Share a Playlist by User");
		System.out.println("3. Edit a Playlist");
		System.out.println("0. Go Back");

		int mainOption = reader.nextInt();

		switch (mainOption) {

		case 1:
			registerPlaylist();
			break;
		case 2:
			reader.nextLine();
			String consumerId = "";
			boolean existence = false;
			int position = 0;

			while (!existence) {
				System.out.println("\nType the Consumer User Id: ");
				System.out.println("(In case you Type a Wrong Id, You can Type it again");
				consumerId = reader.nextLine();
				if (controller.checkConsumer(consumerId) != -1) {
					position = controller.checkConsumer(consumerId);
					existence = true; 		
				}

			}
			System.out.print(controller.showAllplayList(position));
			break;
		case 3:
			editAPlaylist();
			break;
		default:
			System.out.println("You must type a valid option");
			break;

		}		

	}

	private void editAPlaylist() {

		System.out.println("\nType an option");
		System.out.println("1. Add a Song");
		System.out.println("2. See all Users");
		System.out.println("0. Go Back");

		int mainOption = reader.nextInt();

		switch (mainOption) {

		case 1:
			registerUser();
			break;
		case 2:
			System.out.print(controller.showUserList());	
			break;
		case 3:
			break;
		case 0:
			break;
		default:
			System.out.println("You must type a valid option");
			break;

		}

	}

	private void userConfig() {

		System.out.println("\nType an option");
		System.out.println("1. Register a User");
		System.out.println("2. See all Users");
		System.out.println("0. Go Back");

		int mainOption = reader.nextInt();

		switch (mainOption) {

		case 1:
			registerUser();
			break;
		case 2:
			System.out.print(controller.showUserList());	
			break;
		case 3:
			break;
		case 0:
			break;
		default:
			System.out.println("You must type a valid option");
			break;

		}
	}

	public void registerUser() {

		System.out.println("Select User Type: \nProducer [1] \nConsumer [2]");
		int selectUser = reader.nextInt();	

		switch (selectUser) {
		case 1:
			registerProducer();
			break;
		case 2: 
			registerConsumer();
			break;
		default:
			System.out.println("You must type a valid option");
			break;	
		}
	}

	public void registerProducer(){

		System.out.println("Select User Type: \nArtist [1] \nContentCreator [2]");
		int selectUser = reader.nextInt();

		reader.nextLine();
		System.out.println("Type the new User's name: ");
		String nickName = reader.nextLine();

		System.out.println("Type the new User's id: ");
		String id = reader.nextLine();

		System.out.println("Type the new image URL: ");
		String imageURL = reader.nextLine();

		double acumulatedPlaybacks = 0;
		double acumPlaysByConsumer = 0;

		switch (selectUser) {
		case 1:
			if (controller.registerArtist(nickName, id, imageURL, acumulatedPlaybacks,
					acumPlaysByConsumer)) {

				System.out.println("\nUser registered successfully");

			} else {

				System.out.println("\nError, User couldn't be registered");
			}
			break;
		case 2: 
			if (controller.registerContentCreator(nickName, id, imageURL, acumulatedPlaybacks,
					acumPlaysByConsumer)) {

				System.out.println("\nUser registered successfully");

			} else {

				System.out.println("\nError, User couldn't be registered");
			}
			break;
		}	
	}	

	public void registerConsumer(){

		System.out.println("\nSelect User Type: \nStandard [1] \nPremium [2]");
		int selectUser = reader.nextInt();	

		reader.nextLine();
		System.out.println("\nType the new User's name: ");
		String nickName = reader.nextLine();

		System.out.println("\nType the new User's id: ");
		String id = reader.nextLine();

		switch (selectUser) {
		case 1:
			if (controller.registerStandard(nickName, id)) {

				System.out.println("\nUser registered successfully");

			} else {

				System.out.println("\nError, User couldn't be registered");
			}
			break;
		case 2: 
			if (controller.registerPremium(nickName, id)) {

				System.out.println("\nUser registered successfully");

			} else {

				System.out.println("\nError, User couldn't be registered");
			}
			break;	
		}

	}

	private void audioConfig() {

		System.out.println("\nType an option");
		System.out.println("1. Register an Audio");
		System.out.println("2. See all Songs");
		System.out.println("3. See all Podcasts");
		System.out.println("4. See all Audios by Producers");
		System.out.println("5. Play an audio (Simulation)");
		System.out.println("6. Buy a Song");
		System.out.println("0. Go Back");

		int mainOption = reader.nextInt();

		switch (mainOption) {

		case 1:
			registerAudio();
			break;
		case 2:
			System.out.print(controller.showAudioList(1));
			break;
		case 3:
			System.out.print(controller.showAudioList(2));
			break;
		case 4:
			seeAudiobyProducer();
			break;
		case 5:
			simulatedAudio();
			break;
		case 6:
			buyAsong();
			break;
		default:
			System.out.println("\nYou must type a valid option");
			break;

		}	

	}

	private void simulatedAudio() {
		reader.nextLine();
		String consumerId = "";
		boolean existence = false;
		int position = 0;

		while (!existence) {
			System.out.println("\nType the Consumer User Id: ");
			System.out.println("(In case you Type a Wrong Id, You can Type it again");
			consumerId = reader.nextLine();
			if (controller.checkConsumer(consumerId) != -1) {
				position = controller.checkConsumer(consumerId);
				existence = true; 		
			}
		}
		System.out.print(controller.seeAddedAudio(position));
		
		System.out.println("\nType the name of the Audio that you want to play: ");
		String audioName = reader.nextLine();



	}

	private void seeAudiobyProducer() {
		System.out.println("Select User Type: \nArtist [1] \nContentCreator [2]");
		int userType = reader.nextInt();
		switch (userType) {
		case 1:
			String artistId = "";
			reader.nextLine();
			while (controller.checkArtistExistence(artistId) == -1) {
				System.out.println("\nType the Artist Id: ");
				System.out.println("(In case you Type a Wrong Id, You can Type it again");
				artistId = reader.nextLine();
			}
			System.out.println(controller.seeCreatedAudio(userType,controller.checkArtistExistence(artistId)));
			break;
		case 2:
			String contentId = "";
			reader.nextLine();

			while (controller.checkContentCreatorExistence(contentId) == -1) {
				System.out.println("\nType the Content Creator Id: ");
				System.out.println("(In case you Type a Wrong Id, You can Type it again");
				contentId = reader.nextLine();
			}
			System.out.println(controller.seeCreatedAudio(userType,controller.checkArtistExistence(contentId)));
			break;
		}
	}

	private void registerAudio() {

		System.out.println("\nSelect Audio Type: \n[1]Song  \n[2]Podcast ");
		int selectUser = reader.nextInt();	

		switch (selectUser) {
		case 1:
			registerSong();
			break;
		case 2: 
			registerPodcast();
			break;
		default:
			System.out.println("\nYou must type a valid option");
			break;	
		}	
	}

	private void registerSong() {
		String artistId = "";
		reader.nextLine();
		while (controller.checkArtistExistence(artistId) == -1) {
			System.out.println("\nType the Artist Id: ");
			System.out.println("(In case you Type a Wrong Id, You can Type it again");
			artistId = reader.nextLine();
		}

		System.out.println("\nType the new Song's name: ");
		String name = reader.nextLine();

		System.out.println("\nType the new Song's image URL: ");
		String imageURL = reader.nextLine();

		System.out.println("\nType the new User's duration: (Seconds) ");
		int duration = reader.nextInt();

		System.out.println("\nType the new Song's album: ");
		String album = reader.nextLine();

		System.out.println("\nType the new Song's Genre: \n[1]ROCK \n[2]POP \n[3]TRAP \n[4] HOUSE");
		int genre = reader.nextInt();

		System.out.println("\nType the new Song's sale Value: ");
		double saleValue = reader.nextDouble();

		if (controller.registerSong(name, imageURL, duration, 0, album, genre,
				saleValue, 0, controller.checkArtistExistence(artistId))) {

			System.out.println("\nSong registered successfully");

		} else {

			System.out.println("\nError, Song couldn't be registered");
		}	
	}	

	private void registerPodcast() {
		String contentId = "";
		reader.nextLine();

		while (controller.checkContentCreatorExistence(contentId) == -1) {
			System.out.println("\nType the Content Creator Id: ");
			System.out.println("(In case you Type a Wrong Id, You can Type it again");
			contentId = reader.nextLine();
		}

		reader.nextLine();
		System.out.println("\nType the new User's name: ");
		String name = reader.nextLine();

		System.out.println("\nType the new Podcast's image URL: ");
		String imageURL = reader.nextLine();

		System.out.println("\nType the new Podcast's duration: (Seconds) ");
		int duration = reader.nextInt();

		System.out.println("\nType the new Podcast's description: ");
		String description = reader.nextLine();

		System.out.println("\nType the new Podcast's Category: \n[1]POLITICS \n[2]ENTERTAIMENT \n[3]VIDEOGAMES \n[4] FASHION");
		int category = reader.nextInt();


		if (controller.registerPodcast(name, imageURL, duration, 0, description,
				category,controller.checkContentCreatorExistence(contentId))) {

			System.out.println("\nPodcast registered successfully");

		} else {

			System.out.println("\nError, Podcast couldn't be registered");
		}
	}

	private void registerPlaylist() {
		reader.nextLine();

		String consumerId = "";
		int pos = -1;
		while (pos == -1) {
			System.out.print("\nType the User's Id: ");
			System.out.print("\n(In case you Type a Wrong Id, You can Type it again)");
			consumerId = reader.nextLine();
			if (controller.checkConsumer(consumerId) > -1) {
				pos = controller.checkConsumer(consumerId);
			}
		}
		System.out.print("\nType the Playlist's name: ");
		String name = reader.nextLine();

		System.out.print("\nType the Playlist's name: \n[1]SONG \n[2]PODCAST \n[3]MIXED");
		int plType = reader.nextInt();

		if (controller.registerPlaylist(name, plType, pos)) {

			System.out.println("\nPlaylist added successfully");

		} else {

			System.out.println("\nError, Playlist couldn't be added");
		}
	}

	private void buyAsong() {
		System.out.print(controller.showAudioList(1));
		reader.nextLine();
		String name = "";

		while (controller.checkSongExistence(name) == -1) {
			System.out.println("\nType the Song's name: ");
			System.out.println("(In case you Type a Wrong Song's Name, You can Type it again)");
			name = reader.nextLine();
		}

		String consumerId = "";
		boolean existence = false;
		int position = 0;

		while (!existence) {
			System.out.println("\nType the Consumer User Id: ");
			System.out.println("(In case you Type a Wrong Id, You can Type it again");
			consumerId = reader.nextLine();
			if (controller.checkConsumer(consumerId) != -1) {
				position = controller.checkConsumer(consumerId);
				existence = true; 		
			}
		}

		if (controller.buySong(controller.checkSongExistence(name), position)) {

			System.out.println("\nSong added successfully");
			controller.addANewBuy(controller.checkSongExistence(name));

		} else {

			System.out.println("\nError, Song couldn't be added");
		}

	}
}
