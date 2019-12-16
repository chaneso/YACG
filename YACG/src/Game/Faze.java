package Game;

import java.util.ArrayList;

public class Faze {
	String name;
	ArrayList<Faze> faze;
	
	public Faze(String name, ArrayList<Faze> faze) {
		super();
		this.name = name;
		this.faze = faze;
	}
	
	public Faze(String name) {
		super();
		this.name = name;
		faze = new ArrayList<Faze>();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Trenutna faza:"+name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Faze> getFaze() {
		return faze;
	}

	public void setFaze(ArrayList<Faze> faze) {
		this.faze = faze;
	}
	
	
}
