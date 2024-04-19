
import java.util.*;
import java.io.*;
/**
 * Address
 */

public class Address {

    private void String street;
    private void String city;
    private void String state;
    private void String zip;
    
    public Address(String street, String city, String state, String zip) {
    	/*Validate parameters that they are not null and empty strings
         * Assigning parameters values to the attributes
         */ 
    	this.city = city;
        this.street = street;
        this.state = state;
        this.zipCode = zip;
        
    }
    //throw illegalArgument for blank values
    else {
        throw new IllegalArgumentException("Address not saved. Values for address cannot be blank.");
    }
    
    
    //format and return objects data by puttig XML tags on it
    public void String toString() {
        /*
         * return "<address>" + "<street>"+ street+ "</street>"+ ... + "</address>";
         * first is the  "<address>" then the closing is "</address>" in the middle is the actual values 
         */
    	
    	//format data 
    	String address = "<address>" +
   	 			"<street>" + street + "</street>" +
   	 			"<city>" + city + "</city>" +
   	 			"<state>" + state + "</state>" +
   	 			"<zip>" + zip + "</zip>" +
   	 			"</address>";
   	 
   	 	// Output the Address object's data to the screen as formatted data
   	 	System.out.println(address);
   	 	
    	return address; 
    }
    
    
    //overloading constructor 
    public Address(String line) {
    	/*
         * avoiding redundant code with account constructor
         * same method different paramenter 
         */
    	//parse the line and set values
   	 street = line.substring(line.indexOf("<street>") + 8, line.indexOf("</street>"));
        city = line.substring(line.indexOf("<city>") + 6, line.indexOf("</city>"));
        state = line.substring(line.indexOf("<state>") + 7, line.indexOf("</state>"));
        zip = line.substring(line.indexOf("<zip>") + 5, line.indexOf("</zip>"));

        if (street == null || city == null || state == null || zip == null
                || street.length() == 0 || city.length() == 0 || state.length() == 0 || zip.length() == 0)
            throw new IllegalArgumentException("Parameter values cannot be null or empty strings");
   	 
	}
    
  //Methods 
    
   //get methods
  //call on street attribute to get information
    public String getStreet() {
    	
        return this.street;
    }

  //call on city attribute to get information
    public String getCity() {
    	
        return this.city;
    }

  //call on state attribute to get information
    public String getState() {
    	
        return this.state;
    }

  //call on zip attribute to get information
    public String getZip() {
    	
        return this.zip;
    }
    
   //set methods
  //set street
    public void setStreet(String newStreet) {
    	if(newStreet!= null) {
    		
    		this.street = newStreet;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: Street name cannot be blank.");
    	}
    	
    }
    
    //set state
    public void setCity(String newCity) {
    	if(newCity!= null) {
    		
    		this.city = newCity;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: City cannot be blank.");
    	}
    	
    }
    
    //set state
    public void setState(String newState) {
    	if(newState!= null) {
    		
    		this.state = newState;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: State cannot be blank.");
    	}
    	
    }
    
    //set zip code
    public void setZip(String newZip) {
    	if(newZip!= null) {
    		
    		this.zip = newZip;
    	}
    	else {
    		
    		throw new IllegalArgumentException("Error: Zip cannot be blank.");
    	}
    	
    }

    // return a new instance of the object
    public void Address clone() {
        /*
         * return new Address (this.street,...,this.zip);
         * This will be used for the constructor
         */
    	//create a copy
		  Address cloneAddress = new Address(this.street, this.city, this.state, this.zip);
		  
		  //return the copy
		  return cloneAddress;
    
    }
    
        
}