import java.util.ArrayList;

public class Yard {
	private String name;
	private String address;
	private String phoneNumber;
	public ArrayList<Car> myCars = new ArrayList<Car>();
	
//------Setters
	public Yard(String name, String address, String num){
		this.set(name,address,num);
	}
	public void set(String name, String address, String num){
		this.name = name;
		this.address = address;
		this.phoneNumber = num;
		Business.myYards.add(this);
	}
//------Return Values
	public String getName(){
		return this.name;
	}
	public String getAddress(){
		return this.address;
	}
	public String getNumber(){
		return this.phoneNumber;
	}
	public void printAllCars(){
		View.say(this.getName());
		View.say("____________________________________________________________________________________");
		for(Car i : this.myCars){
			View.say(i.get());
		}
		View.say("____________________________________________________________________________________");
	}
	public Car getHighestPriceCar(){
		int result = 0;
		Car car = null;
		for(Car c : this.myCars){
			if(c.getPrice() > result){
				result = c.getPrice();
				car = c;
			}
		}
		return car;
	}
	public Car getLowestPriceCar(){
		int result = 999999;
		Car car = null;
		for(Car c : this.myCars){
			if(c.getPrice() < result){
				result = c.getPrice();
				car = c;
			}
		}
		return car;
	}
	public String getAllCarsByMake(String make){
		String result = "";
		for(Car c : this.myCars){
			if(c.getMake().equals(make)){
				result += c.get() + "\n";
			}
		}
		return result;
	}
//------Functions
	public void addCar(String make, String model,int year, int kms, String colour, int price){
		Car c = new Car(make,model,year,kms,colour,price,this);
	}
}
