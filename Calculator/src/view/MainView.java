package view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainView extends JFrame{
	
	public MainView(){

	GridLayout gridLayout = new GridLayout(0,1);
	
	this.setLayout(gridLayout);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(265, 350);
	
	}

}
