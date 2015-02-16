package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumberPadController {

	private view.CalculatorView calcView;
	private view.NumbersView numView;
	private model.CalculatorModel calcModel;
	


	public NumberPadController(view.NumbersView numView, model.CalculatorModel calcModel, view.CalculatorView calcView){
		this.calcView = calcView;
		this.numView = numView;
		this.calcModel = calcModel;

	}


	class NumberPressListener implements ActionListener{

		public void actionPerformed(JButton b, ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try{

				//firstNumber = calcView.setFirstNumber(b.getText()+calcView.getFirstNumber());


			}

			catch(NumberFormatException ex){

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
}

