package model;

public class NeoTunesHistory {
	//Song
	int rock = 0;
	int pop = 0; 
	int trap = 0; 
	int house = 0; 

	//Podcast
	int politic = 0; 
	int entertainment = 0;
	int videoGame = 0; 
	int fashion = 0;

	public NeoTunesHistory() {
	}
	//----------------------------Song--------------------------------------
	/** 
	 * @return int
	 */
	public int getRock() {
		return rock;
	}


	/** 
	 * @param rock
	 */
	public void setRock(int rock) {
		this.rock = rock;
	}


	/** 
	 * @return int
	 */
	public int getPop() {
		return pop;
	}


	/** 
	 * @param pop
	 */
	public void setPop(int pop) {
		this.pop = pop;
	}


	/** 
	 * @return int
	 */
	public int getTrap() {
		return trap;
	}


	/** 
	 * @param trap
	 */
	public void setTrap(int trap) {
		this.trap = trap;
	}


	/** 
	 * @return int
	 */
	public int getHouse() {
		return house;
	}


	/** 
	 * @param house
	 */
	public void setHouse(int house) {
		this.house = house;
	}

	//----------------------------Podcast--------------------------------------
	/** 
	 * @return int
	 */
	public int getPolitic() {
		return politic;
	}


	/** 
	 * @param politic
	 */
	public void setPolitic(int politic) {
		this.politic = politic;
	}


	/** 
	 * @return int
	 */
	public int getEntertainment() {
		return entertainment;
	}


	/** 
	 * @param entertainment
	 */
	public void setEntertainment(int entertainment) {
		this.entertainment = entertainment;
	}


	/** 
	 * @return int
	 */
	public int getVideoGame() {
		return videoGame;
	}


	/** 
	 * @param videoGame
	 */
	public void setVideoGame(int videoGame) {
		this.videoGame = videoGame;
	}


	/** 
	 * @return int
	 */
	public int getFashion() {
		return fashion;
	}


	/** 
	 * @param fashion
	 */
	public void setFashion(int fashion) {
		this.fashion = fashion;
	}
}
