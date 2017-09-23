package application;

import java.util.Scanner;

import implementation.Person;

public class BMICalculator {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Calculate your Body Mass Index");
		boolean userWantsToContinue = true;
		while (userWantsToContinue) {
			System.out.println("What is your name?");
			String name = input.nextLine();
			Person p = new Person(name);
			
			System.out.println("What is your weight in kilograms?");
			/* You can assume user always enters weight in kg */
			double weight = input.nextDouble();
			input.nextLine();
			
			try {
				p.setWeight(weight);
				
				System.out.println("What is your height in meters?");
				/* You can assume user always enters weight in kg */
				double height = input.nextDouble();
				input.nextLine();
				
				try {
					p.setHeight(height);
					double bmi = p.getBMI();
					System.out.println(p.getName() + ":");
					System.out.println("Your weight is " + p.getWeight() + " kgs");
					System.out.println("Your height is " + p.getHeight() + " meters");
					System.out.println("Your Body Mass Index is " + bmi);
					System.out.println("This is considered " + p.getInterpretationOfBMI());
				}
				catch (IllegalArgumentException e) {
					System.out.println("Error: height is not positive!");
				}
			}
			catch (IllegalArgumentException e) {
				System.out.println("Error: weight is not positive!");
			}
			System.out.println("Do you want to continue?(Y/N)");
			String answer = input.nextLine();
			if (answer.equals("N")) {
				userWantsToContinue = false;
			}
		}
		System.out.println("Bye!");
		input.close();
	}
}
