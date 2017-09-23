package implementation;

/**
 * A Person class is used to calculate the BMI of a person given their weight
 * and height. Height and weight is bounded from more than 0 to infinity
 * 
 * @author Sanjay
 *
 */
public class Person {

	/**
	 * Constants for denoting the values of each weight type
	 */
	private final double UNDERWEIGHT = 18.5;
	private final double NORMAL = 25.0;
	private final double OVERWEIGHT = 30.0;

	/**
	 * Variables that are used to store the name, weight and height of each Person
	 */
	private String name;
	private double weight;
	private double height;

	/**
	 * Initializes the Person class with the value of name provided by the
	 * controller
	 * 
	 * @param name
	 *            Used to retrieve Person's name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Sets the classes weight value
	 * 
	 * @throws IllegalArgumentException
	 *             when weight is not > 0
	 * @param weight
	 *            Sets weight of the Person
	 */
	public void setWeight(double weight) {
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Sets the classes height value
	 * 
	 * @throws IllegalArgumentException
	 *             When the height of the Person is not > 0
	 * @param height
	 *            Sets the height of the Person
	 */
	public void setHeight(double height) {
		if (height > 0) {
			this.height = height;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Used to access the name
	 * 
	 * @return Returns the Person's name value
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Used to access the classes height
	 * 
	 * @return Returns the Person's height value
	 */
	public double getHeight() {
		return this.height;
	}

	/**
	 * Used to access the classes weight
	 * 
	 * @return Returns the Person's weight value
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Used to calculate and return BMI
	 * 
	 * @return Returns Person's BMI value
	 */
	public double getBMI() {
		return (Math.round(this.weight * 10.0d / (this.height * 1.0d * this.height)) / 10.0d);
	}

	/**
	 * Based on the BMI of the Person this method returns what part of the scale
	 * they're at
	 * 
	 * @return Returns the section of the scale that the Person is on
	 */
	public String getInterpretationOfBMI() {
		double BMI = getBMI();
		if (BMI < UNDERWEIGHT) {
			return "underweight";
		} else if (BMI < NORMAL) {
			return "normal";
		} else if (BMI < OVERWEIGHT) {
			return "overweight";
		}
		return "obese";
	}
}
