package application;

public class BasalMetabolicRate {
	private Double weight;
	private Double height;
	private int age;
	private String sex;
	
	BasalMetabolicRate(Double uWeight, Double uHeight, int uAge, String uSex) {
		setSex(uSex);
		setWeight(uWeight);
		setHeight(uHeight);
		setAge(uAge);
	}
	
	BasalMetabolicRate(String uWeight, String uHeight, String uAge, String uSex) throws InvalidNumberException{
		setSex(uSex);
		
		boolean validNumbers = true;
		
		
		// validates that uAge is an integer
		for (char i : uAge.toCharArray()) {
	    	// Check if character is a digit. 
	    	if (!Character.isDigit(i)) {
	    		validNumbers = false;
	    		throw new InvalidNumberException("Don't use " + i + " in your age. Make sure to enter an integer.");
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
		
		if (validNumbers == true) {
			setWeight(Double.parseDouble(uWeight));
			setHeight(Double.parseDouble(uHeight));
			setAge(Integer.parseInt(uAge));
			
			if(getWeight() < 0 || getHeight() < 0 || getAge() < 0) {
				throw new InvalidNumberException("You entered a negative number. Please make sure all numbers are greater than 0.");
			}
		}
	}

	
	public Double calculateBMR() {
		double basalMetabolicRate = 0.0;
		
		if(getSex().equalsIgnoreCase("Male")) {
			basalMetabolicRate = (88.362 + (13.397 * weight) + (4.799 * height)) - (5.677 * age);
		} else if(getSex().equalsIgnoreCase("Female")) {
			basalMetabolicRate = (447.593 + (9.247 * weight) + (3.098 * height)) - (4.33 * age);
		}
		
		return basalMetabolicRate;
	}
	
	
	//GETTERS AND SETTERS
	
	Double getWeight() {
		return weight;
	}

	void setWeight(Double weight) {
		this.weight = weight;
	}

	Double getHeight() {
		return height;
	}

	void setHeight(Double height) {
		this.height = height;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getSex() {
		return sex;
	}

	void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
}
