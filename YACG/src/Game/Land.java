package Game;

public class Land extends Pernament {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3658042984702070003L;

	public Land(Effect effect, String name, String vlasnik, boolean tapped) {
		super(effect, 0, name, vlasnik, tapped);
		// TODO Auto-generated constructor stub
	}

	public Land(String name, String vlasnik, boolean tapped) {
		super(0, name, vlasnik, tapped);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Land";
	}
	
	public int addMana() {
		if (isTapped() == false) {
			setTapped(true);
			return 1;
		}
		return 0;
	}
}
