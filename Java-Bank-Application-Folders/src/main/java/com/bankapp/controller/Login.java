package main.java.com.bankapp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    // method which checks if the given fileds are in the file
    boolean login(String name, String lastname, String personcode, String email, String nickname) {
        // Person person = new Person();
        // try {
        //     File myObj = new File("person.csv");
        //     Scanner myReader = new Scanner(myObj);

        //     while (myReader.hasNextLine()) {
        //         String data = myReader.nextLine();
        //     }
        //     myReader.close();
        // } catch (FileNotFoundException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        // }

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("data/person.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                for (String string : parts) {
                    System.out.println(string);
                }
                
                if (parts.length == 10 && parts[1].equals(name) && parts[2].equals(lastname) &&
                    parts[3].equals(personcode) && parts[5].equals(email) && parts[6].equals(nickname)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return found;
    }
}