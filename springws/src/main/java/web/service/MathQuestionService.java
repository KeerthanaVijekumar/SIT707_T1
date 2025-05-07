package web.service;

public class MathQuestionService {

	public static double q1Addition(String number1, String number2) {
		try {
			double num1 = Double.parseDouble(number1);
			double num2 = Double.parseDouble(number2);
			return num1 + num2;
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid input for addition: " + e.getMessage());
		}
	}

	public static double q2Subtraction(String number1, String number2) {
		try {
			double num1 = Double.parseDouble(number1);
			double num2 = Double.parseDouble(number2);
			return num1 - num2;
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid input for subtraction: " + e.getMessage());
		}
	}
	
	public static double q3Multiplication(String number1, String number2) {
		try {
			double num1 = Double.parseDouble(number1);
			double num2 = Double.parseDouble(number2);
			return num1 * num2;
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid input for multiplication: " + e.getMessage());
		}
	}

}
