package updateTaskTwo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CabinNew cabinNew = new CabinNew();
        Passenger[][] newPassengers2 = new Passenger[12][3];
        initialise(newPassengers2);
        for (int i = 0; i < 100; i++) {
            System.out.println("A:- Adds customer to cabin:-");
            System.out.println("v:- Views All cabins:-");
            System.out.println("E:- Display Empty cabins:-");
            System.out.println("D:- Delete customer from cabin:-");
            System.out.println("F:- Find cabin from customer name:-");
            System.out.println("S:- Store Program data into file:-");
            System.out.println("L:- Load Program data from file:-");
            System.out.println("O:- View passengers Ordered alphabetically by name:-");
            System.out.println();

            System.out.print("what is your Choice:-");
            String selectLetter = input.next();
            System.out.println();

            if (selectLetter.equals("A")) {
                //call add method
                newPassengers2 = cabinNew.add(newPassengers2);
            }

            if (selectLetter.equals("V")) {
                //call view method
                newPassengers2 = cabinNew.view(newPassengers2);
            }

            if (selectLetter.equals("E")) {
                //call empty method
                cabinNew.empty(newPassengers2);
            }

            if (selectLetter.equals("D")) {
                //call delete method
                cabinNew.delete(newPassengers2);
            }

            if (selectLetter.equals("F")) {
                //call Find method
                cabinNew.find(newPassengers2);
            }

            if (selectLetter.equals("S")) {
                //call Store programme data into file method
                cabinNew.save(newPassengers2);
            }

            if (selectLetter.equals("L")) {
                //call Load programme data into file method
                cabinNew.load(newPassengers2);
            }

            if (selectLetter.equals("O")) {
                //call Ordered method
                cabinNew.Ordered(newPassengers2);
            }

            if (selectLetter.equals("T")) {
                //call Expenses method
                cabinNew.Expenses(newPassengers2);
            }

        }
    }


    public static void initialise(Passenger[][] newPassengers2) {


        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if (newPassengers2[i][j] != null) {
                    newPassengers2[i][j].setFirstName(null);
                } else {
                   // newPassengers2[i][j].setFirstName(null);
                }
            }

        }
    }
}




