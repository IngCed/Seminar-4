
package se.kth.iv1350.processsale.integration;

/**
 * An exception class that is thrown when an invalid identifier has been specified.
 * Extends the java.lang.exception class.
 */
public class ItemIdentifierInvalidException extends Exception{
    /**
     * The constructor receives information about the invalidIdentifier and informs
     * the user that the identifier does not exist.
     * @param message the error message to the user. 
     */
    public ItemIdentifierInvalidException(String message){
        super(message);
    }
}
