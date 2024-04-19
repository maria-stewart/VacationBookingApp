
import java.util.*;
import java.io.*; 
/**
 * Account
 */

public class Account {

    /**
     * Default constructor
     */
  
    private String accountNumber;
    private String mailingAddress;
    private String emailAddresss;
    private String phoneNumber;
    private Reservation Reservation;

    //format and return object data by putting XML tags on it
    public void Account(String accountNumber, String mailingAddress, String emailAddress, String phonNumber, Reservation Reservation) {
        
    	 //check the values. If valid, set values. Else, throw exception.
        if(accountNumber!=null && mailingAddress != null && emailAddress != null && phoneNumber != null) {
    	
    	/*
         * validate parameters
         * assign parameters to attributes
         */
    	this.accountNumber = accountNumber +"-99";
    	this.mailingAddress = mailAddress;
    	this.emailAddress = emailAddress;
    	this.phoneNumber = phonNumber;
    	
    	  //create a blank list as new account has no reservations.
        this.reservations = new ArrayList<String>();
    	
    	//object to be sednt to toStrong method 
    	//this.toString(); 
   
        }
        
        //throw illegalargument for blank entry on account
        else {
            throw new IllegalArgumentException("Account not saved. Values for Account cannot be blank.");
        }
        
    }
    
    //create toString method for output of class data onto the screen and return formatted data 
    
    public String toString() {

      	//format data
      	 String account = "<account>" + 
      		"<accountNumber>" + accountNumber + "</accountNumber>" +
           "<mailingAdd>" + mailingAddress + "</mailingAddress>" +
           "<emailAddress>" + emailAddress + "</emailAddress>" +
           "<phoneNumber>" + phoneNumber + "</phoneNumber>" +
           "</account>";      	 	
      	
      	 
        // output the class data to the screen as formatted data
      	System.out.println(account); 

        //return the String
        return account;
  
    }
    
    
    //overloading constructor 
    //constructor will take a singled XML formatted string value 
    public Account(String line) {
        //avoiding redundant code with account constructor
    	
    	//acountNumber value
    	this.accountNumber = line.substring(line.indexOf("<accountNumber>") + 15, line.indexOf("</accountNumber>"));
    	
    	//mailing address value
    	
    		//extract the address as a string
    		String newMailingAddress = line.substring(line.indexOf("<mailingAddress>") + 16, line.indexOf("</mailingAddress>"));
    	
    		//convert to an Address object
    		Address newAddress = new Address(newMailingAddress); 
    	
    	//save the variable as an Address object
    	this.mailingAddress = newAddress;
    	 
    	 //email address value
    	this.emailAddress = line.substring(line.indexOf("<emailAddress>") + 14, line.indexOf("</emailAddress>"));
    	
    	//phone number value
    	this.phoneNumber = line.substring(line.indexOf("<phoneNumber>") + 13, line.indexOf("</phoneNumber>"));
    	
    	//create a new blank reservations list
    	 this.reservations = new ArrayList<String>();
    	

        if (accountNumber == null || mailingAddress == null || emailAddress == null || phoneNumber == null
                || accountNumber.length() == 0 || newMailingAddress.length() == 0 || emailAddress.length() == 0 || phoneNumber.length() == 0)
            throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
    }

    //Attributes

    //accountNumber is a unique number generated and provided by UI.
    private String accountNumber;

    //mailingAddress is the mailing address for the Account
    private Address mailingAddress;

    //emailAddress is the email address associated with the account
    private String emailAddress;

     //phoneNumber is the phone number associated with the account
    private String phoneNumber;

     //List<String> reservations is a list holding the reservation numbers of the reservations associated with an account.
    //private List<Reservation> reservations;
    private List<String> reservations;

    //methods
    
    //get methods
    
    public String getAccountNumber() {
    	
    	return this.accountNumber;
    }
    
    
    //call on unique number attribute to get information
    public String getAccountNumber() {
    	
        return this.accountNumber;
    }

  //call on mailing address attribute to get information
    public String getMailingAddress() {
    	
        return this.mailingAddress;
    }
    
  //call on email address attribute to get information
    public String getEmailAddress() {
    	
        return this.emailAddress;
    }
  //call on phone number attribute to get information
    public String getPhoneNumber() {
    	
        return this.phoneNumber;
    }
  //call on reservation attribute to get information
    public Reservation getReservation() {
    	
        return this.reservation;
    }
    
    //set methods 
    
    
    //use set to change the value after it is created to update the information per requirments documnet
    public void setMailingAddress(Address nedwMailingAddress) {
        /*
         * need to edit attribute at anytime to update the information
         * parameter is the value that it is going to change
         * no return type 
         */
    	try {
			this.mailingAddress = newMailingAddress;
	}catch(Exception e) {
			throw new IllegalStateException("Cannot change the mailing address");
	}
}
    

    public void setEmailAddress(String newEmail) {
    	//check the format of the email address
    	int end = newEmail.length();
    	int start = end - 4;
    	int atIndex = newEmail.indexOf('@');
    	Boolean at = newEmail.contains("@");
    	
    	String email = newEmail.substring(start, end);
    	
    	if(email.equals(".com") && at.equals(true) && atIndex < start) {
    	
    		this.emailAddress = newEmail;
    	}
    	else {
    		throw new IllegalArgumentException("Invalid email address");
    	}	 
    	    	
    }

    
    public void setPhoneNumber(String newPhoneNumber) {
    	//check if the phone number is long enough
    	if(newPhoneNumber.length() < 10) {
    		
    		throw new IllegalArgumentException("Invalid phone number");
    	}
    	else {
    		
    		this.phoneNumber = newPhoneNumber;
    	}
    }
    
    
   //update the Account data if changing from empty to not for the resevation list 
    public void updateAccountNumber() {
int index = this.accountNumber.indexOf("-99");
    	
    	if(index != 0) {
    		this.accountNumber = this.accountNumber.substring(0,index);
    	}
    }
    
  //create and return a clone of the object
    public Account clone() {
    	
    	//create a clone object
        	
    	String cloneString = this.toString();
    	Account cloneAccount  = new Account(cloneString);
    	
    	//return the clone object
    	return cloneAccount;
    	
    }

}