package Game;

public class Creature extends Pernament {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8716473436394063660L;
	private int pow;
	private int def;
	private int dmgOnCard;

	public Creature(Effect effect, int cost, String name, String vlasnik, boolean tapped, int pow, int def) {
		super(effect, cost, name, vlasnik, tapped);
		this.pow = pow;
		this.def = def;
		dmgOnCard=0;
	}

	public Creature(int cost, String name, String vlasnik, boolean tapped, int pow, int def) {
		super(cost, name, vlasnik, tapped);
		this.pow = pow;
		this.def = def;
		dmgOnCard=0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" POW:"+Integer.toString(pow)+" DEF:"+Integer.toString(def);
	}
	
	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		this.pow = pow;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getDmgOnCard() {
		return dmgOnCard;
	}

	public void setDmgOnCard(int dmgOnCard) {
		this.dmgOnCard = dmgOnCard;
	}

}
