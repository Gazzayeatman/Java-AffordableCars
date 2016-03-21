import javax.swing.JComboBox;

public class Main {

	public static void main(String[] args) {
		
		Business.addYard("Wellington Central", "12 Courtenay Place", "04 559 5857");
		Business.addYard("Karori", "123 Chaytor Street", "04 434 4556");
		Yard central = Business.getYardByName("Wellington Central");
		Yard karori = Business.getYardByName("Karori");
		
		//Central
		central.addCar("Honda", "Accord Euro R", 2004, 140000, "Blue", 145000);
		central.addCar("Subaru", "Legacy B4", 2006, 200000, "Black", 15000);
		central.addCar("Toyota", "Altezza", 2000, 250000, "Silver", 7000);
		central.addCar("Honda", "Jazz", 2001, 12000, "Red", 4500);
		//Karori
		karori.addCar("Suzuki", "Swift", 2004, 12000, "Blue", 10000);
		karori.addCar("BMW", "318i", 2000, 300000, "Silver", 2000);
		karori.addCar("Honda", "Oddyssey", 1990, 340000, "White", 1000);
		Business.printAllCars();
		View.say("Most expensive " + karori.getHighestPriceCar().get());
		View.say("Least expensive " + karori.getLowestPriceCar().get());
		
		View.say("All Hondas \n" + Business.getAllCarsByMake("Honda"));
	}
}
