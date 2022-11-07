package model;


public class Audio {
	
	private String name;
	private String imageURL;
	private String duration;
	private double numberOfPlaybacks;
	
	public Audio(String name, String imageURL, String duration, double numberOfPlaybacks) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.duration = duration;
		this.numberOfPlaybacks = numberOfPlaybacks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getNumberOfPlaybacks() {
		return numberOfPlaybacks;
	}

	public void setNumberOfPlaybacks(double numberOfPlaybacks) {
		this.numberOfPlaybacks = numberOfPlaybacks;
	}

	@Override
	public String toString() {
		return "Audio [name=" + name + ", imageURL=" + imageURL + ", duration=" + duration + ", numberOfPlaybacks="
				+ numberOfPlaybacks + "]";
	}
	


}
