package application;

public class Exercise {
	
	//attributes
	private String exerciseType;
	private int exerciseLength;
	private String intensity;
	int caloriesBurnt = 0;
		
	public Exercise(String typeOfExercise, String intensityOfExercise, String lengthOfExercise) throws InvalidNumberException {
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
		int caloriesBurnt = 0;
        if (exerciseType == "Cardio") {
            if (intensity == "Light") {
                caloriesBurnt = exerciseLength * 4;
            }
            else if (intensity=="Moderate") {
                caloriesBurnt = exerciseLength * 12;
            }
            else if (intensity == "Intense") {
                caloriesBurnt = exerciseLength * 30;
            }
        }
        else if (exerciseType == "WeightLifting") {
            if (intensity == "Light") {
                caloriesBurnt = exerciseLength * 3;
            }
            else if(intensity == "Moderate") {
                caloriesBurnt = exerciseLength * 5;
            }
            else if (intensity =="Intense") {
                caloriesBurnt = exerciseLength * 10;
            }
        }
        else if (exerciseType =="Sports") {
            if (intensity == "Light") {
                caloriesBurnt = exerciseLength * 5;
            }
            else if(intensity == "Moderate") {
                caloriesBurnt = exerciseLength * 9;
            }
            else if (intensity =="Intense") {
                caloriesBurnt = exerciseLength * 13;
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
