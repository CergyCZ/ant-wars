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
		return "Player status: Current base HP:" + base.getCurrentHP() + ", hand size:" + hand.getSize() + 
				", deck size:" + deck.getSize() + ", discard size:" + discardPile.getSize() + ", defenders: " 
				+ defenders.getSize();
	}
	
	public void showHand() {
		for(AWCard c: hand.getDeck()) {
			System.out.println(c.toString());
		}
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
	
	public int playAttacFromHand(int handPosition) {
		AWCard c = hand.getCardAtPosition(handPosition);
		if(c != null) {
			if(c.getType() == AWCardType.ATTACK) {
				Deck.moveCard(hand, discardPile, c);
				return c.getPower();
			}
		}
		return 0;
	}
	
	public void defend(int attPower, int defenderPosition) {
		if(attPower > 0 && defenders.getSize() == 0) {
			defend(attPower);
		}
		if(attPower > 0 && defenderPosition < defenders.getSize()) {
			AWCard defender = defenders.getCardAtPosition(defenderPosition);
			int damage = attPower - defender.getPower();
			if(damage < 0) {
				System.out.println("Damage deflected by defender");
			}
			if(damage >= 0) {
				defenders.removeCard(defender); //destroyed defender is not going to discard pile.
				System.out.println("Defender destroyed");
			}
			if(damage > 0) {
				defend(damage);
			}
		}
		else {System.out.println("nothing happened");}
	}
	
	public void defend(int attPower) {
		if(attPower > 0) {
			System.out.println("Defender's base suffered " + attPower + " damage.");
			base.alterCurrentHP(attPower*-1);
		}
		else {System.out.println("No damage suffered");}
	}
	
	
	
	
	
}
