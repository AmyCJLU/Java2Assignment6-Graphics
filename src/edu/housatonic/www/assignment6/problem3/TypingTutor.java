//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/12/14		Problem 3
//
//	CSC*E224				Programming Assignment 6
//****************************************************************************************

package edu.housatonic.www.assignment6.problem3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TypingTutor extends JFrame{
	static JTextArea screen;
	ButtonsPane buttons;
	
	//Constructor
	public TypingTutor() {

		setLayout(new FlowLayout());
		
		JPanel wrapperPane = new JPanel(new FlowLayout());
		JPanel textPane = new JPanel();
		JPanel labelPane = new JPanel(new GridLayout());
		labelPane.setPreferredSize(new Dimension(770,40));

		buttons = new ButtonsPane();
		JLabel label = new JLabel("<html>Type some text using the keyboard. The Keys you press will be highlighted and the text will be displayed. <br />" +
									"Note: Clicking the buttons with your mouse will not perform any action.</html>");
		label.setFont(new Font("Serif", Font.PLAIN, 12));
		
		screen = new JTextArea(10,69);
		screen.setLineWrap(true);
		textPane.add(screen);
		
		labelPane.setBorder(new EmptyBorder(0,8,0,0));
		labelPane.add(label);		

		
		wrapperPane.setBorder(new EmptyBorder(-10,0,0,0));
		wrapperPane.setPreferredSize(new Dimension(770,400));
		wrapperPane.add(labelPane);
		wrapperPane.add(textPane);
		wrapperPane.add(buttons);
		
		add(wrapperPane);
		setFocusable(true);
		addKeyListener(buttons);
		
	}
	
	public static void main(String[] args){
		JFrame frame = new TypingTutor();
		
		frame.setTitle("Typing Tutor");
		frame.setLocationRelativeTo(null);
		
		frame.setSize(790,440);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
