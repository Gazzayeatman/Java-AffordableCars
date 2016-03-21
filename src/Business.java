import java.util.ArrayList;
import java.util.Collections;

public class Business {
	public static ArrayList<Yard> myYards = new ArrayList<Yard>();
	public static ArrayList<Employee> myEmployees = new ArrayList<Employee>();
	public static ArrayList<Customer> MyCustomers = new ArrayList<Customer>();

//------Setters
	public static Yard getYardByName(String name){
		Yard result = null;
		for(Yard i : Business.myYards){
			if(name.equals(i.getName())){
				result = i;
			}
		}
		return result;
	}
	public static void printAllCars(){
		for (Yard i : Business.myYards){
			i.printAllCars();
		}
	}
	public static String getAllCarsByMake(String make){
		String result = "";
		for (Yard y : Business.myYards){
			for(Car c : y.myCars){
				if(c.getMake().equals(make)){
					result += c.get() + "\n";
				}
			}
		}
		return result;
	}
	public static Car getHighestPriceCar(){
		int result = 0;
		Car car = null;
		for (Yard y : Business.myYards){
			for(Car c : y.myCars){
				if(c.getPrice() > result){
					result = c.getPrice();
					car = c;
				}
			}
		}
		return car;
	}
	public static Car getLowestPriceCar(){
		int result = 999999;
		Car car = null;
		for (Yard y : Business.myYards){
			for(Car c : y.myCars){
				if(c.getPrice() < result){
					result = c.getPrice();
					car = c;
				}
			}
		}
		return car;
	}
//------Functions
	public static void addYard(String name, String address, String num){
		Yard y = new Yard(name, address,num);
	}
}


