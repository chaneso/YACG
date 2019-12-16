package Game;

public abstract class Card implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -781946648937147171L;
	Effect effect;
	int cost;
	String name;
	String imeVlasnika;
	
	public Card(Effect effect, int cost, String name, String imeVlasnika) {
		super();
		this.effect = effect;
		this.cost = cost;
		this.name = name;
		this.imeVlasnika = imeVlasnika;
	}
	public Card(int cost, String name, String imeVlasnika) {
		super();
		this.effect = null;
		this.cost = cost;
		this.name = name;
		this.imeVlasnika = imeVlasnika;
	}
	@Override
	public String toString() {
		return name;
	}
	public String getimeVlasnika() {
		return imeVlasnika;
	}

	public void setimeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}

	public Effect getEffect() {
		return effect;
	}
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
