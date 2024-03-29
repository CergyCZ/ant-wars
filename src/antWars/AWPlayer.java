package antWars;

public class AWPlayer {

	private Deck deck;
	private Deck hand;
	private Deck discardPile;
	private Deck defenders;
	private Base base;
	private String name;
	final int INIT_HAND_SIZE = 3;
	
	private AWCardLoader loader;
	
	public AWPlayer(String name, int hp) {
		
		
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
	public void drawACard() {
		if(deck.getSize() > 0) {
			hand.addCard(deck.passTopCard());
		}
		else if(deck.getSize() == 0 && discardPile.getSize() > 0) {
			shuffleDiscardIntoDeck();
		}
		else {
			System.out.println("There are no cards to draw.");
		}
	}
	
	public boolean recieveCardToDiscardPile(AWCard c) {
		if(c != null) {
			discardPile.addCard(c);
			return true;
		}
		return false;
	}
	
	public void drawACard(int x) {
		for(int i = 0; i < x;i++) {
			drawACard();
		}
	}

	public void shuffleDiscardIntoDeck() {
		while(discardPile.getSize() > 0) {
			deck.addCard(discardPile.passTopCard());
		}
		deck.shuffleDeck();
		
	}
	public Deck getDeck() {
		return deck;
	}
	
	public Deck getHand() {
		return hand;
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
		return name + ": Current base HP:" + base.getCurrentHP() + ", hand size:" + hand.getSize() + 
				", deck size:" + deck.getSize() + ", discard size:" + discardPile.getSize() + ", defenders: " 
				+ defenders.getSize();
	}
	
	public int showHand() {
		int i = 0;
		for(AWCard c: hand.getDeck()) {
			System.out.println(++i + ": " + c.toString());
		}
		return i;
	}
	
	public int showDefenders() {
		int i = 0;
		for(AWCard c: defenders.getDeck()) {
			System.out.println(++i + ": " + c.toString());
		}
		return i;
	}
	
	public boolean playDefenderFromHand(int handPosition) {
		AWCard c = hand.getCardAtPosition(handPosition);
		if(c != null) {
			if(c.getType() == AWCardType.DEFENSE) {
				Deck.moveCard(hand, defenders, c);
				return true;
			}
		}
		
		return false;
	}
	
	public int playAttackFromHand(int handPosition) {
		AWCard c = hand.getCardAtPosition(handPosition);
		if(c != null) {
			if(c.getType() == AWCardType.ATTACK) {
				Deck.moveCard(hand, discardPile, c);
				return c.getPower();
			}
		}
		return 0;
	}
	
	public boolean defend(int attPower, int defenderPosition) {
		if(attPower > 0 && defenders.getSize() == 0) {
			return defend(attPower);
		}
		else if(attPower > 0 && defenderPosition < defenders.getSize()) {
			AWCard defender = defenders.getCardAtPosition(defenderPosition);
			int damage = attPower - defender.getPower();
			if(damage < 0) {
				System.out.println("Damage deflected by defender");
				return false;
			}
			if(damage >= 0) {
				defenders.removeCard(defender); //destroyed defender is not going to discard pile.
				System.out.println("Defender destroyed");
			}
			if(damage > 0) {
				//return defend(damage);
			}
		}
		System.out.println("nothing happened");
		return false;
	}
	
	public boolean defend(int attPower) {
		if(attPower > 0) {
			System.out.println("Defender's base suffered " + attPower + " damage.");
			base.alterCurrentHP(attPower*-1);
			return true;
		}
		else {
			System.out.println("No damage suffered");
			return false;
			}
	}
	
	
	/**
	 * checks hand size limit. 
	 * @param limit false if hand is below or equal to limit
	 * @return
	 */
	public boolean checkHandLimit(int limit) {
		if(hand.getSize() <= limit) {
			return false;
		}
		else return true;
	}
	
	
	
	
}
