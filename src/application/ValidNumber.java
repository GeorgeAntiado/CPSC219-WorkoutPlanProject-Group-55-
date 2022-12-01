package application;


/**
 * Validates user input for calories.
 * @author CS219-user Sage
 *
 */
public class ValidNumber {
	
	int integer;
	double decimal;
	
	ValidNumber(int intNumber, double doubleNumber) {
		integer = intNumber;
		decimal = doubleNumber;
	}
	
	/**
	 * Validates user input in the form of a string.
	 * Throws exception if the number is an invalid double.
	 * @param num
	 */
	public void validDouble(String num) throws InvalidNumberException {
		// should it return an error message instead????
		
		boolean validNum = true;
		boolean checkForDecimal = false;
		for (char i : num.toCharArray()) {
    		// Check if character is a digit. 
    		if (!Character.isDigit(i)) {
    			// Check if character is a decimal.
    			if (i == '.') {
    				// Check if there's already a decimal, output an error if so. If there isn't, know that there is one decimal now.
    				if (checkForDecimal) {
    					validNum = false;
    					throw new InvalidNumberException("Don't use more than one " + i + " in your input");
    				} else {
    					checkForDecimal = true;
    				}
    			} else {
    				validNum = false;
    				throw new InvalidNumberException("Don't use " + i + " in your input. Make sure to enter a number.");
    			}
    		}	
		}
		
	
	}
	
	
	/**
	 * Validates user input in the form of a string.
	 * Throws exception if the number is an invalid integer.
	 * @param num
	 */
	public void validInteger(String num) throws InvalidNumberException {
		
		for (char i : num.toCharArray()) {
    		// Check if character is a digit. 
    		if (!Character.isDigit(i)) {
    			// Check if character is a decimal.
    			if (i == '.') {
    				throw new InvalidNumberException("Don't use decimals in your input.");
    			} else {
    				throw new InvalidNumberException("Don't use " + i + " in your input. Make sure to enter a number.");
    			}
    		}	
		}
	
	
	}
	
}
