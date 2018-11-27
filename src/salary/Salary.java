/**
 * File: Salary.java
 * Author: Matthew Towles
 * Date: 10/29/2018
 * Purpose: Creates a salary report for employees from formatted text file
 */

package salary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Salary - displays a report for each employee each year
 * 
 * Input:
 *  Takes text file with employee info
 *  Each line of text file has info for one employee for one year
 *  Information on each line is separated by one space
 *  Assumes file contains ten employee records or less per year
 *  Assumes data in text file formatted correctly
 *  Text file format:
 *   Year Type Name Salary [Empty/AnnualSales/StockPrice]
 *  Example of text file format:
 *   2014 Employee Smith,John 2000 
 *   2015 Salesman Jones,Bill 3000 100000 
 *   2014 Executive Bush,George 5000 55
 * 
 * Output:
 *  For each year and each employee - data supplied and annual salary
 *  Each year has an average of all salaries for all employees
 * 
 * @author matthew.towles
 */
public class Salary {

    // max lines accepted in input file per year
    private static final int MAX_LINES = 10;
    
    // 2 years we are expecting in files
    private static final int YEAR1 = 2014;
    private static final int YEAR2 = 2015;
    
    // arrays for employees - one for each year
    private static Employee[] employees1 = new Employee[MAX_LINES];
    private static Employee[] employees2 = new Employee[MAX_LINES];
    
    // keep count of how many added to each array
    private static int employees1Count = 0;
    private static int employees2Count = 0;
    
    
    /**
     * Returns average salary of employees in employee array
     * 
     * @param employees
     * @param count - how many employees in array
     * @return double - average salary
     */
    private static double calcAverageSalary(Employee[] employees, int count) {
        // total salary of all employees in employee array
        double total = 0.0;
        
        // get each employee's salary and add to the total
        for (int i = 0; i < count; i++) {
            total += employees[i].annualSalary();
        }
        
        // calculate average and return
        return (total / count);
    }
    
    /**
     * Returns a message with average salary info
     * 
     * @param year
     * @param average
     * @return String - average salary message
     */
    private static String getAverageSalary(int year, double average) {
        return "\n" + getHorizontalLine() + "\nAverage salary for " + year 
                + ": $" + Math.round(average) + "\n" + getHorizontalLine();
    }
    
    /**
     * Returns the summary for each employee in array
     * 
     * @param employees
     * @param count - how many employees added to array
     * @return String - summary of employee array
     */
    private static String getSummary(Employee[] employees, int count) {
        String message = "";
        
        for (int i = 0; i < count; i++) {
            message += "\n" + employees[i].toString();
            message += "\nAnnual Salary: $";
            message += Math.round(employees[i].annualSalary()) + "\n";
        }
        
        return message;
    }
    
    /**
     * Returns line to separate sections
     * 
     * @return String
     */
    private static String getHorizontalLine() {
        return "- - - - - - - - - - - - - - - - -";
    }
    
    /**
     * Main method
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        // to get user input for which file to read
        Scanner scannerIn = new Scanner(System.in);
        
        // prompt user for which file to read
        System.out.println("Enter file name: ");
        // this is the file that we will read
        String fileName = scannerIn.nextLine().trim();
        
        try {
            Scanner fileIn = new Scanner(new File(fileName));          
            
            // read each line of the file and create employees
            while (fileIn.hasNext()) {
                // set up new employee object
                Employee employee;
                
                // store each piece of data to creat employees
                int year = fileIn.nextInt();
                String type = fileIn.next();
                String name = fileIn.next();
                double salary = fileIn.nextDouble();
                
                // check for more data in line and for which object
                if (type.equals("Executive")) {
                    double stockPrice = fileIn.nextDouble();
                    employee = new Executive(name, salary, stockPrice);
                } else if (type.equals("Salesman")) {
                    int annualSales = fileIn.nextInt();
                    employee = new Salesman(name, salary, annualSales);
                } else {
                    employee = new Employee(name, salary);
                }
                
                // add each object to correct array of employees
                if (year == YEAR1) {
                    // add employee to first employees array
                    employees1[employees1Count] = employee;
                    // move to next index for this array
                    employees1Count++;
                } else if (year == YEAR2) {
                    // add employee to first employees array
                    employees2[employees2Count] = employee;
                    // move to next index for this array
                    employees2Count++;
                }
            }
            
            // employees arrays are now ready
            // calculate average salaries for each year
            double average1 = calcAverageSalary(employees1, employees1Count);
            double average2 = calcAverageSalary(employees2, employees2Count);
            
            // output avg salary - year1
            System.out.println(getAverageSalary(YEAR1, average1));
            // output year1 employee summary
            System.out.println(getSummary(employees1, employees1Count));
            
            // output avg salary - year2
            System.out.println(getAverageSalary(YEAR2, average2));
            // output year2 employee summary
            System.out.println(getSummary(employees2, employees2Count));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Salary.class.getName()).log(Level.SEVERE, null, ex);
        } 

    } 
    
}
