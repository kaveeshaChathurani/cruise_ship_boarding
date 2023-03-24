package TaskTwo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CabinNew  {




    public static void main(String []args){

        Scanner input=new Scanner(System.in);
        Passenger[][] newPassengers2 = new Passenger[12][3];
        for (int i=0;i<100;i++){
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
                newPassengers2= add(newPassengers2);
            }

            if (selectLetter.equals("V")) {
                //call view method
                newPassengers2= view(newPassengers2);
            }

            if (selectLetter.equals("E")){
                //call empty method
                empty(newPassengers2);
            }

            if (selectLetter.equals("D")){
                //call delete method
                 delete(newPassengers2);
            }

            if (selectLetter.equals("F")){
                //call Find method
                find(newPassengers2);
            }

            if (selectLetter.equals("S")){
                //call Store programme data into file method
                save(newPassengers2);
            }

            if (selectLetter.equals("L")){
                //call Load programme data into file method
               load(newPassengers2);
            }

            if (selectLetter.equals("O")){
                //call Ordered method
                Ordered(newPassengers2);
            }

            if (selectLetter.equals("T")){
                //call Expenses method
                Expenses(newPassengers2);
            }

        }
    }

    //Start Expenses method
    private static void Expenses(Passenger[][] newPassengers2) {
        System.out.println("Start Task_2 Expenses..");
        //create new Array [expenses] because get per passenger expenses
        int []expenses=new int[36];

        int k=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                if (newPassengers2[i][j]==null){

                    System.out.print("");
                } else if (k<36){
                    expenses[k] =newPassengers2[i][j].getExpenses();
                    ++k;

                }

            }

        }
        //create variable to get total value and initialize zero
        int total=0;
        //add expenses, to total variable using for loop
        for (int i = 0; i <36 ; i++) {
            total+=expenses[i];
        }

        //=============START diplay expenses

        for (int i=0;i<12;i++){
            for (int j=0;j<3;j++){
                if (newPassengers2[i][j]!=null) {
                    System.out.println("Room " + i + "" + "'s Slot " + j + ":- " + newPassengers2[i][j].getExpenses()+" ");
                }else{
                    System.out.print("");
                }
            }

        }




        //=============END diplay expenses



        //display Total
        System.out.println("Total Of All Passengers:-"+total);
        System.out.println();


    }

    private static void Ordered(Passenger[][] newPassengers2) {
        System.out.println("Start Task_2 Sort");
        //create names array because get all passenger's first name
        String []names=new String[36];


        //start passenger's firstName to move names Array
        int k=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                if (newPassengers2[i][j]==null){

                    System.out.print("");
                } else if (k<36){
                    names[k] =newPassengers2[i][j].getFirstName();
                    ++k;

                }

            }

        }

        //start sorting
        for (int i = 0; i < names.length ; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i]==null | names[j]==null){
                    System.out.print("");
                }else if (names[i]!=null | names[j]!=null){
                    if (names[i].compareTo(names[j]) > 0) {
                        String temp;
                        temp = names[i];
                        names[i] = names[j];
                        names[j] = temp;
                    }
                }
            }
        }

        //end sorting

        //start display passenger by alphabetically by name
        System.out.println("START View passengers Ordered alphabetically by name.");
        System.out.println();
        for (int i = 0; i < 36; i++) {
            if (names[i]==null){
                System.out.print("");

            }else {

                System.out.println(names[i]);
            }

        }
        System.out.println();
        System.out.println("END View passengers Ordered alphabetically by name.");
        //end display passenger by alphabetically by name
    }

    //start load method
    private static void load(Passenger[][] newPassengers2) {
        File myObj = new File("D:\\cabinTask_2.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());

        } else {
            System.out.println("The file does not exist.");
        }
        System.out.println("");

    }
    //end load method


    private static void save(Passenger[][] newPassengers2) {
        try {
            //create save file
            FileWriter saveArray = new FileWriter("D:\\cabinTask_2.txt");
            System.out.println("Start writing");
            for (int i = 0; i < 12; i++) {
                for (int j=0;j<3;j++){
                    if(newPassengers2[i][j]==null){
                        System.out.print("");
                    }else {

                        saveArray.write("cabin Room "+i+" Slot "+j+" First_Name :- "+newPassengers2[i][j].getFirstName()+"\n");
                        saveArray.write("cabin Room "+i+" Slot "+j+" Sur_Name :- "+newPassengers2[i][j].getSurName()+"\n");
                        saveArray.write("cabin Room "+i+" Slot "+j+" Expenses :- "+newPassengers2[i][j].getExpenses()+"\n");
                    }
                }
            }
            //close file
            saveArray.close();
            System.out.println("Sucess......");
        }catch (IOException saveArray) {
            System.out.println("Incorrect Input");
            saveArray.printStackTrace();
        }
    }

    private static void find(Passenger[][] newPassengers2) {
        Scanner input=new Scanner(System.in);
        System.out.print("What do you want Customer Cabin Number:-");
        String cstCbnName=input.next();
        for (int i=0;i<11;i++) {
            for (int j=0;j<3;j++){

                if (newPassengers2[i][j] == null) {
                    System.out.print("");
                } else {
                    if (newPassengers2[i][j].getFirstName().equals(cstCbnName)) {
                        System.out.println(cstCbnName+":-" +"Room " + i + "" + "'s Slot " + j + " ");
                        System.out.println();
                    } else {
                        System.out.println("There are no customer in this name");
                        System.out.println();
                    }

                }
            }
        }


    }

    private static Passenger[][] delete(Passenger[][] newPassengers2) {
        Scanner input=new Scanner(System.in);

        System.out.print("What do you want delete Room Number:-");
        int roomNumber = input.nextInt();

        System.out.print("What do you want to delete cabin slot:-");
        int cabinSlot = input.nextInt();

        if (newPassengers2[roomNumber][cabinSlot] == null){
            System.out.println("Sorry There are no Customer");
            System.out.println();
        }else {
            newPassengers2[roomNumber][cabinSlot]=null;
            System.out.println("Room " + roomNumber + "" + "'s Slot " + cabinSlot + " is" +" now clear");
            System.out.println();
        }
        return newPassengers2;

    }

    private static void empty(Passenger[][] newPassengers2) {

        for (int i=0;i<12;i++){
            for (int j=0;j<3;j++){
                if (newPassengers2[i][j]==null) {

                    System.out.println("Room " + i + "" + "'s Slot " + j + " " +"null");

                }
            }
            System.out.println("");
        }
    }


    private static Passenger[][] view(Passenger[][] newPassengers2) {
        System.out.println(" Task-2_View");
        //for loop run to cabins.length
        for (int i=0;i<12;i++){
            for (int j=0;j<3;j++){
                if (newPassengers2[i][j]!=null) {

                    System.out.println("Room " + i + "" + "'s Slot " + j + " First Name:- " + newPassengers2[i][j].getFirstName()+", Sur Name:- "+newPassengers2[i][j].getSurName()+", Expenses:- "+newPassengers2[i][j].getExpenses()+" ");


                }else{
                    System.out.println("Room " + i + "" + "'s Slot " + j + " " +"null");

                }
            }
            System.out.println("");
        }
        return newPassengers2;
    }

    private static Passenger[][] add(Passenger[][] newPassengers2) {
        Passenger passenger1=new Passenger();
        System.out.println("add a customer to a cabin...");
        Scanner input=new Scanner(System.in);

        try {
            //  Block of code to try
            System.out.print("What do you want Room Number:-");
            int roomNumber = input.nextInt();

            System.out.print("What do you want to cabin slot:-");
            int cabinSlot = input.nextInt();

            if (newPassengers2[roomNumber][cabinSlot]==null){
                System.out.print("Enter First Name:");
                String fName = input.next();

                passenger1.setFirstName(fName);

                System.out.print("Enter  SurName:-");
                String sName = input.next();
                passenger1.setSurName(sName);

                System.out.print("Enter Expenses:-");
                int expenses = input.nextInt();
                passenger1.setExpenses(expenses);

                String fName1 = passenger1.getFirstName();
                String sName1 = passenger1.getSurName();
                int expenses1 = passenger1.getExpenses();


                Passenger passengerObj2 = new Passenger(fName1, sName1, expenses1);

                newPassengers2[roomNumber][cabinSlot]=passengerObj2;
            }else{
                System.out.println("Sorry this cabin slot is full..");
            }

        }
        catch(Exception e) {
            //  Block of code to handle errors
            System.out.println("Incorrect Input....");
            System.out.println();
        }


        return newPassengers2;
    }

}
