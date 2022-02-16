package antWars;

public class Base extends AWCard {
	
	int currentHP;
	boolean alive;
	
	public Base(int hp) {
		super(0,hp,AWCardType.BASE);
		this.currentHP = hp;
		alive = true;
		
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void alterCurrentHP(int amount) {
		this.currentHP += amount;
		if (currentHP <= 0) {
			alive = false;
		}
		
	}
	
	public boolean isAlive() {
		return alive;
	}
	

}
