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
		
		player1.showHand();
		System.out.println();
		
		player2.showHand();
		
		player1.playDefenderFromHand(0);
		System.out.println(player1.toString());
		
		int tmpAttack = player2.playAttacFromHand(0);
		player1.defend(tmpAttack, 0);
		System.out.println(player1.toString());
		
		//gameloop
//		while(player1.getBase().isAlive() && player2.getBase().isAlive()) {
//			
//		}
		
		
		
	}
}
