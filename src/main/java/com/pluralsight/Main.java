package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DealershipFileManager dealership = new DealershipFileManager();
        Dealership d2 = dealership.getDealership();
        System.out.println(d2);
        UserInterface user = new UserInterface();

        user.display();


    }
}
