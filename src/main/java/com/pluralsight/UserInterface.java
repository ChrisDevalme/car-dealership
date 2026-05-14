package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        int choice = 0;
        while(choice != 10) {
            System.out.println("Welcome to " + dealership.getName());
            System.out.println("Please make a selection: ");
            System.out.println("1) View Vehicles by price ");
            System.out.println("2) View Vehicles by Make & Model ");
            System.out.println("3) View Vehicles by Year ");
            System.out.println("4) View Vehicles by Color ");
            System.out.println("5) View Vehicles by Mileage ");
            System.out.println("6) View Vehicles by Vehicle Type ");
            System.out.println("7) View all Vehicles  ");
            System.out.println("8) Add a Vehicle ");
            System.out.println("9) Remove a Vehicle ");
            System.out.println("10) Exit ");

            if(!scanner.hasNextInt()){
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest() ;
                case 10 -> System.out.println("Thank you for visiting " + dealership.getName());
                default -> System.out.println("Invalid Choice!");
            }
        }
        scanner.close();

    }

    public void processGetByPriceRequest() {

        double minNum = -1;
        while(minNum == -1) {
            System.out.println("Please enter minimum number.");
            if(!scanner.hasNextInt()) {
                System.out.println("Please enter maximum number.");
                scanner.nextLine();
                continue;
            }
            minNum = scanner.nextInt();
            scanner.nextLine();
        }

        double maxNum = 0;
        while(maxNum == 0) {
            System.out.println("Please enter maximum number.");
            if(!scanner.hasNextInt()) {
                System.out.println("Entry must be a positive number.");
                scanner.nextLine();
                continue;
            }
            maxNum = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Vehicles in the $" + minNum + " - $" + maxNum + " price range:" + "\n" + dealership.getVehiclesByPrice(minNum,maxNum));
    }
    public void processGetByMakeModelRequest() {
        System.out.println("B");
    }
    public void processGetByYearRequest() {
        System.out.println("C");
    }
    public void processGetByColorRequest() {
        System.out.println("D");
    }
    public void processGetByMileageRequest() {
        System.out.println("E");
    }
    public void processGetByVehicleTypeRequest() {
        System.out.println("F");
    }
    public void processGetAllVehiclesRequest() {
        System.out.println("Inventory: \n" + dealership.getAllVehicles());
    }
    public void processAddVehicleRequest() {
        System.out.println("H");
    }
    public void processRemoveVehicleRequest() {
        System.out.println("I");
    }
    private void init() {
        DealershipFileManager dealer = new DealershipFileManager();
        this.dealership = dealer.getDealership();
    }


}
