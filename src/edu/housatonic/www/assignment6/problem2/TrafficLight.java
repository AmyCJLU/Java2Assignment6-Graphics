//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/12/14		Problem 2
//
//	CSC*E224				Programming Assignment 6
//****************************************************************************************

package edu.housatonic.www.assignment6.problem2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TrafficLight extends JPanel {
	private static boolean green, yellow, red;

	//Constructor
	public TrafficLight() {
		green = false;
		yellow = false;
		red = false;
	}
	
	public void makeCircles(){
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int radius = 30;
		int w = getWidth();
		int h = getHeight();
		
		g.drawRect(w/2 - 25, h/2 - 65, 50, 130);
			
		// Red Light
		if(red == true){
			g.setColor(Color.RED);
			g.fillOval(w/2 - radius/2,h/2 - 55, radius, radius);
		}
		else{
			g.setColor(Color.BLACK);
			g.drawOval(w/2 - radius/2,h/2 - 55, radius, radius);
		}
		
		// Yellow Light
		if(yellow == true){
			g.setColor(Color.YELLOW);
			g.fillOval(w/2 - radius/2, h/2 - 15, radius, radius);
		}
		else{
			g.setColor(Color.BLACK);
			g.drawOval(w/2 - radius/2, h/2 - 15, radius, radius);
		}
		
		// Green Light
		if(green == true){
			g.setColor(Color.GREEN);
			g.fillOval(w/2 - radius/2, h/2 - (-25), radius, radius);
		}
		else{
			g.setColor(Color.BLACK);
			g.drawOval(w/2 - radius/2, h/2 - (-25), radius, radius);
		}
			
	}

	// Mutable methods
	public static boolean isRed() {
		return red;
	}

	public static void setRed(boolean red) {
		TrafficLight.red = red;
	}

	public static boolean isYellow() {
		return yellow;
	}

	public static void setYellow(boolean yellow) {
		TrafficLight.yellow = yellow;
	}
	
	public static boolean isGreen() {
		return green;
	}

	public static void setGreen(boolean green) {
		TrafficLight.green = green;
	}
}
