/**
 * File: Employee.java
 * Author: Matthew Towles
 * Date: 10/29/2018
 * Purpose: Class for Employee object. Used in Salary.java
 */
package salary;

/**
 * Employee - has name and monthly salary
 * 
 * @author matthew.towles
 */
public class Employee {
    
    // employee name 
    private String name;
    
    // monthly salary in whole dollars
    private double salary;
    
    /**
     * Constructor
     * @param name
     * @param salary 
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    /**
     * Get Employee salary for the whole year
     * @return integer
     */
    public double annualSalary() {
        return (this.salary * 12);
    }
    
    /**
     * Returns a string representation of Employee object
     * @return String
     */
    @Override
    public String toString() {
        String objectString = "Name: " + this.name;
        objectString += "\nMonthly Salary: $" + Math.round(this.salary);
        return objectString;
    }
    
    
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns monthly salary
     * @return integer
     */
    public double getSalary() {
        return this.salary;
    }
    
}
