package model;

public class Podcast extends Audio {

	private String description;
	private Category category;
	private double saleValue;
	private double allSales;
	
	public Podcast(String name, String imageURL, String duration, double numberOfPlaybacks, String description,
			int category, double saleValue, double allSales) {
		super(name, imageURL, duration, numberOfPlaybacks);
		this.description = description;
		this.category = Category.values()[category-1];
		this.saleValue = saleValue;
		this.allSales = allSales;
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

}
