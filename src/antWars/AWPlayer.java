package antWars;

public class AWPlayer {

	private Deck deck;
	private Deck discardPile;
	private Deck defenders;
	private Base base;
	
	public AWPlayer(int hp) {
		deck = new Deck();
		discardPile = new Deck();
		defenders = new Deck();
		base = new Base(hp);
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
	
	
	
	
	
}
