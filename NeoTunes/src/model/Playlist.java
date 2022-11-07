package model;

import java.util.ArrayList;
import java.util.Random;

public class Playlist {


	private String name;
	private ArrayList<Audio> audioList; 
	private Random generateNumbers;
	private PlayType playlistType;

	public Playlist(String name, int playlistType) {
		this.name = name;
		this.playlistType = PlayType.values()[playlistType-1];
		generateNumbers = new Random();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void createNumericMatrix() {

		int rows = 6;
		int columns = 6;

		int[][] tmp = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int number = generateNumbers.nextInt(10);
				tmp[i][j] = number;
				System.out.println(tmp);
			}
		}
		
		if (playlistType == PlayType.SONGS || playlistType == PlayType.MIXED) {

			calculateCodeN(tmp);			
		}

		if (playlistType == PlayType.PODCAST || playlistType == PlayType.MIXED) {

			calculateCodeT(tmp);			
		}	
	}

	private String calculateCodeT(int[][] matrix) {
	
		String msg = "";

		return msg;
		
	}

	public String calculateCodeN(int[][] matrix) {
		
		String msg = "";

		for (int i = matrix[0].length; i > 0; i--) { // Columns

			msg += matrix[i - 1][0];

		}

		for (int i = 0; i < matrix.length; i++) { // Rows

			for (int j = 0; j < matrix[0].length; j++) { // Columns

				if (i == j && i > 0 && i < matrix.length - 1) {

					msg += matrix[i][j];

				}

			}

		}

		for (int i = matrix[0].length; i > 0; i--) { // Columns

			msg += matrix[i - 1][matrix[0].length - 1];

		}

		return msg;

	}

	public boolean addAudio(Audio addedAudio) {


		if (playlistType == PlayType.SONGS &&  addedAudio instanceof Song || playlistType == PlayType.MIXED) {

			return audioList.add(addedAudio);			
		}

		if (playlistType == PlayType.SONGS || playlistType == PlayType.MIXED && addedAudio instanceof Podcast ) {

			return audioList.add(addedAudio);			
		}

		return true;
	}




}
