package application;

public class BasalMetabolicRate {
	Double weight;
	Double height;
	int age;
	String sex;
	
	BasalMetabolicRate(Double uWeight, Double uHeight, int uAge, String uSex) {
		sex = uSex;
		weight = uWeight;
		height = uHeight;
		age = uAge;
	}
	
	BasalMetabolicRate(String uWeight, String uHeight, String uAge, String uSex) throws InvalidNumberException{
		sex = uSex; // no need to validate because it is a choice box
		
		
		boolean validNumbers = true;
		
		// validates that uAge is an integer
		for (char i : uAge.toCharArray()) {
    		// Check if character is a digit. 
    		if (!Character.isDigit(i)) {
    			// Check if character is a decimal.
    			if (i == '.') {
    				validNumbers = false;
    				throw new InvalidNumberException("Don't use decimals in your age.");
    			} else {
    				validNumbers = false;
    				throw new InvalidNumberException("Don't use " + i + " in your age. Make sure to enter a number.");
    			}
    		}	
		}
		
		
		boolean checkForDecimal = false;
		for (char i : uWeight.toCharArray()) {
    		// Check if character is a digit. 
    		if (!Character.isDigit(i)) {
    			// Check if character is a decimal.
    			if (i == '.') {
    				// Check if there's already a decimal, output an error if so. If there isn't, know that there is one decimal now.
    				if (checkForDecimal) {
    					validNumbers = false;
    					throw new InvalidNumberException("Don't use more than one " + i + " in your weight");
    				} else {
    					checkForDecimal = true;
    				}
    			} else {
    				validNumbers = false;
    				throw new InvalidNumberException("Don't use " + i + " in your weight. Make sure to enter a number.");
    			}
    		}	
		}
		
		
		checkForDecimal = false;
		for (char i : uHeight.toCharArray()) {
    		// Check if character is a digit. 
    		if (!Character.isDigit(i)) {
    			// Check if character is a decimal.
    			if (i == '.') {
    				// Check if there's already a decimal, output an error if so. If there isn't, know that there is one decimal now.
    				if (checkForDecimal) {
    					validNumbers = false;
    					throw new InvalidNumberException("Don't use more than one " + i + " in your height.");
    				} else {
    					checkForDecimal = true;
    				}
    			} else {
    				validNumbers = false;
    				throw new InvalidNumberException("Don't use " + i + " in your height. Make sure to enter a number.");
    			}
    		}	
		}
		
		if (validNumbers) {
		weight = Double.parseDouble(uWeight);
		height = Double.parseDouble(uHeight);
		age = Integer.parseInt(uAge);
		}
		
		if(weight < 0 || height < 0 || age < 0) {
			throw new InvalidNumberException("You entered a negative number. Please make sure all numbers are greater than 0.");
		}
		
	}
	
}
