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
		
		//TODO lizani karet z central decku.
		
		
		
		//gameloop
		
//		while(player1.getBase().isAlive() && player2.getBase().isAlive()) {
//			
//		}
		
		
		
	}
}
