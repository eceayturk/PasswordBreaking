package passwordbreaking;


import java.util.List;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public class PasswordBreaking {


	public static void main(String[] args) {
		
	    String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};	 
            String password = "423";
	    int[] pass = new int[password.length()];
		
	   
	    if(numericTest(password) && lenghtTest(password) ) {
	    	
	    	String [] passs  = password.split("");
		try {
			for(int j = 0; j < passs.length; j++) {
			pass[j] = Integer.parseInt(passs[j]);
             }
		}catch(NumberFormatException n) {
			System.out.println("You did not enter password!!");
		}
	    

	    String passwordByWritten = "";
	    
	    for(int i = 0; i < pass.length; i++ ) {
	    	passwordByWritten += digits[pass[i]];
	    }
	    if(letterTest(passwordByWritten)) {
	    	System.out.println(passwordByWritten);
	    }
		    
            
	    }
	    
       
        }
  
          public static boolean letterTest(String passwordByWritten){
          ArrayList<AbstractMap.SimpleEntry<String,Integer>> listOfPair = new ArrayList<>();
          AbstractMap.SimpleEntry<String,Integer> apm;
        int total = 0;
	    String passChars[];
	    String newString = "";
	    for(int k = 0; k < passwordByWritten.length(); k++) {
	    	newString = passwordByWritten.substring(0, k);
	    	for(int l = 0; l < newString.length(); l ++) {
	    		passChars = newString.split("");
	    	if(passChars[l].matches("a|e|i|o|u")) {
	    		
	    		total++;
	    		//listOfPair.add(apm = new AbstractMap.SimpleEntry<>(passChars[k],1));
	    		
	    		
	    	}else {
	    		total--;
	    		//listOfPair.add(apm = new AbstractMap.SimpleEntry<>(passChars[k],-1));
	    	}
	    	
	    	}
	    	total = 0;
	    	if(total > 0) {
	    	System.out.println("Number of vowels can not be more than number of consonant!! Invalid");
	    	return false;
	    	
	    	
	    }else {
	    	return true;
	    	//System.out.println(listOfPair.get(k).getValue() +"  ");
	    }
	    	
	    			
	    }
             
	  return true;
	    
          }
          
          public static boolean lenghtTest(String password){
              int numberOfCharacters = password.length();
              
              if(numberOfCharacters <= 0 && numberOfCharacters > 20){
                  System.out.println("Password lenght must be in range 0-20!! Invalid");
                  return false;
              }
              else{
                  return true;
              }
              
          }
          
          
         public static boolean numericTest(String password){
             
             boolean isValid = true;
             for (int i = 0; i < password.length(); i++) {
             if (!Character.isDigit(password.charAt(i))) {
             isValid = false;
             break;
             }
             }

             if (isValid) {
                 return true;
             } 
             else {
             System.out.println("Password must have just numeric values!! Invalid");
             return false;

}
         }
 
	}

