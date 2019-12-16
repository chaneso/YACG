package Game;

import java.util.ArrayList;

public class Turns {
	int broj;
	Player player;
	ArrayList<Faze> phase = new ArrayList<Faze>();
	Faze faze;
	
	public Turns(Player player) {
		super();
		this.broj = 0;
		this.player = player;
		phase.add(new Faze("Main1"));
		phase.add(new Faze("Combat"));
		phase.get(1).getFaze().add(new Faze("DeclareAtt"));
		phase.get(1).getFaze().add(new Faze("DeclareBloc"));
		phase.get(1).getFaze().add(new Faze("Dmg"));
		phase.get(1).getFaze().get(2).getFaze().add(new Faze("Dmg1"));
		phase.get(1).getFaze().get(2).getFaze().add(new Faze("Dmg2"));
		phase.add(new Faze("Main2"));
		faze = phase.get(0);
	}
	public void addTurn() {
		broj++;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void nextTurn(Player player) {
		broj++;
		this.player=player;
	}
	public void nextFaze(Player poslednji) {
		switch (faze.getName()) {
		case "Main1":
			faze=phase.get(1).getFaze().get(0);
			break;
		case "DeclareAtt":
			faze=phase.get(1).getFaze().get(1);
			break;
		case "DeclareBloc":
			faze=phase.get(1).getFaze().get(2).getFaze().get(0);
			break;
		case "Dmg1":
			faze=phase.get(1).getFaze().get(2).getFaze().get(1);
			break;
		case "Dmg2":
			faze=phase.get(2);
			break;
		case "Main2":
			faze=phase.get(0);
			nextTurn(poslednji);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + faze.getName());
		}
	}
	public Faze getFaze() {
		return faze;
	}
	public void setFaze(Faze faze) {
		this.faze = faze;
	}
	
}
