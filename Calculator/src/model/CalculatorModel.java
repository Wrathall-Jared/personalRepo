package model;

// The Model performs all the calculations needed
// and that is it. It doesn't know the View
// exists

public class CalculatorModel {

	// Holds the value of the sum of the numbers
	// entered in the view

	private int calculationValue;

	public void addTwoNumbers(int firstNumber, int secondNumber){

		calculationValue = firstNumber + secondNumber;
	}

	public int getCalculationValue(){

		return calculationValue;

	}

}
// See more at: http://www.newthinktank.com/2013/02/mvc-java-tutorial/#sthash.jgPdjWko.dpuf
