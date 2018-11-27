/**
 * File: Salesman.java
 * Author: Matthew Towles
 * Date: 10/29/2018
 * Purpose: Class for Salesman object which extends Employee
 */
package salary;

/**
 * Salesman - a subclass of Employee
 * Gets name and salary (monthly salary) from Employee
 * Also has annualSales
 * 
 * @author matthew.towles
 */
public class Salesman extends Employee {
    
    // sales in whole dollars made by salesman
    private double annualSales;
    
    // max commission a salesman can earn
    private static final int MAX_COMMISSION = 20000;
    
    // commission rate - to be factored with annualSales
    private static final double COMMISSION_RATE = 0.02;
    
    /**
     * Constructor - uses Employee constructor
     * @param name
     * @param salary 
     * @param annualSales 
     */
    public Salesman(String name, double salary, double annualSales) {
        // employee constructor
        super(name, salary);
        this.annualSales = annualSales;
    }
    
    /**
     * Returns the salary for a whole year
     * Base salary + commission
     * Calls parent method annualSalary and adds to commission
     * 
     * @return integer - salary in whole dollars
     */
    @Override
    public double annualSalary() {
        // call employee annualSalary and add to commission
        return (super.annualSalary() + this.getCommission());
    }
    
    /**
     * Returns commission based on annual sales
     * Commission = commission rate * annual sales
     * Commission cannot exceed max commission
     * 
     * @return integer - commission in whole dollars
     */
    public double getCommission() {
        // calculate commission
        double commission = COMMISSION_RATE * this.annualSales;
        // cannot exceed max commission
        if (commission > MAX_COMMISSION) {
            commission = MAX_COMMISSION;
        } 
        // make sure commission is not negative
        else if (commission < 0) {
            commission = 0;
        }
        return commission;
    }
      
    /** 
     * Returns a string representation of Salesman object
     * Contains: name, monthly salary, & annual sales
     * 
     * @return String
     */
    @Override
    public String toString() {
        // name and monthly salary
        String objectString = super.toString();
        // concat with annual sales
        objectString += "\nAnnual Sales: $" + Math.round(this.annualSales);
        return objectString;
    }
    
}
