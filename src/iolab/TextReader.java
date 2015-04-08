/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iolab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author mpatel6
 */
public class TextReader {

    private static final int ERROR = JFileChooser.ERROR_OPTION;
    private static final int APPROVE = JFileChooser.APPROVE_OPTION;
    private static final int CANCEL = JFileChooser.CANCEL_OPTION;

    public static void main(String[] args) throws Exception {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (!(result == APPROVE)) {
            System.exit(0);
        }

        File file = fileChooser.getSelectedFile();

        BufferedReader in = null;
        List<Employee> employees = new ArrayList<>();
        try {
            if (file.exists() && file.canRead() && file.isFile()) {
                in = new BufferedReader(
                        new FileReader(file));

                String line = in.readLine();
                while (line != null) {
                    //  System.out.println(line);

                    String[] name = line.split(" ");
                    String firstName = name[0];
                    String lastName = name[1];
                    //System.out.println(firstName + "//" + lastName);

                    line = in.readLine();
                    String streetAddress = line;
                    //  System.out.println(streetAddress);

                    line = in.readLine();
                    String[] cityStateZipInfo = line.split(",");
                    String city = cityStateZipInfo[0];
                    String[] stateZipInfo = cityStateZipInfo[1].split(" ");
                    String state = stateZipInfo[0];
                    String zip = stateZipInfo[1];
                    // System.out.println(city + " "+ state + " "+ zip);
                    Employee employee = new Employee(firstName, lastName, streetAddress, city, state, zip);
                    employees.add(employee);
                    line = in.readLine();	// strips out any carriage return chars
                    //  System.out.println(line);
                    line = in.readLine();
                    // System.out.println("New Line char"+line);
                }
            }

        } catch (IOException ioe) {
            throw ioe;
        } finally {
            try {
                in.close();
            } catch (Exception e) {

            }
        }

        for (Employee e : employees) {
            System.out.println(e);
            System.out.println("\n");
        }

        Employee newEmployee1 = new Employee("Ankita", "Patel", "13435 Jackson St", "New Berlin", "WI", "53132");
        Employee newEmployee2 = new Employee("Biren", "Patel", "2000 Arrowhead St", "Iselin", "NJ", "89023");
        boolean append = true;

        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file, append)));

        out.println();
        out.println(newEmployee1.getFirstName() + " " + newEmployee1.getLastName());
        out.println(newEmployee1.getStreetAddress());
        out.println(newEmployee1.getCity() + "," + newEmployee1.getState() + " " + newEmployee1.getZip());

        out.println();
        out.println(newEmployee2.getFirstName() + " " + newEmployee2.getLastName());
        out.println(newEmployee2.getStreetAddress());
        out.println(newEmployee2.getCity() + "," + newEmployee2.getState() + " " + newEmployee2.getZip());

        out.close();  // be sure you close your streams when done!!

        System.out.println("Wrote file to: " + file.getAbsolutePath());
    }

}
