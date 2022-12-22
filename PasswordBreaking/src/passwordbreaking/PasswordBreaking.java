package passwordbreaking;

//import javafx.util.Pair;
import java.util.List;




import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public class PasswordBreaking {


	public static void main(String[] args) {
		ArrayList<AbstractMap.SimpleEntry<String,Integer>> listOfPair = new ArrayList<>();
		AbstractMap.SimpleEntry<String,Integer> apm;
		
		
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

}
