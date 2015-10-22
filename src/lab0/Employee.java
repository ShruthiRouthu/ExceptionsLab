package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    public static final int MIN_VACATION_DAYS = 0;
    
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    
    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setHireDate(hireDate);
        setDaysVacation(daysVacation);
    }
    
//SETTERS --------------
    
    /**
    * Sets vacation days for one employee
    * @param daysVacation - a value >= 0 but not more than 30
    * @
    */
    public final void setDaysVacation(int daysVacation) throws IllegalArgumentException{
        if(daysVacation < MIN_VACATION_DAYS || daysVacation > MAX_VACATION_DAYS){
            throw new IllegalArgumentException("Sorry vacation Days must be between 0 and 30 inclusive" );
        }  
        this.daysVacation = daysVacation;
    }

    
    /**
    * Sets the first name of a single employee
    * @param firstName optional but may not contain more than 100 characters
    */
    public final void setFirstName(String firstName) {
//        if(firstName == null || firstName.length() > 100){
//            throw new IllegalArgumentException("first name cannot be null "); 
//        }   
//        this.firstName = firstName;
      try{  
        int nameLength = firstName.length();
        char c = firstName.charAt(0);
        if(!Character.isUpperCase(c)){
            throw new IllegalArgumentException();  
        }
      }catch(NullPointerException npe) {
          throw new IllegalArgumentException();
      }catch(StringIndexOutOfBoundsException siobe) {
          throw new IllegalArgumentException();
      }
      this.firstName = firstName;
    }
    
    public void setHireDate(Date hireDate) {
        
        this.hireDate = hireDate;
    }
       
     public void setLastName(String lastName) {
        
        this.lastName = lastName;
    }
    
    // 333-33-3333
    // 333333333
    public void setSsn(String ssn) {
        if(ssn != null && ( ssn.length() == 9 || ssn.length() == 11)){
            String[] parts = ssn.split("-");
            if(parts.length != 3){
               throw new IllegalArgumentException(); 
            }
            char[] chars = ssn.toCharArray();
            for(char c:chars){
                if(!Character.isDigit(c)){
                   throw new IllegalArgumentException(); 
                }
            }
            this.ssn = ssn;
        }throw new IllegalArgumentException();
        
    }
    
//GETTERS ----------------
    public final int getDaysVacation() {
        return daysVacation;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final Date getHireDate() {
        return hireDate;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getSsn() {
        return ssn;
    }
    
    
// Unit Testing---------------
    public static void main(String[] args){
        Employee e = new Employee();
        e.setFirstName("");
       
       
    }  
            
            
    
}
