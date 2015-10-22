package lab2;

import lab3.InvalidNameException;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    
    private static final String NULL_ERROR_MSG = "Data is invalid. Name cannot be null !";
    private static final String ONE_WORD_ERROR_MSG = " Name is incomplete. \n Please enter both first name and last name ";
    private static final String EMPTY_FIRST_NAME = "LastName has not been entered. \n Please enter both first name and last name ";
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) throws IllegalArgumentException{
        
        if(fullName == null){ 
            throw new IllegalArgumentException(NULL_ERROR_MSG); 
        }
        String[] nameParts = fullName.split(" ");
        
        // Validating no of words in string i.e  nameParts arrayLength has to be 2
        if((nameParts.length < 2)){
            throw new IllegalArgumentException (ONE_WORD_ERROR_MSG);
        }
        // Preventing user from skipping entering first name i.e first string in array cannot be a space
        else if( nameParts[FIRST_NAME_IDX].equals("") ){
            throw new IllegalArgumentException(EMPTY_FIRST_NAME);
        }
       
        return nameParts[nameParts.length - 1];
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName)throws IllegalArgumentException {
        if(fullName == null){ 
            throw new IllegalArgumentException(NULL_ERROR_MSG); 
        }
        String[] nameParts = fullName.split(" ");
        
        // Validating no of words in string i.e  nameParts arrayLength has to be 2
        if((nameParts.length < 2)){
            throw new IllegalArgumentException (ONE_WORD_ERROR_MSG);
        }
        // Preventing user from skipping entering first name i.e first string in array cannot be a space
        else if( nameParts[FIRST_NAME_IDX].equals("") ){
            throw new IllegalArgumentException(EMPTY_FIRST_NAME);
        }
       
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        return name.length();
    }
    
}
