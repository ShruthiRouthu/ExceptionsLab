package lab1;

import javax.swing.JOptionPane;
import lab3.InvalidNameException;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again. (Yes, this violates 
 * the Single Responsibility Principle, but for this lab, we'll overlook that.)
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    private static final String JP_INPUT_MSG = "Enter full name (use Format: first last):";
    private static final String JP_OUTPUT_MSG = "Your last name is: " ;
    private static final String NULL_ERROR_MSG = "Data is invalid. Name cannot be null !";
    private static final String ONE_WORD_ERROR_MSG = " Name is incomplete. \n Please enter both first name and last name ";
    private static final String EMPTY_FIRST_NAME = "LastName has not been entered. \n Please enter both first name and last name ";
    
    
    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        boolean runAgain = false;
        String lastName = null;
        
        do{
            try{
                String fullName = JOptionPane.showInputDialog(JP_INPUT_MSG);
                lastName = app.extractLastName(fullName);
                runAgain = false;
                
            }catch(IllegalArgumentException iae){
                runAgain = true;
                JOptionPane.showMessageDialog(null, iae.getMessage() ); 
                
            }
        }while(runAgain);
         
        String msg = JP_OUTPUT_MSG + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
    
    public final String extractLastName(final String fullName) throws IllegalArgumentException {
      //  System.out.println(fullName);
        
        String lastName = "";
      
            // Validating null input
            if(fullName == null){ 
                throw new IllegalArgumentException(NULL_ERROR_MSG); 
            }
            String[] nameParts = fullName.split(" "); 
            
            // Validating no of words in string i.e  nameParts arrayLength has to be 2
            if((nameParts.length < 2)){
                throw new IllegalArgumentException (ONE_WORD_ERROR_MSG);
            }
            // Preventing user from skipping entering only one name by using space i.e first string in array cannot be a space
            else if( nameParts[FIRST_NAME_IDX].equals("") ){
                throw new IllegalArgumentException(EMPTY_FIRST_NAME);
            }
            
            lastName = nameParts[nameParts.length - 1];
   
        return lastName ;
        
    }

}



