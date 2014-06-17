//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/10/14		Problem 1
//
//	CSC*E224				Programming Assignment 6
//****************************************************************************************

package edu.housatonic.www.assignment6.problem1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeckGui extends JFrame implements ActionListener{
	private DeckOfCards deck;
	private int[] cards = new int[4];
	private ImagePanel imgPanel;
	
	// Constructor
	public DeckGui(){
		deck = new DeckOfCards();
		imgPanel = new ImagePanel();
		
		// Create Panels and JButtons
		JPanel pane = new JPanel();
		JButton refresh = new JButton("Refresh");
		
		
		// Add pane to Frame
		pane.add(imgPanel);
		pane.add(refresh);
		add(pane);
		
		// Register action listener
		refresh.addActionListener(this);
	}

	
	// Main Method
	public static void main(String[] args) {
		
		DeckGui gui = new DeckGui();
		gui.setSize(310,170);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cards = deck.shuffle(); // shuffle deck
		
		// update cards in panel
		for(int i = 0; i < 4; i++)
			imgPanel.setCards(i, String.valueOf(cards[i]+1));

		imgPanel.findImages(); // get images from the file
		repaint(); // repaint the frame

	}

}

// Image panel class
class ImagePanel extends JPanel{
	private String[] cards;
	private Image[] image;
	
	// Constructor
	public ImagePanel() {
		cards = new String[4];
		image = new Image[4];
		
		// Set cards to start face down.
		for(int i = 0; i < 4; i++)
			this.cards[i] = "backCard";
		
		findImages();
		setPreferredSize(new Dimension(288,96));
	}	
	
	// Get the image files method
	public void findImages(){
		ImageIcon[] imgIcon = new ImageIcon[4];
		
		for(int i = 0; i < 4; i++){
			imgIcon[i] = new ImageIcon("images/cards/"+cards[i]+".png");
			image[i] = imgIcon[i].getImage();	
		}	
	}
	
	// Draw images method
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < 4; i++){
			if(image[i] != null)
				g.drawImage(image[i], 72*i, 0, 72, 96, this);
		}
		
	}

	// Mutable methods
	public void setCards(int i, String cards) {
		this.cards[i] = cards;
	}
	
}
