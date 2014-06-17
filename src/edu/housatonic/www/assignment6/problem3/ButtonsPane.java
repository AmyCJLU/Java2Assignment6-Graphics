//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/12/14		Problem 3
//
//	CSC*E224				Programming Assignment 6
//****************************************************************************************

package edu.housatonic.www.assignment6.problem3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ButtonsPane extends JPanel implements KeyListener {
	static boolean caps = false;
	Color backColor;
	
	private static String[] buttonLabels = {"~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "Backspace", 
									"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\",
									"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "Enter",
									"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "^",
									" ", "<", "v", ">"};
	
	// Constructor
	public ButtonsPane() {

		// Margin Panels
		JPanel marginPane = new JPanel();
		marginPane.setBorder(new EmptyBorder(0,171,0,0));
		JPanel marginPane2 = new JPanel();
		marginPane2.setBorder(new EmptyBorder(0,74,0,0));
		JPanel marginPane3 = new JPanel();
		marginPane3.setBorder(new EmptyBorder(0,21,0, 0));
		
		
		// Create and add Buttons
		for(int i = 0; i < 57; i++){
			String label = buttonLabels[i];
			
			if(label.equals("Backspace"))
				add(new Backspace(label));
				
			else if(label.equals("Tab"))
				add(new Tab(label));
			
			else if(label.equals("Caps"))
				add(new Caps(label));
			
			else if(label.equals("Enter"))
				add(new Enter(label));
			
			else if(label.equals("Shift"))
				add(new Shift(label));
			
			else if(label.equals(" ")){
				add(marginPane);
				add(new Space(label));
				add(marginPane2);
			}
			
			else if(label.equals("^")){
				add(marginPane3);
				add(new MyButton(label));
			}
			
			else
				add(new MyButton(label));
		}
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setPreferredSize(new Dimension(770,500));
		backColor = getComponent(0).getBackground();
	}

	// Key Listener
	@Override
	public void keyPressed(KeyEvent e) {

		Component[] comps = getComponents();
		
		for(int i = 0; i < comps.length; i++){
			if(comps[i] instanceof JButton){
				JButton g = (JButton) comps[i];
				
				if(g.getText().equals(e.getKeyText(e.getKeyCode())) ){
					g.setBackground(Color.GREEN);
				}
			}
		}
		
		if(!e.isActionKey())
			TypingTutor.screen.append(String.valueOf(e.getKeyChar()));
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Component[] comps = getComponents();
		
		for(int i = 0; i < comps.length; i++){
			comps[i].setBackground(backColor);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
}

// Button classes
class MyButton extends JButton implements ActionListener{
	
	// Constructor
	public MyButton(String name) {
		super(name);
		addActionListener(this);
		setPreferredSize(new Dimension(46,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ButtonsPane.caps == false)
			TypingTutor.screen.append(getText().toLowerCase());

		else
			TypingTutor.screen.append(getText());
		
	}
	
}

// Backspace
class Backspace extends JButton implements ActionListener{
	
	// Constructor
	public Backspace(String name) {
		super(name);
		addActionListener(this);
		setPreferredSize(new Dimension(98,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = TypingTutor.screen.getText();
		if(text.length() == 0)
			return;
		TypingTutor.screen.setText(text.substring(0,text.length() -1));
	}
	
}

// Space
class Space extends JButton implements ActionListener{
	
	// Constructor
	public Space(String name) {
		super(name);
		addActionListener(this);
		setPreferredSize(new Dimension(300,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TypingTutor.screen.append(" ");
	}
	
}

// Enter
class Enter extends JButton implements ActionListener{
	
	// Constructor
	public Enter(String name) {
		super(name);
		addActionListener(this);
		setPreferredSize(new Dimension(97,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TypingTutor.screen.append("\n");
	}
	
}

// Tab
class Tab extends JButton implements ActionListener{
	
	// Constructor
	public Tab(String name) {
		super(name);
		addActionListener(this);
		setPreferredSize(new Dimension(65,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TypingTutor.screen.append("\t");
	}
	
}

// Caps
class Caps extends JButton implements ActionListener{
	
	// Constructor
	public Caps(String name) {
		super(name);
		addActionListener(this);
		setPreferredSize(new Dimension(65,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ButtonsPane.caps = !ButtonsPane.caps;
	}
	
}

// Shift
class Shift extends JButton implements ActionListener{
	
	// Constructor
	public Shift(String name) {
		super(name);
		addActionListener(this);
		setPreferredSize(new Dimension(80,30));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
		

}