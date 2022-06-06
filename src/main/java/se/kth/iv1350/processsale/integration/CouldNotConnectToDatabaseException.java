
package se.kth.iv1350.processsale.integration;

/**
 * An exception class that is thrown when the program can't access the ExternalInventorySystem.
 * Extends the java.lang.exception class.
 */
public class CouldNotConnectToDatabaseException extends RuntimeException{
    /**
     * Constructor that receives the simple error message to be sent to the user and the logged
     * detailed message to be sent to the developer. 
     * @param message the error message to the user.
     */
    public CouldNotConnectToDatabaseException(String message){
                super(message);
                 System.out.println("\n         -------------LOG-------------\n" + message 
       + "\n<Detailed information to the developer here>\nDATE: " + java.time.LocalDateTime.now() + "\n        -----------END OF LOG-----------\n");
    }
}
