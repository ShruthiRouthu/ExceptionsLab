package lab1;

import javax.swing.JOptionPane;

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
    private static final int LAST_NAME_IDX = 1;
    private static final String JP_INPUT_MSG = "Enter full name (use Format: first last):";
    private static final String JP_OUTPUT_MSG = "Your last name is: " ;
    private static final String NULL_ERROR_MSG = "Data is invalid. Please try again !";
    private static final String ONE_WORD_ERROR_MSG = "Please enter  FIRST and LAST names !";
    
    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        String lastName;
        
        String fullName = JOptionPane.showInputDialog(JP_INPUT_MSG);
        try{
            lastName = app.extractLastName(fullName);
        }catch(IllegalArgumentException iae){
            
            String totalName = JOptionPane.showInputDialog(iae.getMessage() + "\n" + JP_INPUT_MSG);
            lastName = app.extractLastName(totalName);
            
        }
        
        String msg = JP_OUTPUT_MSG + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public final String extractLastName(final String fullName) {
        System.out.println(fullName);
        
        String lastName = "";
      
            // Validating null input
            if(fullName == null){ 
                throw new IllegalArgumentException(NULL_ERROR_MSG); 
            }
            String[] nameParts = fullName.split(" "); 
            
            // Validating no of words in string i.e  nameParts arrayLength has to be 2
            // Preventing user from skipping entering first name i.e first string in array cannot be a space
            if((nameParts.length != 2) || nameParts[0].equals("") ){
                throw new IllegalArgumentException(ONE_WORD_ERROR_MSG);
            }
            lastName = nameParts[nameParts.length - 1];
   
        return lastName ;
        
    }

}

/* System.out.println(nameParts.length);
            for(int i = 0; i< nameParts.length; i++){
                 System.out.println(nameParts[i]);
            }
    
    
 public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        
        String fullName = JOptionPane.showInputDialog("Enter full name (use Format: first last):");
        System.out.println(fullName);
        String lastName = app.extractLastName(fullName);
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public String extractLastName(String fullName) {
        String lastName = "";
        if((fullName != null) && (fullName.length() > 0)  ){
            String[] nameParts = fullName.split(" ");    
            lastName = nameParts[nameParts.length - 1];
        }
        
        
        
    }

*/

