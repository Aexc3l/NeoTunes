package model;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Producer extends User implements AddedAudio{
	
	private String imageURL;
	private double acumulatedPlaybacks;
	private double acumPlaysByConsumer;
	private ArrayList<Podcast>  producedPodcastLists;
	
	public Producer(String nickName, String id, LocalDate dates, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {
		super(nickName, id, dates);
		this.imageURL = imageURL;
		this.acumulatedPlaybacks = acumulatedPlaybacks;
		this.acumPlaysByConsumer = acumPlaysByConsumer;
		this.producedPodcastLists = new ArrayList<Podcast>();
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public double getAcumulatedPlaybacks() {
		return acumulatedPlaybacks;
	}
	
	public void setAcumulatedPlaybacks(double acumulatedPlaybacks) {
		this.acumulatedPlaybacks = acumulatedPlaybacks;
	}
	
	public double getAcumPlaysByConsumer() {
		return acumPlaysByConsumer;
	}
	
	public void setAcumPlaysByConsumer(double acumPlaysByConsumer) {
		this.acumPlaysByConsumer = acumPlaysByConsumer;
	}


}
