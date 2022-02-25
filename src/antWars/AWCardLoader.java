package antWars;

public class AWCardLoader {
	
	Deck playerStartingCards;
	Deck centralDeckStartingCards;
	IDManager idm;
	
	public AWCardLoader() {
		playerStartingCards = new Deck();
		centralDeckStartingCards = new Deck();
		idm = IDManager.getInstance();
	}
	
	
	public Deck loadPlayerStartingCards() {
		
		playerStartingCards.addCard(new AWCard(idm.getNewID(),1,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),5,AWCardType.ATTACK));
		
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),2,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),5,AWCardType.DEFENSE));
		
		
		return playerStartingCards;
	}
	
	public Deck loadCentralDeckStartingCards() {
		
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),5,AWCardType.ATTACK));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),5,AWCardType.ATTACK));
		
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),3,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),4,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),5,AWCardType.DEFENSE));
		playerStartingCards.addCard(new AWCard(idm.getNewID(),5,AWCardType.DEFENSE));
		
		
		return centralDeckStartingCards;
	}
	

}
