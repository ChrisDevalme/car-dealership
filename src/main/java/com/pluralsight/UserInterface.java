package com.pluralsight;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;
    private ArrayList<Vehicle> cart = new ArrayList<>();

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        init();
        int choice = 0;
        while(choice != 99) {
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
            System.out.println("10) View Cart");
            System.out.println("11) Remove Vehicle from Cart");
            System.out.println("12) Checkout");
            System.out.println("99) Exit");

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
                case 10 -> processViewCartRequest();
                case 11 -> processRemoveFromCartRequest();
                case 12 -> processCheckoutRequest();
                case 99 -> System.out.println("Thank you for visiting " + dealership.getName());
                default -> System.out.println("Invalid Choice!");
            }
        }
        scanner.close();

    }

    public void processGetByPriceRequest() {

        double minNum = -1;
        while(minNum == -1) {
            System.out.println("Please enter minimum number.");
            if(!scanner.hasNextDouble()) {
                System.out.println("Please enter maximum number.");
                scanner.nextLine();
                continue;
            }
            minNum = scanner.nextDouble();
            scanner.nextLine();
        }

        double maxNum = 0;
        while(maxNum == 0) {
            System.out.println("Please enter maximum number.");
            if(!scanner.hasNextDouble()) {
                System.out.println("Entry must be a positive number.");
                scanner.nextLine();
                continue;
            }
            maxNum = scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.println("Vehicles in the $" + minNum + " - $" + maxNum + " price range:" + "\n" + dealership.getVehiclesByPrice(minNum,maxNum));
        ProcessAddVehicleToCart(dealership.getVehiclesByPrice(minNum,maxNum));
    }
    public void processGetByMakeModelRequest() {
        String make = "";
        while (make.isEmpty()) {
            System.out.println("Please enter Make of Vehicle: ");
            make = scanner.nextLine();
        }
        String model = "";
        while (model.isEmpty()) {
            System.out.println("Please enter Model of Vehicle or NA to leave blank: ");
            model = scanner.nextLine();
            if(model.equalsIgnoreCase("NA")){
                model = "";
                break;
            }
        }
        System.out.println("Vehicles with your criteria: " + dealership.getVehiclesByMakeModel(make,model));
        ProcessAddVehicleToCart(dealership.getVehiclesByMakeModel(make,model));
    }
    public void processGetByYearRequest() {
        int minYear = -1;
        while(minYear == -1) {
            System.out.println("Please enter minimum Year.");
            if(!scanner.hasNextInt()) {
                System.out.println("Entry must be a positive number.");
                scanner.nextLine();
                continue;
            }
            minYear = scanner.nextInt();
            scanner.nextLine();
        }

        int maxYear = 0;
        while(maxYear == 0) {
            System.out.println("Please enter maximum Year.");
            if(!scanner.hasNextInt()) {
                System.out.println("Entry must be a positive number.");
                scanner.nextLine();
                continue;
            }
            maxYear = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Vehicles in the " + minYear + " - " + maxYear + " year range:" + "\n" + dealership.getVehiclesByYear(minYear,maxYear));
        ProcessAddVehicleToCart(dealership.getVehiclesByYear(minYear,maxYear));
    }
    public void processGetByColorRequest() {
        String color = "";
        while (color.isEmpty()) {
            System.out.println("Please enter Make of Vehicle: ");
            color = scanner.nextLine();
        }
        System.out.println("Vehicles with the color " + color + ":\n" + dealership.getVehiclesByColor(color));
        ProcessAddVehicleToCart(dealership.getVehiclesByColor(color));
    }
    public void processGetByMileageRequest() {
        int minMileage = -1;
        while(minMileage == -1) {
            System.out.println("Please enter minimum mileage.");
            if(!scanner.hasNextInt()) {
                System.out.println("Entry must be a positive number.");
                scanner.nextLine();
                continue;
            }
            minMileage = scanner.nextInt();
            scanner.nextLine();
        }

        int maxMileage = 0;
        while(maxMileage == 0) {
            System.out.println("Please enter maximum Year.");
            if(!scanner.hasNextInt()) {
                System.out.println("Entry must be a positive number.");
                scanner.nextLine();
                continue;
            }
            maxMileage = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Vehicles in the " + minMileage + " - " + maxMileage + " mileage range:" + "\n" + dealership.getVehiclesByMileage(minMileage,maxMileage));
        ProcessAddVehicleToCart( dealership.getVehiclesByMileage(minMileage,maxMileage));
    }
    public void processGetByVehicleTypeRequest() {
        String type = "";
        while (type.isEmpty()) {
            System.out.println("Please enter Type of Vehicle: ");
            type = scanner.nextLine();
        }
        System.out.println("Vehicles with the type " + type + ":\n" + dealership.getVehiclesByType(type));
        ProcessAddVehicleToCart( dealership.getVehiclesByType(type));
    }
    public void processGetAllVehiclesRequest() {
        System.out.println("Inventory: \n" + dealership.getAllVehicles());
        ProcessAddVehicleToCart(dealership.getAllVehicles());
    }
    public void processAddVehicleRequest() {
        System.out.println("Enter Vehicle vin");
        int vehicleVin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Vehicle year");
        int vehicleYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Vehicle Make");
        String vehicleMake = scanner.nextLine();
        System.out.println("Enter Vehicle Model");
        String vehicleModel = scanner.nextLine();
        System.out.println("Enter Vehicle Type");
        String vehicleType = scanner.nextLine();
        System.out.println("Enter Vehicle Color");
        String vehicleColor = scanner.nextLine();
        System.out.println("Enter Vehicle Mileage");
        int vehicleMileage = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Vehicle Price");
        double vehiclePrice = scanner.nextDouble();
        scanner.nextLine();

        dealership.addVehicle(new Vehicle(vehicleVin, vehicleYear, vehicleMake, vehicleModel, vehicleType, vehicleColor,
                vehicleMileage, vehiclePrice));

        DealershipFileManager dealer = new DealershipFileManager();
        dealer.saveDealership(dealership);


    }
    public void processRemoveVehicleRequest() {

        System.out.println(dealership);
        System.out.print("Enter the VIN of the vehicle you want to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }

    }
    private void ProcessAddVehicleToCart(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            return;
        }

        System.out.print("Would you like to add one of these vehicles to your cart? yes/no: ");
        String answer = scanner.nextLine();

        if (!answer.equalsIgnoreCase("yes")) {
            return;
        }

        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                cart.add(vehicle);
                System.out.println("Vehicle added to cart.");
                return;
            }
        }

        System.out.println("VIN not found in these results.");
    }
    public void processViewCartRequest() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        double total = 0;

        System.out.println("Your Cart:");
        for (Vehicle vehicle : cart) {
            System.out.println(vehicle);
            total += vehicle.getPrice();
        }

        System.out.printf("Total: $%.2f%n", total);
    }
    public void processRemoveFromCartRequest() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        processViewCartRequest();

        System.out.print("Enter VIN to remove from cart: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        for (Vehicle vehicle : cart) {
            if (vehicle.getVin() == vin) {
                cart.remove(vehicle);
                System.out.println("Vehicle removed from cart.");
                return;
            }
        }

        System.out.println("Vehicle not found in cart.");
    }
    public void processCheckoutRequest() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.\n");
            return;
        }

        processViewCartRequest();

        System.out.print("Checkout and purchase these vehicles? yes/no: ");
        String answer = scanner.nextLine();

        if (!answer.equalsIgnoreCase("yes")) {
            System.out.println("Checkout cancelled.");
            return;
        }

        for (Vehicle vehicle : cart) {
            dealership.removeVehicle(vehicle);
        }

        cart.clear();

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Purchase complete. Inventory updated.");
    }
    private void init() {
        DealershipFileManager dealer = new DealershipFileManager();
        this.dealership = dealer.getDealership();
    }



}
