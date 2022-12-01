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
	
	BasalMetabolicRate(String uWeight, String uHeight, String uAge, String uSex){
		sex = uSex;
		//weight = uWeight;
		//height = uHeight;
		//age = uAge;
	}
	
}
