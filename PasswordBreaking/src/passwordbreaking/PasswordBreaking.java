
package passwordbreaking;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public class PasswordBreaking {


	public static void main(String[] args) {
		File fp = new File("numbers.txt");
                
		
		Node1<String> nodes = null;
                Tree1<String> tree1 = null;
		String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};	 
		String password;
                boolean flag = true;
                String newWritten = "";
                Scanner scann = new Scanner(System.in);
                System.out.println("Please enter a password: ");
		String enteredPass = scann.next();
                
                
		try {
			Scanner scan = new Scanner(fp);   //read the file
		while(scan.hasNext()) {
		        password = scan.nextLine();
 
		    int[] pass = new int[password.length()];
                    int[] newPass = new int[enteredPass.length()];
	 
		    if(numericTest(password) && lenghtTest(password) ) {  //checking whether the password is digit and smaller than 20 lenght
		    	String[] newPas = enteredPass.split("");
		    	String [] passs  = password.split("");
			try {
				for(int j = 0; j < passs.length; j++) {
				pass[j] = Integer.parseInt(passs[j]);
	             }
                                for(int k = 0; k < newPas.length; k++){
                                 newPass[k] = Integer.parseInt(newPas[k]);
                                }
			}catch(NumberFormatException n) {
				System.out.println("You did not enter password!!");
			}
			}
		   	    
		   String passwordByWritten = "";
                   newWritten = "";
		    
		    for(int i = 0; i < pass.length; i++ ) {
		    	passwordByWritten += digits[pass[i]];
		    }
                    for(int i = 0; i < newPass.length; i ++){
                        newWritten += digits[newPass[i]];
                    }
              
		    if(!letterTest(passwordByWritten)) { //checking 3rd case (vowel-consonants)
		    	//System.out.println(passwordByWritten);
                         nodes = new Node1<String>(passwordByWritten);    
                         
                         tree1 = new Tree1<String>(nodes);
                         List<Node1<String>> childs = nodes.getChildren();
                         
                             nodes.addChild(new Node1<String> (passwordByWritten));
                            // current = nodes;

                        //System.out.println(nodes.getData() + "*******");
                    
                        while(tree1.exists(newWritten)){
                            System.out.println("Invalid password: "+enteredPass + ": "+nodes.getData());
                            flag = false;
                            break;
                           
                        } 
		    }
                    }
                 
                    if(flag == true ){
                       System.out.println("Password is valid"); 
                    }
                    
                
                   
		}catch(FileNotFoundException f) {
			f.printStackTrace();
		}
                
                
	    }	    
        
  
          public static boolean letterTest(String passwordByWritten){
          //ArrayList<AbstractMap.SimpleEntry<String,Integer>> listOfPair = new ArrayList<>();
          //AbstractMap.SimpleEntry<String,Integer> apm;
            int total;
	    String passChars[];
	    String newString = "";
	    for(int k = 0; k < passwordByWritten.length(); k++) {
	    	total = 0;
	    	newString = passwordByWritten.substring(0, k+1);   //looks at the substrings in order from the beginning.
	    	//System.out.println(newString);
	    	for(int l = 0; l < newString.length(); l ++) {
	    		
	        passChars = newString.split("");
	    	if(passChars[l].matches("a|e|i|o|u")) { 
	    		
	    		total++; 
	    		//listOfPair.add(apm = new AbstractMap.SimpleEntry<>(passChars[k],1));
	    		
	    		
	    	}else {
	    		total--;
	    		//listOfPair.add(apm = new AbstractMap.SimpleEntry<>(passChars[k],-1));
	    	} //By increasing or decreasing the total, it is checked whether each substring meets the 3rd condition.
	    	}
	    	if(total > 0) { //that means more vowels.
	    	//System.out.println("Number of vowels can not be more than number of consonant!! Invalid");
            return false; //stop the loop
	    
	    	}
	    }
	    return true;

          }
          
          public static boolean lenghtTest(String password){ //character length test
              int numberOfCharacters = password.length();
              
              if(numberOfCharacters <= 0 && numberOfCharacters > 20){
                  System.out.println("Password lenght must be in range 0-20!! Invalid");
                  return false;
              }
              else{
                  return true;
              }
              
          }
          
          
         public static boolean numericTest(String password){ //the passport contain only numbers or not test
             
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

