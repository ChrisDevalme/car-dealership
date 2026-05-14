package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {

        List<Vehicle> foundVehicles = new ArrayList<>();
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if(vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice){
                foundVehicles.add(vehicle);
                found = true;
            }
        }
        if(!found){
            System.out.println("No Vehicles in that price range");
        }
        return foundVehicles;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> foundVehicles = new ArrayList<>();
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if(vehicle.getMake().equalsIgnoreCase(make) && model.isEmpty()){
                foundVehicles.add(vehicle);
                found = true;
            }
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                foundVehicles.add(vehicle);
                found = true;
            }
        }
        if(!found){
            System.out.println("No Vehicles found.");
        }
        return foundVehicles;
    }
    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> foundVehicles = new ArrayList<>();
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear){
                foundVehicles.add(vehicle);
                found = true;
            }
        }
        if(!found){
            System.out.println("No Vehicles in that year range");
        }
        return foundVehicles;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> foundVehicles = new ArrayList<>();
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                foundVehicles.add(vehicle);
                found = true;
            }
            if (!found) {
                System.out.println("No Vehicles found.");
            }
        }
        return foundVehicles;
    }
    public List<Vehicle> getVehiclesByMileage(int minMilage, int maxMilage) {
        List<Vehicle> foundVehicles = new ArrayList<>();
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if(vehicle.getOdometer() >= minMilage && vehicle.getOdometer() <= maxMilage){
                foundVehicles.add(vehicle);
                found = true;
            }
        }
        if(!found){
            System.out.println("No Vehicles in that year range");
        }
        return foundVehicles;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> foundVehicles = new ArrayList<>();
        boolean found = false;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                foundVehicles.add(vehicle);
                found = true;
            }
            if (!found) {
                System.out.println("No Vehicles found.");
            }
        }
        return foundVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        return "Dealership Name: " + name +
                "\nAddress: " + address +
                "\nPhone Number: " + phone + '\n' +
                "Inventory: \n" + inventory;
    }
}
