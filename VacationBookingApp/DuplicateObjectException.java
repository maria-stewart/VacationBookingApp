
import java.util.*;

/**
 * throw unchecked user defined exception for trying to create a duplicate account 
 */
public class DuplicateObjectException extends RuntimeException {
 
       private String message;
	//exception message should indicate the number of the account and/or reservation number and why it failed.
		DuplicateObjectException(){
		//default
		}
		
		DuplicateObjectException(String fileName){
			
			super();
			
			//a string to check the type of file
 			String typeTest = fileName.substring(0,3);
 			String number = fileName.substring(3,fileName.length());
 		 			
			if(typeTest.equals("acc")) {
				this.message = "Duplicate account number " + number + ". System failed to duplicate this account";
			}
			else if(typeTest.equals("res")) {
				this.message = "Duplicate reservation number " + number + ". Systedn failed to duplicate this reservation";
			}
			else {
				this.message = "System failed to duplicate address file "+ number + ".";
			}		
			
		}
		
		public String toString() {
			
			return message;
		}

}