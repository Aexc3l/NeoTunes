package model;


public abstract class Audio implements Reproducer {

	private String name;
	private String imageURL;
	private int duration;
	public double numberOfPlaybacks;

	public Audio(String name, String imageURL, int duration, double numberOfPlaybacks) {
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getNumberOfPlaybacks() {
		return numberOfPlaybacks;
	}

	public void setNumberOfPlaybacks(double numberOfPlaybacks) {
		this.numberOfPlaybacks = numberOfPlaybacks;
	}

	public String calculateDuration(){

		int audioDuration = duration;

		int hours = (audioDuration / 3600);
		int minutes = ((audioDuration-hours*3600)/60);
		int seconds = audioDuration-(hours*3600+minutes*60);

		String result = hours + ":" +minutes + ":" +  seconds;
		if (hours <= 0) {
			if (minutes < 10) {
				result =  "0" + minutes + ":" + seconds;		
			}
		}
		if (minutes >= 10 && hours <= 0) {
			result =  minutes + ":" + seconds;	
		}
		else if (minutes < 10 && hours > 0 ) {
			result = "0" + hours + ":" + "0" +minutes + ":" + seconds;	
		}
		else if (minutes > 10 && hours > 10) {
			result = hours + ":" + "0" +minutes + ":0" +  seconds ;	
		}

		return result;

	}

	@Override
	public String toString() {
		return "Audio [name=" + name + ", imageURL=" + imageURL + ", duration=" + calculateDuration() + ", numberOfPlaybacks="
				+ numberOfPlaybacks + "]";
	}



}
