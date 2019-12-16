package Game;

public class Effect {
	private String name;
	private Player target;

	public Effect(String name) {
		super();
		this.name = name;
	}

	public Effect(String name, Player target) {
		super();
		this.name = name;
		this.target = target;
	}

	public void activate() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}

}
