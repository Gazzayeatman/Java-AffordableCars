
public class Car {
	private String make;
	private String model;
	private int year;
	private int kms;
	private String colour;
	private int price;
	private Yard myYard;

//------Setters
	public Car(String make, String model, int year, int kms, String colour, int price, Yard yard){
		this.set(make, model, year, kms, colour, price, yard);
	}
	private void set(String make, String model, int year, int kms, String colour, int price, Yard yard){
		this.make = make;
		this.model = model;
		this.year = year;
		this.kms = kms;
		this.colour = colour;
		this.price = price;
		this.myYard = yard;
		yard.myCars.add(this);
	}
//------Getters
	public String get(){
		return this.colour + " " + this.year + " " + this.make + " " + this.model + " Price: $" + this.price + " KMs: " + this.kms;
	}
	
	public int getPrice(){
		return this.price;
	}
	public String getMake(){
		return this.make;
	}
}
