package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NumbersView extends JPanel{
	
	private JButton zeroButton = new JButton("0");
	private JButton oneButton = new JButton("1");
	private JButton twoButton = new JButton("2");
	private JButton threeButton = new JButton("3");
	private JButton fourButton = new JButton("4");
	private JButton fiveButton = new JButton("5");
	private JButton sixButton = new JButton("6");
	private JButton sevenButton = new JButton("7");
	private JButton eightButton = new JButton("8");
	private JButton nineButton = new JButton("9");
	private JButton clearButton = new JButton("clear");
	
	public NumbersView(){
		
		GridLayout gridLayout = new GridLayout(0,3);
		
		this.setLayout(gridLayout);
		this.add(oneButton);
		this.add(twoButton);
		this.add(threeButton);
		this.add(fourButton);
		this.add(fiveButton);
		this.add(sixButton);
		this.add(sevenButton);
		this.add(eightButton);
		this.add(nineButton);
		this.add(zeroButton);
		this.add(clearButton);
		
	}
	

}
