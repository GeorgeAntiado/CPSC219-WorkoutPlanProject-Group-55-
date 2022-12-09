package application;

/**
 * Parent of CalorieCalculatorController.
 * @author CS219-user compSciSage
 */
public class UserInformation {
	
	private Double weight;
	private Double height;
	private int age;
	private String sex;
	private int calculatedCalories;
	
	
	/**
	 * Default constructor.
	 */
	UserInformation(){
		weight = 0.0;
		height = 0.0;
		age = 0;
		sex = "";
		calculatedCalories = 0;
	}
	
	
	/**
	 * Constructor used by CalorieCalculatorController (for setting to a default)
	 * @param uWeight
	 * @param uHeight
	 * @param uAge
	 * @param uSex
	 */
	UserInformation(Double uWeight, Double uHeight, int uAge, String uSex){
		weight = uWeight;
		height = uHeight;
		age = uAge;
		sex = uSex;
	}
	
	
	/**
	 * Constructor. Sets instance variables.
	 * Validates uAge, uHeight, and uWeight & throws InvalidNumberException if not.
	 * @param uWeight --> weight: Double
	 * @param uHeight --> height: Double
	 * @param uAge --> age: int
	 * @param uSex
	 * @throws InvalidNumberException
	 */
	UserInformation(String uWeight, String uHeight, String uAge, String uSex) throws InvalidNumberException{
		
		setSex(uSex); // No validation needed. Input is from a choice box.
		
		boolean validNumbers = true;
		
		// Validating uAge is an integer.
		for (char i : uAge.toCharArray()) {
	    	if (!Character.isDigit(i)) {
	    		validNumbers = false;
	    		throw new InvalidNumberException("Don't use " + i + " in your age. Make sure to enter an integer.");
	    	}
		}
		
		// Validating uWeight is a double.
		boolean checkForDecimal = false;
		for (char i : uWeight.toCharArray()) {
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
		
		// Validating uHeight is a double.
		checkForDecimal = false;
		for (char i : uHeight.toCharArray()) {
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
		
		// Setting instance variables.
		if (validNumbers == true) {
			setWeight(Double.parseDouble(uWeight));
			setHeight(Double.parseDouble(uHeight));
			setAge(Integer.parseInt(uAge));
			
			// Validating they are all positive numbers.
			if(getWeight() < 0 || getHeight() < 0 || getAge() < 0) {
				throw new InvalidNumberException("You entered a negative number. Please make sure all numbers are greater than 0.");
			}
		}
	}

	/**
	 * Copy constructor.
	 * @param toCopy
	 */
	UserInformation(UserInformation toCopy){
		age = toCopy.age;
		height = toCopy.height;
		weight = toCopy.weight;
		sex = toCopy.sex;
	}
	
	
	/**
	 * Calculates the BasalMetabolicRate based on sex, height, weight, and age.
	 * @return basalMetabolicRate: Double
	 */
	public Double calculateBMR() {
		double basalMetabolicRate = 0.0;
		
		if(getSex().equalsIgnoreCase("Male")) {
			basalMetabolicRate = (88.362 + (13.397 * weight) + (4.799 * height)) - (5.677 * age);
		} else if(getSex().equalsIgnoreCase("Female")) {
			basalMetabolicRate = (447.593 + (9.247 * weight) + (3.098 * height)) - (4.33 * age);
		}
		
		return basalMetabolicRate;
	}
	
	
	/**
	 * Calculates the number of calories the user should eat in a day.
	 * @param points
	 * @param weightGoals
	 * @return calculatedCalories: int
	 */
	public int calculateNumCalories(Double points, int weightGoals) {
		System.out.println("UserInformation: weight="+getWeight()+"; height="+getHeight()+"; age="+getAge()+"; sex="+getSex()+"; BMR="+calculateBMR()+"; points="+points+"; weightGoals="+weightGoals);
		
		Double numOfCaloriesDouble = calculateBMR() * points + weightGoals;
    	setCalculatedCalories(numOfCaloriesDouble.intValue());
    	
		return calculatedCalories;
	}
	
	
	/*
	 * SETTERS AND GETTERS (default)
	 */
	
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

	int getCalculatedCalories() {
		return calculatedCalories;
	}

	void setCalculatedCalories(int calculatedCalories) {
		this.calculatedCalories = calculatedCalories;
	}
	
	
	
	
}
