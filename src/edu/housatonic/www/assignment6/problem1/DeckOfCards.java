//****************************************************************************************
//	Author: Breno Silva		Last Modified: 04/10/14		Problem 1
//
//	CSC*E224				Programming Assignment 6
//****************************************************************************************

package edu.housatonic.www.assignment6.problem1;

public class DeckOfCards {
	private int[] deck;
	private final String[] SUITS = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
			  "10", "Jack", "Queen", "King"};
	
	public DeckOfCards() {
		deck = new int[52];   
	}
	
	public int[] shuffle(){
		int[] returnCards = new int[4];
		
	    // Initialize cards
	    for (int i = 0; i < deck.length; i++)
	    	deck[i] = i;
	    
	    // Shuffle the cards
	    for (int i = 0; i < deck.length; i++) {
			// Generate an index randomly
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index]; 
			deck[index] = temp;
	    }

	    // Display the first four cards
	    for (int i = 0; i < 4; i++) {
	      String suit = SUITS[deck[i] / 13];
	      String rank = RANKS[deck[i] % 13];
	      System.out.println("Card number " + deck[i] + ": " 
	        + rank + " of " + suit);
	      
	      returnCards[i] = deck[i];
	    }
		return returnCards;
	}

	public int[] getDeck() {
		return deck;
	}

	public void setDeck(int[] deck) {
		this.deck = deck;
	}

	public String[] getSUITS() {
		return SUITS;
	}

	public String[] getRANKS() {
		return RANKS;
	}

}
