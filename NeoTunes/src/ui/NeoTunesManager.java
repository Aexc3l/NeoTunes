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
		controller.testCase();
	}

	public void showMainMenu() {

		System.out.println("Welcome to NeoTunes ™");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. User's Config");
			System.out.println("2. Song's Config");
			System.out.println("3. Book a Property");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

			case 1:
				userConfig();
				break;
			case 2:
				songsConfig();
				break;
			case 3:

				break;
			case 0:
				System.out.println("Thanks for using our system");
				stopFlag = true;
				break;
			default:
				System.out.println("You must type a valid option");
				break;

			}

		}
	}

	private void userConfig() {

		System.out.println("\nType an option");
		System.out.println("1. Register a User");
		System.out.println("2. See all Users");
		System.out.println("3. Book a Property");
		System.out.println("0. Exit");

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

		System.out.println("Type the new User linking date (YYYY-MM-DD): ");
		String date = reader.nextLine();	

		switch (selectUser) {
		case 1:
			if (controller.registerArtist(nickName, id, date, imageURL, acumulatedPlaybacks,
					acumPlaysByConsumer)) {

				System.out.println("User registered successfully");

			} else {

				System.out.println("Error, User couldn't be registered");
			}
			break;
		case 2: 
			if (controller.registerContentCreator(nickName, id, date, imageURL, acumulatedPlaybacks,
					acumPlaysByConsumer)) {

				System.out.println("User registered successfully");

			} else {

				System.out.println("Error, User couldn't be registered");
			}
			break;
		}	
	}	

	public void registerConsumer(){

		System.out.println("Select User Type: \nStandard [1] \nPremium [2]");
		int selectUser = reader.nextInt();	

		reader.nextLine();
		System.out.println("Type the new User's name: ");
		String nickName = reader.nextLine();

		System.out.println("Type the new User's id: ");
		String id = reader.nextLine();

		System.out.println("Type the new User linking date (YYYY-MM-DD): ");
		String date = reader.nextLine();

		switch (selectUser) {
		case 1:
			if (controller.registerStandard(nickName, id, date)) {

				System.out.println("User registered successfully");

			} else {

				System.out.println("Error, User couldn't be registered");
			}
			break;
		case 2: 
			if (controller.registerPremium(nickName, id, date)) {

				System.out.println("User registered successfully");

			} else {

				System.out.println("Error, User couldn't be registered");
			}
			break;	
		}

	}

	private void songsConfig() {

		System.out.println("\nType an option");
		System.out.println("1. Register an Audio");
		System.out.println("2. See all Songs");
		System.out.println("3. See all Podcasts");
		System.out.println("0. Exit");

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
		default:
			System.out.println("You must type a valid option");
			break;

		}	

	}

	private void registerAudio() {

		System.out.println("Select Audio Type: \nSong [1] \nPodcast [2]");
		int selectUser = reader.nextInt();	

		switch (selectUser) {
		case 1:
			registerSong();
			break;
		case 2: 
			registerPodcast();
			break;
		default:
			System.out.println("You must type a valid option");
			break;	
		}	
	}

	private void registerSong() {

		reader.nextLine();
		System.out.println("Type the new Song's name: ");
		String name = reader.nextLine();

		System.out.println("Type the new Song's image URL: ");
		String imageURL = reader.nextLine();

		System.out.println("Type the new User's duration: (00:00) ");
		String duration = reader.nextLine();

		System.out.println("Type the new Song's album: ");
		String album = reader.nextLine();

		System.out.println("Type the new Song's Genre:"
				+ "[1] ROCK"
				+ "[2] POP"
				+ "[3] TRAP"
				+ "[4] HOUSE");
		int genre = reader.nextInt();

		System.out.println("Type the new Song's sale Value: ");
		double saleValue = reader.nextDouble();

		if (controller.registerSong(name, imageURL, duration, 0, album, genre,
				saleValue, 0)) {

			System.out.println("Song registered successfully");

		} else {

			System.out.println("Error, Song couldn't be registered");
		}	
	}	

	private void registerPodcast() {

		reader.nextLine();
		System.out.println("Type the new User's name: ");
		String name = reader.nextLine();

		System.out.println("Type the new Song's image URL: ");
		String imageURL = reader.nextLine();

		System.out.println("Type the new Song's duration: ⏯ ");
		String duration = reader.nextLine();

		System.out.println("Type the new Song's album: ");
		String description = reader.nextLine();

		System.out.println("Type the new Song's Genre:"
				+ "[1] POLITICS"
				+ "[2] ENTERTAIMENT"
				+ "[3] VIDEOGAMES"
				+ "[4] FASHION");
		int category = reader.nextInt();

		System.out.println("Type the new Song's sale Value: ");
		double saleValue = reader.nextDouble();

		if (controller.registerPodcast(name, imageURL, duration, 0, description,
				category, saleValue, 0)) {

			System.out.println("Podcast registered successfully");

		} else {

			System.out.println("Error, Podcast couldn't be registered");
		}
	}

}
