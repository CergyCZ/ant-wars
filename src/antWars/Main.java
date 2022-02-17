package antWars;

public class Main {



	
	
	public static void main(String[] args) {
		
		final int INITHP = 30;
		
		IDManager idm = IDManager.getInstance();
		AWPlayer player1 = new AWPlayer(INITHP);
		AWPlayer player2 = new AWPlayer(INITHP);
		Deck centralDeck = new Deck();
		
		AWCardLoader loader = new AWCardLoader();
		centralDeck = loader.centralDeckStartingCards;
		
		
		System.out.println("Ant Wars Game Starting.");
		
		
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		
		player1.showHand();
		System.out.println();
		player2.showHand();
		
		//gameloop
//		while(player1.getBase().isAlive() && player2.getBase().isAlive()) {
//			
//		}
		
		
		
	}
}
