package model;

import java.time.LocalDate;

public abstract class Consumer extends User implements AddedSongs{

	private String mostListenedGenre;
	private int playsMostListenedGenre;
	private String mostListenedCategory;
	private int playsMostListenedCategory;
	private NeoTunesHistory nThistory;


	public Consumer(String nickName, String id, LocalDate dates) {
		super(nickName, id, dates);
		nThistory = new NeoTunesHistory();

	}

	public String getMostListenedGenre() {
		return mostListenedGenre;
	}

	public int getPlaysMostListenedGenre() {
		return playsMostListenedGenre;
	}

    public String getMostListenedCategory() {
        return mostListenedCategory;
    }

    public int getPlaysMostListenedCategory() {
        return playsMostListenedCategory;
    }

	public void getGenreOrCat(Audio audio) {

		if (audio instanceof Song) {
			addPlayback(((Song) audio).getGenre());
		}
		if (audio instanceof Podcast) {
			addPlayback(((Podcast) audio).getCategory());

		}		
	}

	/**
	 * @param genre
	 */
	 public void addPlayback(Genre genre) {
		 switch (genre) {
		 case ROCK:
			 nThistory.setRock(nThistory.getRock() + 1);
			 break;
		 case TRAP:
			 nThistory.setTrap(nThistory.getTrap() + 1);
			 break;
		 case POP:
			 nThistory.setPop(nThistory.getPop() + 1);
			 break;
		 case HOUSE:
			 nThistory.setHouse(nThistory.getHouse() + 1);
			 break;
		 }
	 }

	 /**
	  * @param category
	  */
	 public void addPlayback(Category category) {
		 switch (category) {
		 case POLITICS:
			 nThistory.setPolitic(nThistory.getPolitic() + 1);
			 break;
		 case ENTERTAIMENT:
			 nThistory.setEntertainment(nThistory.getEntertainment() + 1);
			 break;
		 case VIDEOGAMES:
			 nThistory.setVideoGame(nThistory.getVideoGame() + 1);
			 break;
		 case FASHION:
			 nThistory.setFashion(nThistory.getFashion() + 1);
			 break;
		 }
	 }

	 public void calculateMostListenedCategory() {
		 int[] reps = { nThistory.getPolitic(), nThistory.getEntertainment(), nThistory.getVideoGame(), nThistory.getFashion() };

		 String mostReps = null;
		 int getHigher = 0;

		 for (int i = 0; i < reps.length; i++) {
			 if (reps[i] > getHigher) {
				 getHigher = reps[i];
				 if (i == 0)
					 mostReps = "Politic";
				 else if (i == 1)
					 mostReps = "Entertainment";
				 else if (i == 2)
					 mostReps = "Video games";
				 else if (i == 3)
					 mostReps = "Fashion";
			 }
		 }
		 this.mostListenedCategory = mostReps;
		 this.playsMostListenedCategory = getHigher;
	 }

	 public void calculateMostListenedGenre() {

		 int[] reps = { nThistory.getRock(), nThistory.getPop(), nThistory.getTrap(), nThistory.getHouse() };

		 String mostReps = null;
		 int getHigher = 0;

		 for (int i = 0; i < reps.length; i++) {
			 if (reps[i] > getHigher) {
				 getHigher = reps[i];
				 if (i == 0)
					 mostReps = "Rock";
				 else if (i == 1)
					 mostReps = "Pop";
				 else if (i == 2)
					 mostReps = "Trap";
				 else if (i == 3)
					 mostReps = "House";
			 }
		 }
		 this.mostListenedGenre = mostReps;
		 this.playsMostListenedGenre = getHigher;
	 }

}
