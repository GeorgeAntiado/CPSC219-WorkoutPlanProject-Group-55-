package application;

public class exercise {
	
	//attributes
	private String exerciseType;
	private int exerciseLength;
	private String intensity;
	int caloriesBurnt = 0;
		
	public exercise(String typeOfExercise, String intensityOfExercise, String lengthOfExercise) throws InvalidNumberException {
		setExerciseType(typeOfExercise);
		setIntensity(intensityOfExercise);
		
		// validates that lengthOfExercise is an integer
		for (char i : lengthOfExercise.toCharArray()) {
			   // Check if character is a digit. 
			   if (!Character.isDigit(i)) {
			    throw new InvalidNumberException("Don't use " + i + " in your age. Make sure to enter an integer.");
			   }
		}
				
		setExerciseLength(Integer.parseInt(lengthOfExercise));
		if(getExerciseLength()<0) {
			throw new InvalidNumberException("You entered a negative number. Please make sure all numbers are greater than 0.");
		} else if (getExerciseLength() == 0) {
			throw new InvalidNumberException("Please do not enter zero");
		}
	}
	
	
	
	int getcaloriesBurnt() {
		if (getExerciseType() == "cardio") {
			if (getIntensity() == "light") {
				caloriesBurnt = getExerciseLength() * 4;
			}
			else if (getIntensity()=="medium") {
				caloriesBurnt = getExerciseLength() * 12;
			}
			else if (getIntensity() == "hard") {
				caloriesBurnt = getExerciseLength() * 30;
			}	
		}
		else if (getExerciseType() == "WeightLifitng") {
			if (getIntensity() == "light") {
				caloriesBurnt = getExerciseLength() * 3;
			}
			else if(getIntensity() == "medium") {
				caloriesBurnt = getExerciseLength() * 5;
			}
			else if (getIntensity() =="hard") {
				caloriesBurnt = getExerciseLength() * 10;
			}
		}
		else if (getExerciseType() =="Sports") {
			if (getIntensity() == "light") {
				caloriesBurnt = getExerciseLength() * 5;
			}
			else if(getIntensity() == "medium") {
				caloriesBurnt = getExerciseLength() * 9;
			}
			else if (getIntensity() =="hard") {
				caloriesBurnt = getExerciseLength() * 13;
			}
		}
		return caloriesBurnt;
	}
	String getExerciseType() {
		return exerciseType;
	}
	void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	int getExerciseLength() {
		return exerciseLength;
	}
	void setExerciseLength(int exerciseLength) {
		this.exerciseLength = exerciseLength;
	}
	String getIntensity() {
		return intensity;
	}
	void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	

}
