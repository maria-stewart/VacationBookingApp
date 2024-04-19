
import java.util.*;

/**
 * 
 */
public class IllegalOperationException extends RuntimeException {

    private String message;
	
	IllegalOperationException(){
		
		}

        IllegalOperationException(String fileName, String operation) {
        /*
         * call super passing message: "The operation cancelling the reservation" + cancelReservation + "was violated for" + account id + reservation number + "due to start date"
         * call super passing message: "The operation cancelling the reservation" + cancelReservation + "was violated for" + account id + reservation number + "due to reservation being completed"
         * call super passing message: "The operation completeing the reservation" + completeReservation + was violated for" + account id + reservation number "due to not being associated with the correct account"
         * assing parameters to attributes      
         */
        super();
			
			//res number
 			//String number = filename.substring(3,filename.length());
 			
 			//account number
 			//String account = filename.substring(0)
 		 			
			if(operation.equals("cancel")) {
				this.message = "Failed to cancel reservation " + fileName + ".";
			}
			else if(operation.equals("complete")) {
				this.message = "Failed to complete reservation " + fileName + ".";
			}
			else {
				this.message = "Failed to duplicate file " + fileName + ".";
			}		
        }
        IllegalOperationException(String fileName, String operation, String reason){
		
		super();
		 			
		if(operation.equals("cancel")) {
			this.message = "Failed to cancel reservation " + fileName + " because " + reason + ".";
		}
		else if(operation.equals("complete")) {
			this.message = "Failed to complete reservation " + fileName + " because " + reason + ".";
		}
		else {
			this.message = "Failed to "+ operation + " file "+ fileName + " because " + reason + ".";
		}		
		
	    }
    

    
    public String toString() {
        /*
         * generate and return a meaningful message this.getClass() this.getAttribute() :"The operation cancelling the reservation" + cancelReservation + "was violated for" + account id + reservation number + "due to start date"
         * generate and return a meaningful message this.getClass() this.getAttribute() :"The operation cancelling the reservation" + cancelReservation + "was violated for" + account id + reservation number + "due to reservation being completed"
         * generate and return a meaningful message this.getClass() this.getAttribute() :"The operation completeing the reservation" + completeReservation + was violated for" + account id + reservation number "due to not being associated with the correct account"
         */
        return message;
    }

 
}