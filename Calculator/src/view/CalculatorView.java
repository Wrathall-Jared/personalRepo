package view;

//This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorView extends JPanel{

	private JTextField firstNumber  = new JTextField(10);
	private JLabel additionLabel = new JLabel("+");
	private JTextField secondNumber = new JTextField(10);
	private JButton calculateButton = new JButton("Calculate");
	private JTextField calcSolution = new JTextField(10);

	public CalculatorView(){

		// Sets up the view and adds the components

		this.add(firstNumber);
		this.add(additionLabel);
		this.add(secondNumber);
		this.add(calculateButton);
		this.add(calcSolution);

		// End of setting up the components --------

	}

	public int getFirstNumber(){

		return Integer.parseInt(firstNumber.getText());

	}
	
	public void setNumber(String num){
		
	  this.firstNumber.setText(num);
		
	}

	public int getSecondNumber(){

		return Integer.parseInt(secondNumber.getText());

	}

	public int getCalcSolution() {

		return Integer.parseInt(calcSolution.getText());

	}

	public void setCalcSolution(int solution) {

		calcSolution.setText(Integer.toString(solution));

	}

	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed

	public void addCalculateListener(ActionListener listenForCalcButton){

		calculateButton.addActionListener(listenForCalcButton);

	}

	// Open a popup that contains the error message passed
	public void displayErrorMessage(String errorMessage){

		JOptionPane.showMessageDialog(this, errorMessage);

	}
}
// See more at: http://www.newthinktank.com/2013/02/mvc-java-tutorial/#sthash.jgPdjWko.dpuf