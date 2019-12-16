package Game;

public class Pernament extends Card {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9213813914201423039L;
	private boolean tapped;

	public Pernament(Effect effect, int cost, String name, String vlasnik, boolean tapped) {
		super(effect, cost, name, vlasnik);
		this.tapped = tapped;
	}

	public Pernament(int cost, String name, String vlasnik, boolean tapped) {
		super(cost, name, vlasnik);
		this.tapped = tapped;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " tapped:" + String.valueOf(tapped);
	}

	public boolean isTapped() {
		return tapped;
	}

	public void setTapped(boolean tapped) {
		this.tapped = tapped;
	}

}
