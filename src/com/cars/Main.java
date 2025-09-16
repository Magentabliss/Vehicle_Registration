package com.cars;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Car>cars = new ArrayList<>();

        int menu;
        System.out.println("Good day. Welcome to the vehicle Registration App!");

        do {
            System.out.println("Select an option:");
            System.out.println("1. Register a new vehicle:");
            System.out.println("2. View vehicle report");
            System.out.println("3. Exit the application:");
            System.out.println("Enter your choice:");
            menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                Car car = new Car();
                System.out.println("Enter vehicle brand");
                car.setBrand(sc.nextLine());
                System.out.println("Enter vehicle model");
                car.setModel(sc.nextLine());

                String vin;
                while (true) {
                    System.out.println("Enter VIN(17 characters):");
                    vin = sc.nextLine();
                    if (vin.length() == 17) {
                        car.setVin(vin);
                        break;
                    } else {
                        System.out.println("VIN must be 17 characters");
                    }
                }
                System.out.println("Select license plate format:");
                System.out.println("1. Old format ABC123GP");
                System.out.println("2. New format AB123CGP");
                System.out.println("Enter option:");
                int plate = sc.nextInt();
                sc.nextLine();

                if (plate == 1) {
                    System.out.println("Enter old format plate:");
                    car.setPlateNumber(sc.nextLine());
                } else if (plate == 2) {
                    System.out.println("Enter new format plate");
                    car.setPlateNumber(sc.nextLine());
                } else {
                    System.out.println("Invalid choice");
                    car.setPlateNumber("Invalid Option");
                }

                System.out.println("Enter vehicle mileage:");
                car.setMileage(sc.nextInt());

                System.out.println("Enter year of manufacture (2021)");
                car.setYear(sc.nextInt());
                sc.nextLine();

                cars.add(car);
                System.out.println("Vehicle registered suuccessfully!!");
            }
            else if (menu==2){
                System.out.println("**** VEHICLE REPORT ***");
                if(cars.isEmpty()){
                    System.out.println("No vehicle have been registered yet.");
                }else{
                    for(Car c:cars){
                        System.out.println("_______");
                        System.out.println("Brand:"+ c.getBrand());
                        System.out.println("Model:" + c.getModel());
                        System.out.println("VIN:" + c.getVin());
                        System.out.println("Plate Number:" + c.getPlateNumber());
                        System.out.println("Mileage:" + c.getMileage());
                        System.out.println("Year:" + c.getYear());
                    }
                }

            } else if (menu == 3) {
                System.out.println("Thank you for using the App!!");
            } else{
                System.out.println("Invalid option\n Please select 1, 2, 3.");
            }
        }while(menu!=3);
        sc.close();
    }
}
