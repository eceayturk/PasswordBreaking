
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
                
	
		String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; //necessary digit written format.
		String password; //for testing, all possible 0-5 digit passwords  
                int[] newPass; //for user password.
                String[] newPas ={} ;
                boolean flag = true;
                String newWritten = ""; //user password's written format.
                Scanner scann = new Scanner(System.in);
                System.out.println("Please enter a password: ");
		String enteredPass = scann.next();
                System.out.println("\nAdding, scanning and breaking operations may take some time.\nPLEASE WAIT UNTIL THE RESULTS APPEAR!\n");
                
                
		try {
			Scanner scan = new Scanner(fp);   //read the file
		while(scan.hasNext()) {
		        password = scan.nextLine(); 
 
		    int[] pass = new int[password.length()]; // for each password digit locate cell.(for passwords in txt)
                   newPass = new int[enteredPass.length()]; //for each user's password digit locate cell.
	 
		    if(numericTest(password) && lenghtTest(password) ) {  //checking whether the password is digit and smaller than 20 lenght
		    	newPas = enteredPass.split(""); //for example 1234 --> split version [1] [2] [3] [4] ---> user's password
		    	String [] passs  = password.split(""); //--> txt password.
			
				for(int j = 0; j < passs.length; j++) {
				pass[j] = Integer.parseInt(passs[j]); //parsing string values to int for txt passwords.
	             }
                   
			}
                try{
		   for(int k = 0; k < newPas.length; k++){
                   newPass[k] = Integer.parseInt(newPas[k]); //parsing string values to int for user's password.
                   }
                }catch(NumberFormatException e){ //to handle with with passwords containing letters or characters.
                    break;
                }
		   String passwordByWritten = ""; //written format of txt password.
                   newWritten = ""; //written format of user's password.
		    
		    for(int i = 0; i < pass.length; i++ ) {
		    	passwordByWritten += digits[pass[i]]; //adding "text value for digits" into written format.
                        // like, digits[0] = "zero"
		    }
                    for(int i = 0; i < newPass.length; i ++){
                        newWritten += digits[newPass[i]]; // same with txt passwords for user's password.
                    }
                    flag = addTree(passwordByWritten,newWritten,enteredPass,flag); //keeping flag change while adding values to tree.
                  
                    
                }
                    if(flag == true ){
                       if(letterTest(newWritten)){
                           if(numericTest(enteredPass)){
                               if(lenghtTest(enteredPass)){

                                System.out.println("Valid Password");
                                String breakedPas = "";
                                
                                for(int i = 0; i< newPas.length; i++){
                                    for(int j = 0; j< 10; j++){
                                       if(Integer.parseInt(newPas[i]) == j){
                                           breakedPas += j+"";
                                       }
                                    }
                                }
                                System.out.println("Password is broken!!! And your password is: " + breakedPas);
                               }else{
                                   return;
                               }
                           }else{
                              return;
                           }
                            }
                            else{
                                if(numericTest(enteredPass)){
                                    if(lenghtTest(enteredPass)){
                                   System.out.println("Invalid but not exist in m-ary trie!! NOW IS ADDED: ");
                                   
                                   addTree(newWritten,newWritten,enteredPass, flag); 
                                   
                                } 
                                }
                       }                      
               }
		}catch(FileNotFoundException f) {
			f.printStackTrace();
		}   
	    }	    
        
          public static boolean addTree(String passwordByWritten,String newWritten,String enteredPass, boolean flag){
             //this method includes tree implementations and with the operations it changes to flag value. 
              if(!letterTest(passwordByWritten)) { 
                         Node1<String> nodes = new Node1<String>(passwordByWritten); //create a node with passwordByWritten.
                         
                         Tree1<String> tree1 = new Tree1<String>(nodes); // create tree with node.
                         //List<Node1<String>> childs = nodes.getChildren();
                          while(tree1.exists(newWritten)){ //if syntax found in trie, than that means password invalid. 
                              //so it takes invalid value from tree and writes an invalid massage.
                            System.out.println("Invalid password!!: "+ enteredPass+
                                     "\nYour password is in m-ary trie --> "+ ": "+nodes.getData());
                            
                            flag = false; //turn of flag as false.
                            break;
                           
                        }
                        nodes.addChild(new Node1<String> (passwordByWritten));      
                      //  System.out.println(nodes.getData());  
		    }
              return flag;
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
              
              if(numberOfCharacters > 20){
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
