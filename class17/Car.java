package class17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {

	int price;
	String brand;
	int mileage;
	
	public Car(int price, String brand, int mileage) {
		this.price = price;
		this.brand = brand;
	    this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.price + " " + this.brand + " " + this.mileage;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c1 = new Car(20000, "Maruti 800", 20);
		Car c2 = new Car(20000000, "Audi R8", 5);
		Car c3 = new Car(2000000, "Mercedes", 10);
		
		List<Car> carList = new ArrayList<>();
		carList.add(c1);
		carList.add(c2);
		carList.add(c3);
		
		System.out.println(carList);
		
		Collections.sort(carList, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) { //o1 -> curr, o2  -> agli
				// TODO Auto-generated method stub
				return o1.price - o2.price; //+ve -> swap, -ve -> swap ni, 0 -> equal
			}
		});
		
		System.out.println(carList);
		Collections.sort(carList, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) { //o1 -> curr, o2  -> agli
				// TODO Auto-generated method stub
				return o2.price - o1.price; //+ve -> swap, -ve -> swap ni, 0 -> equal
			}
		});
		System.out.println(carList);
	}

}
