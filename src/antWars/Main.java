package antWars;

import java.util.ArrayList;

public class Main {



	
	
	public static void main(String[] args) {
		
		final int INITHP = 30;
		final int HANDLIMIT = 5;
		
		IDManager idm = IDManager.getInstance();
		AWPlayer player1 = new AWPlayer("Franta", INITHP);
		AWPlayer player2 = new AWPlayer("Pepa", INITHP);
		Deck centralDeck = new Deck();
		
		
		AWCardLoader loader = new AWCardLoader();
		centralDeck = loader.centralDeckStartingCards;
		
		
		System.out.println("Ant Wars Game Starting.");
		
		boolean switchPlayer = false;
		AWPlayer attackingPlayer = player1;
		AWPlayer defendingPlayer = player2;
		while(player1.getBase().isAlive() && player2.getBase().isAlive()) {
			
			attackingPlayer.recieveCardToDiscardPile(centralDeck.passTopCard());
			attackingPlayer.drawACard(2);
			attackingPlayer.playDefenderFromHand(0);
			defendingPlayer.defend(attackingPlayer.playAttackFromHand(0), defendingPlayer.getDefenders().getSize() - 1);
			while(attackingPlayer.checkHandLimit(HANDLIMIT)) {
				AWCard c = attackingPlayer.getHand().passTopCard();
				attackingPlayer.getDiscardPile().addCard(c);
				//automatically discards top card if has too many cards
			}
			
			//switch player
			switchPlayer = !switchPlayer;
			if(switchPlayer) {
				attackingPlayer = player2;
				defendingPlayer = player1;
			}
			else {
				attackingPlayer = player1;
				defendingPlayer = player2;
			}
			System.out.println(attackingPlayer.toString());
			System.out.println(defendingPlayer.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
