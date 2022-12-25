package passwordbreaking;


import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public class PasswordBreaking {


	public static void main(String[] args) {
		
	    String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};	 
            String password = "0123";
	    int[] pass = new int[password.length()];
		
	    String [] passs  = password.split("");
		
	    for(int j = 0; j < passs.length; j++) {
			pass[j] = Integer.parseInt(passs[j]);
             }

	    String passwordByWritten = "";
	    
	    for(int i = 0; i < pass.length; i++ ) {
	    	passwordByWritten += digits[pass[i]];
	    }
		
            System.out.println(passwordByWritten);
       
        }
  
          public static void letterTest(String passwordByWritten){
          ArrayList<AbstractMap.SimpleEntry<String,Integer>> listOfPair = new ArrayList<>();
          AbstractMap.SimpleEntry<String,Integer> apm;
        
	    String passChars[];
	    for(int k = 0; k < passwordByWritten.length(); k++) {
	    	passChars = passwordByWritten.split("");
	    	
	    	if(passChars[k].matches("a|e|i|o|u")) {
	    		listOfPair.add(apm = new AbstractMap.SimpleEntry<>(passChars[k],1));
	    		
	    		
	    	}else {
	    		listOfPair.add(apm = new AbstractMap.SimpleEntry<>(passChars[k],-1));
	    	}
	    	System.out.println(listOfPair.get(k).getValue() +"  ");
	    }   
          }
          
          public static void lenghtTest(String password){
              int numberOfCharacters = password.length();
              
              if(numberOfCharacters > 20){
                  System.out.println("This password is invalid");
              }
              else{
                  System.out.println("This password is valid");
              }
              
          }
          
          
         public static void numericTest(String password){
             
             boolean isValid = true;
             for (int i = 0; i < password.length(); i++) {
             if (!Character.isDigit(password.charAt(i))) {
             isValid = false;
             break;
             }
             }

             if (isValid) {
                 System.out.println("This password is valid");
             } 
             else {
             System.out.println("This password is invalid");

}
         }
 
	}


