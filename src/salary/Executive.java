/**
 * File: Executive.java
 * Author: Matthew Towles
 * Date: 10/29/2018
 * Purpose: Class for Executive object which extends Employee
 */
package salary;

/**
 * Executive - a subclass of Employee
 * Gets name and salary from Employee
 * Also has 
 * @author matthew.towles
 */
public class Executive extends Employee {
    
    // current stock price in dollars
    private double stockPrice;
    
    // stock price in dollars to exceed for bonus
    private static final int STOCK_PRICE_GOAL = 50;
    
    // bonus awarded if stock price exceeds stock price goal
    private static final int BONUS = 30000;
    
    /**
     * Constructor - calls Employee constructor
     * @param name
     * @param salary
     * @param stockPrice 
     */
    public Executive(String name, double salary, double stockPrice) {
        // employee constructor
        super(name, salary);
        this.stockPrice = stockPrice;
    }
    
    /**
     * Returns salary for whole year
     * Base salary + bonus
     * Base salary from employee class
     * Bonus applied if stock price > stock price goal
     * 
     * @return integer - salary in whole dollars 
     */
    @Override
    public double annualSalary() {
        // set to employee annualSalary
        double salary = super.annualSalary();
        // add bonus to salary if stockPrice exceeds goal
        if (this.stockPrice > STOCK_PRICE_GOAL) {
            salary += BONUS;
        }
        return salary;
    }
    
    /**
     * Returns a string representation of Executive object
     * Contains: name, monthly salary, & stock price
     * 
     * @return String
     */
    @Override
    public String toString() {
        // name and monthly salary
        String objectString = super.toString();
        // concat with stock price
        objectString += "\nStock Price: $" + Math.round(this.stockPrice);
        return objectString;
    }
    
}
