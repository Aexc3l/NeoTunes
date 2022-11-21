package model;

public class Song extends Audio {

	private String album;
	private Genre genre;
	private double saleValue;
	private double allSales;
	
	public Song(String name, String imageURL, int duration, double numberOfPlaybacks, String album, int genre,
			double saleValue, double allSales) {
		super(name, imageURL, duration, numberOfPlaybacks);
		this.album = album;
		this.genre = Genre.values()[genre-1];
		this.saleValue = saleValue;
		this.allSales = allSales;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}

	public double getAllSales() {
		return allSales;
	}

	public void setAllSales(double allSales) {
		this.allSales = allSales;
	}

	@Override
	public String toString() {
		return "\nAlbum: " + album + "\nGenre: " + genre + "\nSale Value: " + saleValue + "\nAll Sales: " + allSales;
	}

	public String reportString() {
		return "\nName: " + getName() + "\nGenre: " + genre + "\nNumber of Playbacks: " + getNumberOfPlaybacks() + "\nTotal Sales: " + allSales;
	}

	public void addPlayback() {
		
		allSales = allSales +1;	
	}

	@Override
	public String Play() {
		String play = "\n<----- <| ----- || ----- |> ----->" + calculateDuration() 
					+ "\nPlaying:      " + getName();
		numberOfPlaybacks = numberOfPlaybacks + 1;
		return play;
	}

	@Override
	public String Pause() {
		String pause = "\n<----- <| ----- |> ----- || ----->" + calculateDuration() 
		+ "\n              " + getName();
		return pause;
	}
}
