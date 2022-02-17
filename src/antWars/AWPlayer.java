package antWars;

public class AWPlayer {

	private Deck deck;
	private Deck hand;
	private Deck discardPile;
	private Deck defenders;
	private Base base;
	
	private AWCardLoader loader;
	
	public AWPlayer(int hp) {
		
		final int INIT_HAND_SIZE = 3;
		
		loader = new AWCardLoader();
		deck = loader.loadPlayerStartingCards();
		deck.shuffleDeck();
		discardPile = new Deck();
		defenders = new Deck();
		hand = new Deck();
		base = new Base(hp);
		
		for(int i = 0; i < INIT_HAND_SIZE; i++) {
			hand.addCard(deck.passTopCard());
		}
		
		
		
	}

	public Deck getDeck() {
		return deck;
	}

	public Deck getDiscardPile() {
		return discardPile;
	}

	public Deck getDefenders() {
		return defenders;
	}

	public Base getBase() {
		return base;
	}

	@Override
	public String toString() {
		return "Player status: Current base HP: " + base.getCurrentHP() + ", hand size: " + hand.getSize() + 
				", deck size: " + deck.getSize() + ", discard size: " + discardPile.getSize();
	}
	
	public void showHand() {
		for(AWCard c: hand.getDeck()) {
			System.out.println(c.toString());
		}
	}
	
	
	
	
	
}
