package at.bfi.taschenrechner;

import javax.swing.JOptionPane;

public class Taschenrechner {

	public static void main(String[] args) {
		// Zahl 1 eingeben
		// Eingabe der Zahl 1 überprüfen
		// Zahl 2 eingeben
		// Eingabe der Zahl 2 überprüfen
		// Operator eingeben
		// Eingabe des Opertaors überprüfen
		// Ergebnis berechnen
		// Ergebnis ausgeben
		// Frage nach weiteren Berechnungen

		double numberInput1 = 0.0;
		double numberInput2 = 0.0;
		char operator = 0;
		boolean repeat = false;

		do {
			numberInput1 = getUserInput(1);
			numberInput2 = getUserInput(2);
			operator = getUserInput();

			try {
				JOptionPane.showMessageDialog(null, calculate(numberInput1, numberInput2, operator));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			repeat = continueCalculations();
		} while (repeat);
	}

	private static boolean continueCalculations() {
		String repeat = JOptionPane.showInputDialog(null, "Wollen Sie neu berechnen? (j/n)");
		if (repeat.equalsIgnoreCase("j")) {
			return true;
		}
		return false;
	}

	private static double getUserInput(int whichNumberInput) {

		String counter = "erste";

		if (whichNumberInput == 2) {
			counter = "zweite";
		}

		String userInput = JOptionPane.showInputDialog(null, "Was ist die " + counter + " Zahl?");

		try {
			double number = Double.parseDouble(userInput);
			return number;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Das ist keine gültige Eingabe!");
			return getUserInput(whichNumberInput);
		}
	}

	private static char getUserInput() {

		String userInput = JOptionPane.showInputDialog(null, "Wie lautet der Operator? (+, -, *, /)");

		try {
			if (checkOperatorInput(userInput)) {
				return userInput.charAt(0);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Das ist kein gültiger Operator!");
			return getUserInput();
		}
	}

	private static boolean checkOperatorInput(String operator) {

		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
			return true;
		}

		if (operator == "" || operator.isEmpty()) {
			return false;
		}
		return false;
	}

	private static double calculate(double numberInput1, double numberInput2, char operator) throws Exception {

		switch (operator) {
		case '+':
			return add(numberInput1, numberInput2);
		case '-':
			return minus(numberInput1, numberInput2);
		case '*':
			return mal(numberInput1, numberInput2);
		case '/':
			return div(numberInput1, numberInput2);
		default:
			throw new IllegalArgumentException();
		}
	}

	private static double div(double numberInput1, double numberInput2) {
		return numberInput1 / numberInput2;
	}

	private static double mal(double numberInput1, double numberInput2) {
		return numberInput1 * numberInput2;
	}

	private static double minus(double numberInput1, double numberInput2) {
		return numberInput1 - numberInput2;
	}

	private static double add(double numberInput1, double numberInput2) {
		return numberInput1 + numberInput2;
	}

}