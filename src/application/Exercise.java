package application;

/**
 * Used by doWorkouts() in EatingPlanController.
 * @author CS219-user
 */
public class Exercise {

	private String exerciseType;
	private int exerciseLength;
	private String intensity;
	int caloriesBurnt = 0;
		
	
	/**
	 * Constructor. Sets the instance variables.
	 * Validates lengthOfExercise & throws InvalidNumberException if not.
	 * @param typeOfExercise
	 * @param intensityOfExercise
	 * @param lengthOfExercise --> exerciseLength: int
	 * @throws InvalidNumberException
	 */
	public Exercise(String typeOfExercise, String intensityOfExercise, String lengthOfExercise) throws InvalidNumberException {
		
		setExerciseType(typeOfExercise);
		setIntensity(intensityOfExercise);
		
		// Validates that lengthOfExercise is an integer
		for (char i : lengthOfExercise.toCharArray()) {
			   if (!Character.isDigit(i)) {
			    throw new InvalidNumberException("Don't use " + i + " in your age. Make sure to enter an integer.");
			   }
		}
				
		setExerciseLength(Integer.parseInt(lengthOfExercise));
		
		// Validates that exerciseLength is positive.
		if(getExerciseLength()<0) {
			throw new InvalidNumberException("You entered a negative number. Please make sure all numbers are greater than 0.");
		} else if (getExerciseLength() == 0) {
			throw new InvalidNumberException("Please do not enter zero");
		}
		
	}
	
	
	/**
	 * Calculates the number of calories burned in a workout.
	 * Based on exerciseType, intensity, and exerciseLength.
	 * @return caloriesBurnt: int
	 */
	int getcaloriesBurnt() {
		int caloriesBurnt = 0;
		
        if (exerciseType == "Cardio") {
            if (intensity == "Light") {
                caloriesBurnt = exerciseLength * 4;
                
            } else if (intensity=="Moderate") {
                caloriesBurnt = exerciseLength * 12;
                
            } else if (intensity == "Intense") {
                caloriesBurnt = exerciseLength * 30;
                
            }
        } else if (exerciseType == "WeightLifting") {
        	if (intensity == "Light") {
                caloriesBurnt = exerciseLength * 3;
                
            } else if(intensity == "Moderate") {
                caloriesBurnt = exerciseLength * 5;
                
            } else if (intensity =="Intense") {
                caloriesBurnt = exerciseLength * 10;
                
            }
        }else if (exerciseType =="Sports") {
            if (intensity == "Light") {
                caloriesBurnt = exerciseLength * 5;
                
            } else if(intensity == "Moderate") {
                caloriesBurnt = exerciseLength * 9;
                
            } else if (intensity =="Intense") {
                caloriesBurnt = exerciseLength * 13;
            
            }
        }
		
		return caloriesBurnt;
	}
	
	
	/*
	 * SETTERS AND GETTERS (default)
	 */
	
	
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
