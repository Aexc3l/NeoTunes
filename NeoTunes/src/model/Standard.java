package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Standard extends Consumer {

	private Playlist[] createdPlaylist;
	private Audio[] addedAudios;
	public Scanner reader;

	public Standard(String nickName, String id, LocalDate dates) {
		super(nickName, id, dates);
		this.createdPlaylist = new Playlist[20];
		this.addedAudios = new Audio[100];
		reader = new Scanner(System.in);
	}

	@Override
	public boolean addAudio(Audio newAudio) {
		for (int i = 0; i < addedAudios.length; i++ ) {
			if (newAudio instanceof Song && addedAudios[i] == null) {
				addedAudios[i] = ((Song)(newAudio));
				return true;
			}else if (newAudio instanceof Podcast && addedAudios[i] == null) {
				addedAudios[i] = ((Podcast)(newAudio));
				return true;
			}	
		}
		return false;
	}

	@Override
	public boolean addtoPlaylist(Audio newAudio, Playlist createdPlaylist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPlaylist(Playlist newPlaylist) {
		for (int i = 0; i < createdPlaylist.length; i++ ) {
			if (createdPlaylist[i] == null) {
				createdPlaylist[i] = newPlaylist;
				return true;
			}	
		}
		return false;
	}

	public String seeAllPlaylist() {
		String allPlaylist = "";

		for (int i = 0; i < createdPlaylist.length; i++ ) {

			if (createdPlaylist[i] != null) {
				allPlaylist += "\n" + (i + 1) + ". " + createdPlaylist[i].toString() + "\n";
			}

		}

		return allPlaylist;
	}

	public String seeAllAddedAudio() {
		String allAudio = "";

		for (int i = 0; i < addedAudios.length; i++ ) {

			if (addedAudios[i] != null && addedAudios[i] instanceof Song) {
				allAudio += "\n" + (i + 1) + ". " + addedAudios[i].getName() + " (SONG)";
			}

		}
		for (int i = 0; i < addedAudios.length; i++ ) {

			if (addedAudios[i] != null && addedAudios[i] instanceof Podcast) {
				allAudio += "\n" + (i + 1) + ". " + addedAudios[i].getName() + " (PODCAST)";
			}

		}

		return allAudio;
	}

	public Audio checkExistence(String name){
		Audio pSong = null;

		for (int i = 0; i < addedAudios.length; i++ ) {

			if (addedAudios[i] != null && addedAudios[i].getName().equals(name) && addedAudios[i] instanceof Song) {
				pSong = (Song) addedAudios[i];
			}
			if (addedAudios[i] != null && addedAudios[i].getName().equals(name) && addedAudios[i] instanceof Podcast) {
				pSong = (Podcast) addedAudios[i];
			}

		}

		return pSong;
	}

	public boolean playAudio(String audioName) {

		boolean stopPlaying = false;
		String selection = "";
		Audio playAudio = checkExistence(audioName);
		int keepPlaying = 0;

		while (!stopPlaying) {

			System.out.println(playAudio.Play());
			System.out.println("\nP: Pause" + "\nC: Check Song" + "\nN: Next Song" + "\nF: Finish");
			selection = reader.nextLine();

			switch (selection) {

			case "P":
				System.out.println("Audio is Paused");

				System.out.println(playAudio.Pause());

				System.out.println("\nC: Continue" + "\nN: Next Song" + "\nF: Finish");
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
					break;	
				}
				break;
			case "F":
				stopPlaying = true;
				break;
			case "C":
				System.out.println	("\nName: " + playAudio.getName() + "\nDuration: " + playAudio.calculateDuration());
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

