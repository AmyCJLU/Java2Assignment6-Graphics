//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/12/14		Problem 2
//
//	CSC*E224				Programming Assignment 6
//****************************************************************************************

package edu.housatonic.www.assignment6.problem2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Gui extends JFrame implements ActionListener {
	private TrafficLight tl = new TrafficLight();
	JRadioButton redCheck;
	JRadioButton yellowCheck;
	JRadioButton greenCheck;

	public Gui() {
		
		JPanel pane = new JPanel();
		redCheck = new JRadioButton("Red");
		yellowCheck = new JRadioButton("Yellow");
		greenCheck = new JRadioButton("Green");
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(redCheck);
		radioGroup.add(yellowCheck);
		radioGroup.add(greenCheck);
		
		
		setLayout(new BorderLayout());
		
		pane.add(redCheck);
		pane.add(yellowCheck);
		pane.add(greenCheck);
		
		add(tl, BorderLayout.CENTER);
		add(pane, BorderLayout.SOUTH);
		
		redCheck.addActionListener(this);
		yellowCheck.addActionListener(this);
		greenCheck.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		JFrame gui = new Gui();
		
		gui.setTitle("Traffic Light");
		gui.setLocationRelativeTo(null);
		gui.setSize(300, 230);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == redCheck){
			TrafficLight.setRed(true);
			TrafficLight.setGreen(false);
			TrafficLight.setYellow(false);
		}
		else if(source == yellowCheck){
			TrafficLight.setYellow(true);
			TrafficLight.setRed(false);
			TrafficLight.setGreen(false);
		}
		else{
			TrafficLight.setGreen(true);
			TrafficLight.setYellow(false);
			TrafficLight.setRed(false);
		}
		repaint();
	}

}
