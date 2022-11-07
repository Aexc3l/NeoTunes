package model;

import java.sql.Date;

public class Producer extends User {
	
	private String imageURL;
	private double acumulatedPlaybacks;
	private double acumPlaysByConsumer;
	
	public Producer(String nickName, String id, Date linkingDate, String imageURL, double acumulatedPlaybacks,
			double acumPlaysByConsumer) {
		super(nickName, id, linkingDate);
		this.imageURL = imageURL;
		this.acumulatedPlaybacks = acumulatedPlaybacks;
		this.acumPlaysByConsumer = acumPlaysByConsumer;
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
