package antWars;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for creating various Decks of Cards
 * Basically just wrapped ArrayList with few deck traits
 * @author CergyTP
 *
 */
public class Deck {
	ArrayList<AWCard> deckArrayList;
	
	
	
	/**
	 * Constructor
	 */
	public Deck() {
		deckArrayList = new ArrayList<AWCard>();
	}

	/**
	 * Constructor with ArrayList parameter
	 * @param deck ArrayList to create deck upon
	 */
	public Deck(ArrayList<AWCard> deck) {
		this.deckArrayList = deck;
	}
	
	/**
	 * Add Card to Deck, to its bottom (highest position number)
	 * @param c Card to add
	 * @return true upon successful add
	 */
	public boolean addCard(AWCard c) {
		return deckArrayList.add(c);
	}
	
	/**
	 * If deck has card, it returns Card's instance and removes the card from deck
	 * @param c Card to be passed from this Deck.
	 * @return passed Card if successful, NULL if not.
	 */
	public AWCard passCard(AWCard c) {
		if (deckArrayList.contains(c)) {
			deckArrayList.remove(c);
			return c;
		}
		else return null;
	}
	/**
	 * If deck has a card on certain position, removes the card from Deck and passes it in return value
	 * @param listPosition position of card in deck. 0 is top position.
	 * @return passed Card if successful, NULL if not.
	 */
	public AWCard passCard(int listPosition) {
		
		if(deckArrayList.size() > listPosition) {
			AWCard c = deckArrayList.get(listPosition);
			if(this.removeCard(c)) return c;
			else return null;
		}
		else return null;
	}
	
	/**
	 * Removes card from Deck
	 * @param c Card to be removed
	 * @return True if successful, False if not.
	 */
	public boolean removeCard(AWCard c) {
		if (deckArrayList.contains(c)) {
			deckArrayList.remove(c);
			return true;
		}
		else return false;
	}
	
	/**
	 * Static method to move Card from One deck to another
	 * @param fromDeck Original Deck with card to be moved from.
	 * @param toDeck Target deck.
	 * @param card Card to be moved
	 * @return True if successful, false if not.
	 */
	public static boolean moveCard(Deck fromDeck, Deck toDeck, AWCard card) { //možná static?
		if(fromDeck.containsCard(card)) {
			toDeck.addCard(card);
			fromDeck.removeCard(card);
			return true;
		}
		else return false;
	}
	/**
	 * Move card from instance of the deck to another deck
	 * @param toDeck Target deck
	 * @param card card to be moved
	 * @return true if successful, false if not.
	 */
	public boolean moveCard(Deck toDeck, AWCard card) {
		return moveCard(this, toDeck, card);
	}
	
	/**
	 * Find out if deck contains certain card by its id
	 * @param cardId ID of card
	 * @return true if contains.
	 */
	public boolean containsCard(int cardId) {
		for(AWCard c: deckArrayList) {
			if(c.getId() == cardId) return true;
		}
		return false;
	}
	
	/**
	 * Find out if deck contains card
	 * @param card Card
	 * @return true id contains
	 */
	public boolean containsCard(AWCard card) {
		return deckArrayList.contains(card);
	}
	
	public ArrayList<AWCard> getDeck() {
		return this.deckArrayList;
	}
	
	/**
	 * Shuffles deck.
	 */
	public void shuffleDeck() {
		Collections.shuffle(deckArrayList);
	}
	
	
	/**
	 * returns card on top of deck
	 * @return Top card from deck or Null if the Deck is empty.
	 */
	public AWCard topCard() {
		if(deckArrayList.size() > 0) return deckArrayList.get(0);
		else return null;
	}

}
