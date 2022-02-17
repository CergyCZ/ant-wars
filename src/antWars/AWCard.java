package antWars;

public class AWCard {

	private int id;
	private AWCardType type;
	private int power;
	
	public AWCard(int id, int power, AWCardType type) {
		super();
		this.id = id;
		setPower(power);
		this.type = type;
	}
	
	
	public void setPower(int p) {
		if(p >= 0) {
			this.power = p;
		}
		else this.power = 0;
	}


	public int getId() {
		return id;
	}


	public AWCardType getType() {
		return type;
	}


	public int getPower() {
		return power;
	}


	@Override
	public String toString() {
		return "AWCard [id=" + id + ", type=" + type + ", power=" + power + "]";
	}
	
	
	
	
	
}
