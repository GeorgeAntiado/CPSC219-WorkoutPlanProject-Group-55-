package application;

public class exercise {
	
	//attributes
	String exerciseType;
	int exerciseLength;
	String intensity;
	int caloriesBurnt = 0;
		
	public exercise(String typeOfExercise, String intensityOfExercise, int lengthOfExercise) {
		exerciseType = typeOfExercise;
		intensity = intensityOfExercise;
		exerciseLength = lengthOfExercise;
	}
	int getcaloriesBurnt() {
		if (exerciseType == "cardio") {
			if (intensity == "light") {
				caloriesBurnt = exerciseLength * 4;
			}
			else if (intensity=="medium") {
				caloriesBurnt = exerciseLength * 12;
			}
			else if (intensity == "hard") {
				caloriesBurnt = exerciseLength * 30;
			}	
		}
		else if (exerciseType == "WeightLifitng") {
			if (intensity == "light") {
				caloriesBurnt = exerciseLength * 3;
			}
			else if(intensity == "medium") {
				caloriesBurnt = exerciseLength * 5;
			}
			else if (intensity =="hard") {
				caloriesBurnt = exerciseLength * 10;
			}
		}
		else if (exerciseType =="Sports") {
			if (intensity == "light") {
				caloriesBurnt = exerciseLength * 5;
			}
			else if(intensity == "medium") {
				caloriesBurnt = exerciseLength * 9;
			}
			else if (intensity =="hard") {
				caloriesBurnt = exerciseLength * 13;
			}
		}
		return caloriesBurnt;
	}
	

}
