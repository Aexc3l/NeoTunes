package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Premium extends Consumer {

	private ArrayList<Playlist> createdPlaylist;
	private ArrayList<Audio> addedAudio;
	public Scanner reader;


	public Premium(String nickName, String id, LocalDate dates) {
		super(nickName, id, dates);
		this.createdPlaylist = new ArrayList<Playlist>();
		this.addedAudio = new ArrayList<Audio>();
		reader = new Scanner(System.in);
	}

	@Override
	public boolean addAudio(Audio newAudio) {
		if (newAudio instanceof Song) {
			return addedAudio.add((Song)(newAudio));
		}else if (newAudio instanceof Podcast) {
			return addedAudio.add((Podcast)(newAudio));
		}	
		return true;
	}

	@Override
	public boolean addtoPlaylist(Audio newAudio, Playlist createdPlaylist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPlaylist(Playlist newPlaylists) {
		return createdPlaylist.add(newPlaylists);
	}
	
	public String seeAllPlaylist() {
		String allPlaylist = "";

		for (int i = 0; i < createdPlaylist.size(); i++ ) {

			if (!createdPlaylist.isEmpty()) {
				allPlaylist += "\n" + (i + 1) + ". " + createdPlaylist.get(i).toString() + "\n";
			}

		}

		return allPlaylist;
	}

	public String seeAllAddedAudio() {
		String allAudio = "";

		for (int i = 0; i < addedAudio.size(); i++ ) {

			if (!addedAudio.isEmpty() && addedAudio.get(i) instanceof Podcast) {
				allAudio += "\n" + (i + 1) + ". " + addedAudio.get(i).getName() + " (PODCAST)";
			}else if (!addedAudio.isEmpty() && addedAudio.get(i) instanceof Song) {
				allAudio += "\n" + (i + 1) + ". " + addedAudio.get(i).getName() + " (SONG)";
			}	

		}

		return allAudio;
	}

	public Audio checkExistence(String name){
		Audio pSong = null;

		for (int i = 0; i < addedAudio.size(); i++ ) {

			if (!addedAudio.isEmpty() && addedAudio.get(i).getName().equals(name) && addedAudio.get(i) instanceof Song) {
				pSong = (Song) addedAudio.get(i);
			}
			if (!addedAudio.isEmpty() && addedAudio.get(i).getName().equals(name) && addedAudio.get(i) instanceof Podcast) {
				pSong = (Podcast) addedAudio.get(i);
			}

		}

		return pSong;
	}

	public boolean playAudio(String audioName) {

		boolean stopPlaying = false;
		String selection = "";
		Audio playSong = checkExistence(audioName);
		int keepPlaying = 0;

		while (!stopPlaying) {

			System.out.println(playSong.Play());
			System.out.println("\nP: Pause" + "\nC: Check Song" + "\nN: Next Audio" + "\nF: Finish");
			selection = reader.nextLine();

			switch (selection) {

			case "P":
				System.out.println("Audio is Paused");

				System.out.println(playSong.Pause());

				System.out.println("\nC: Continue" + "\nN: Next Audio" + "\nF: Finish");
				selection = reader.nextLine();

				switch (selection) {
				case "C":
					break;

				case "N":
					stopPlaying = true;
					keepPlaying = 1;
					break;
				case "F":
					stopPlaying = true;
					System.out.println("\nGoing Back to Main Menu");
					break;	
				}
				break;
			case "F":
				stopPlaying = true;
				System.out.println("\nGoing Back to Main Menu");
				break;
			case "C":
				System.out.println	("\nName: " + playSong.getName() + "\nDuration: " + playSong.calculateDuration());
				break;
			case "N":
				stopPlaying = true;
				keepPlaying = 1;
				break;			
			}		
		}
		if (keepPlaying == 1 && stopPlaying == true) {
			stopPlaying = false;
		}
		return stopPlaying;

	}
}
