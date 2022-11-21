package model;

public class Podcast extends Audio {

	private String description;
	private Category category;


	public Podcast(String name, String imageURL, int duration, double numberOfPlaybacks, String description,
			int category) {
		super(name, imageURL, duration, numberOfPlaybacks);
		this.description = description;
		this.category = Category.values()[category-1];

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "\nDescription: " + description + "\nCategory: " + category ;
	}

	public String reportString() {
		return "\nName: " + getName() + "\nCategory: " + category  + "\nNumber of Playbacks: " + getNumberOfPlaybacks();
	}

	@Override
	public String Play() {
		String play = "\n<----- <| ----- || ----- |> ----->" + calculateDuration() 
		+ "\nPlaying:      " + getName();
		numberOfPlaybacks = numberOfPlaybacks + 1;;
		return play;
	}

	@Override
	public String Pause() {
		String pause = "\n<----- <| ----- |> ----- || ----->" + calculateDuration() 
		+ "\n              " + getName();
		return pause;
	}

}
