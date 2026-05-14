package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {
    private static final String fileName = "dealership.csv";


    public Dealership getDealership() {
        String line;
        Dealership dealership = null;
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("\\|");
                if(count == 0) {
                    String dealershipName = lines[0];
                    String dealershipAddress = lines[1];
                    String dealershipPhone = lines[2];
                    dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone);
                } else {
                    int vehicleVin = Integer.parseInt(lines[0]);
                    int vehicleYear = Integer.parseInt(lines[1]);
                    String vehicleMake = lines[2];
                    String vehicleModel = lines[3];
                    String vehicleType = lines[4];
                    String vehicleColor = lines[5];
                    int vehicleMilage = Integer.parseInt(lines[6]);
                    double vehiclePrice = Double.parseDouble(lines[7]);
                    Vehicle vehicle = new Vehicle(vehicleVin,vehicleYear,vehicleMake,vehicleModel,vehicleType,vehicleColor,vehicleMilage,vehiclePrice);
                    dealership.addVehicle(vehicle);
                }
                count++;
            }
        } catch (Exception e) {
            System.out.println("invalid file name");
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership) {

    }
}
