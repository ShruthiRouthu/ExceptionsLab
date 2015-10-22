package lab2;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {
    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {
        String lastName = null;
        boolean runAgain = false;
        
        do{
            try{
                String fullName = JOptionPane.showInputDialog("Enter full name:");
                lastName = nameService.extractLastName(fullName);
                runAgain = false;
                
            }catch(IllegalArgumentException iae){
                runAgain = true;
                JOptionPane.showMessageDialog(null, iae.getMessage() );
                
            }
        }while(runAgain);
    
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
        
    }
     
}
