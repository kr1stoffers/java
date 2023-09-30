package Lab2_auto;

import java.util.Scanner;

public class Test {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Car myCar1 = new Car("Ford", 200, "J980HF", "Mustang", 2, false);
        Car myCar2 = new Car();
        Car myCar3 = new Car("Toyota", 230, "D875AA", "Qashqai", 4, true);

        Truck myTruck = new Truck("Hyundai", 120, "T890RW", "HD78", 2, true);
        Truck myTruck2 = new Truck("Nissan", 110, "L876CS", "Cabstar", 2, true);

        GarageCar garage = new GarageCar();
        garage.addCar(myCar1);
        garage.addCar(myCar2);
        garage.addCar(myCar3);
        garage.addCar(myTruck);
        garage.addCar(myTruck2);

        garage.printGarage();

        System.out.println("Remove: ");
        int i = in.nextInt();
        garage.rmCar(i);

        garage.printGarage();
    }
}
