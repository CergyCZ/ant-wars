package antWars;

import java.util.Scanner;

public class Main {



	
	
	public static void main(String[] args) {
		
		final int INITHP = 30;
		final int HANDLIMIT = 5;
		
		//IDManager idm = IDManager.getInstance();
		AWPlayer player1 = new AWPlayer("Franta", INITHP);
		AWPlayer player2 = new AWPlayer("Pepa", INITHP);
		Deck centralDeck = new Deck();
		Scanner input = new Scanner(System.in);
		
		
		AWCardLoader loader = new AWCardLoader();
		centralDeck = loader.centralDeckStartingCards;
		centralDeck.shuffleDeck();
		
		System.out.println("Ant Wars Game Starting.");
		
		boolean switchPlayer = false;
		AWPlayer attackingPlayer = player1;
		AWPlayer defendingPlayer = player2;
		while(player1.getBase().isAlive() && player2.getBase().isAlive()) {
			
			
			
			//draw 2
			attackingPlayer.drawACard(2);
			
			//play defender
			System.out.println(attackingPlayer.toString());
			System.out.println(attackingPlayer.getName() + "'s cards in hand:");
			attackingPlayer.showHand();
			System.out.println("Want to play a defender? Please give card's number. Or 0 to continue");
			boolean isDefender = false;
			int tmpHandPos = - 1;
			
			while(!isDefender) {
				tmpHandPos = input.nextInt() - 1;
				while(tmpHandPos < 0 || tmpHandPos > attackingPlayer.getHand().getSize() - 1) {
					System.out.println("Wrong input. Please give a number from card's numbers above or 0");
					tmpHandPos = input.nextInt() - 1;
				}
				if(attackingPlayer.getHand().getCardAtPosition(tmpHandPos).getType() == AWCardType.DEFENSE) {
					isDefender = true;
				}
				else {
					System.out.println("Selected card is not a defender");
				}
			}
			
			attackingPlayer.playDefenderFromHand(tmpHandPos);
			
			
			//play a defender from hand
//			int tmpHandPosition = 0;
//			boolean tmpDefenderPlayed = false;
//			while(tmpHandPosition <= attackingPlayer.getHand().getSize() && !tmpDefenderPlayed) {
//				tmpDefenderPlayed = attackingPlayer.playDefenderFromHand(tmpHandPosition);
//				tmpHandPosition++;
//				
//			}
			
			
			//attack
			System.out.println(attackingPlayer.getName() + "'s cards in hand:");
			attackingPlayer.showHand();
			boolean defenderSufferedDamage = false;
			System.out.println("Choose attack card and target:");
			System.out.println();
			if(defendingPlayer.showDefenders() == 0) {
				System.out.println("No defense, attack opponent's base directly. Input 0 for base attack.");
			}
			tmpHandPos = -1;
			tmpHandPos = input.nextInt() - 1;
			int tmpTargetDefender = input.nextInt() - 1;
			
			
			
			while(tmpHandPos < 0 || tmpHandPos > attackingPlayer.getHand().getSize() - 1) {
				System.out.println("Wrong input on Attacking cards. Please give a number from card's numbers above or 0");
				tmpHandPos = input.nextInt() - 1;
			}

			while(tmpTargetDefender < -1 || tmpTargetDefender > defendingPlayer.getDefenders().getSize() - 1) {
				System.out.println("Wrong input on defender. Please give a number from card's numbers above or 0");
				tmpTargetDefender = input.nextInt() - 1;
			}
			
			if(tmpHandPos > 0) {
				int attPower = attackingPlayer.playAttackFromHand(tmpHandPos);
				defenderSufferedDamage = defendingPlayer.defend(attPower, tmpTargetDefender);
			}
			
			
			//play an attack from hand
//			tmpHandPosition = 0;
//			boolean tmpAttackPlayed = false;
//			boolean defenderSufferedDamage = false;
//			while(tmpHandPosition <= attackingPlayer.getHand().getSize() && !tmpAttackPlayed) {
//				
//				if(attackingPlayer.getHand().getCardAtPosition(tmpHandPosition).getType() == AWCardType.ATTACK) {
//				  int attPower = attackingPlayer.playAttackFromHand(tmpHandPosition);
//				  int defenderPos = defendingPlayer.getDefenders().getSize() - 1;
//				  defenderSufferedDamage = defendingPlayer.defend(attPower, defenderPos);
//				  tmpAttackPlayed = true;
//				  
//				  
//				  
//				}
//				else tmpHandPosition++;
//			}
//			
			
			//upkeep
			if(defenderSufferedDamage) {
				defendingPlayer.recieveCardToDiscardPile(centralDeck.passTopCard());
			}
			
			
			//handlimit check
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
		}
		
		
	}
	
}

