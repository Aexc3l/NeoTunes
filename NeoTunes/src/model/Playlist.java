package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Playlist {

	private int[][] idMatrix;
	private String id;
	private String name;
	private ArrayList<Audio> audioList; 
	private PlayType playlistType;

	public Playlist(String name, int playlistType) {
		this.name = name;
		this.playlistType = PlayType.values()[playlistType-1];
		this.idMatrix = new int[6][6];
		createNumericMatrix();
		this.id = generateId();
		this.audioList =  new ArrayList<Audio>();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String createNumericMatrix(){

		int rows = 6;
		int columns = 6;

		Random r = new Random();

		String tmp = "";

		for (int i = 0; i < rows; i++){
			tmp += "\n";
			for (int j = 0; j < columns; j++){
				this.idMatrix[i][j] = r.nextInt(10);
				tmp += this.idMatrix[i][j] + " ";
			}
		}
		return tmp;
	}

	public String generateId(){
		String id = "";

		int rows = 6;
		int columns = 6;

		if(playlistType == PlayType.SONGS){
			for (int i = rows - 1; i > - 1; i--){
				id += this.idMatrix[i][0];
			}
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < columns-1; j++) {
					if (i==j){
						id += this.idMatrix[i][j];
					}
				}
			}
			for (int i = rows - 1; i > -1; i--){
				id += this.idMatrix[i][5];
			}

		}else if(playlistType == PlayType.PODCAST){
			for (int j = 0; j < columns-3; j++){
				id += this.idMatrix[0][j];
			}
			for (int i = 1; i < rows; i++) {
				id += this.idMatrix[i][2];
			}
			for (int i = rows - 1; i>0; i--) {
				id += this.idMatrix[i][3];
			}
			for (int j = 3; j < columns; j++){
				id += this.idMatrix[0][j];
			}

		}else if(playlistType == PlayType.MIXED){
			for (int i = idMatrix.length - 1; i > - 1; i--){
				for (int j = idMatrix[0].length-1; j>-1; j--) {
					int number = i+j;
					if (number% 2 != 0 && number > 1) {
						id += this.idMatrix[i][j];
					}
				}	
			}
		}
		return id;
	}

	public boolean addAudio(Audio addedAudio) {


		if (playlistType == PlayType.SONGS &&  addedAudio instanceof Song || playlistType == PlayType.MIXED) {

			return audioList.add(addedAudio);			
		}

		if (playlistType == PlayType.PODCAST || playlistType == PlayType.MIXED && addedAudio instanceof Podcast ) {

			return audioList.add(addedAudio);			
		}

		return false;
	}

	public int getPodcast(){
		int audios = 0;
		for (int i = 0; i < audioList.size(); i++ ) {
			if(!audioList.isEmpty() && audioList.get(i) != null && audioList.get(i) instanceof Podcast)
				audios = audios + 1;
		}
		return audios;
	}

	public int getSong(){
		int audios = 0;
		for (int i = 0; i < audioList.size(); i++ ) {
			if (!audioList.isEmpty() && audioList.get(i) != null && audioList.get(i) instanceof Song) {
				audios = audios + 1;
			}
		}
		return audios;
	}

	@Override
	public String toString() {
		return "\nPlaylist Id: " + id + "\nName: " + name + "\nPlaylist Type: " + playlistType + "\nPodcast in Playlist: " + getPodcast() + "\nSongs in Playlist : " + getSong();
	}

}
