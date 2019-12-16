package Game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Player winner;
	private ArrayList<Player> players;
	private Turns turns;
	private Field field;
	private Player priority;
	private int playedLands;

	public Game(ArrayList<Player> players) {
		super();
		this.winner = null;
		this.players = players;
		Random rand = new Random();
		int n = rand.nextInt(players.size());
		this.turns = new Turns(players.get(n));
		this.field = new Field();
		priority = players.get(n);
		playedLands = 0;
	}

	public void ispisFilda() {
		for (Player igrac : players) {
			field.ispisTableIgraca(igrac);
		}
	}

	public void ispisStack() {
		field.ispisStack();
	}
	
	public void passPriority() {
		if(priority==pronadjiPoslednjegIgracaPoteza()) {
			if(field.isStackEmpty()) {
				turns.nextFaze(pronadjiPoslednjegIgracaPoteza());	
				if(turns.getFaze().getName()=="Main1") {
					turns.getPlayer().drawCards(1);
					turns.getPlayer().untapAll(field);
					playedLands=0;
				}
			}else {
				field.popStack();
			}
		}
		
		if(players.indexOf(priority)==players.size()-1) {
			priority = players.get(0);
			return;
		}
		priority = players.get(players.indexOf(priority)+1);
	}
	
	public Player pronadjiPoslednjegIgracaPoteza() {
		if(players.indexOf(turns.getPlayer())==0) {
			return players.get(players.size()-1);
		}
		return players.get(players.indexOf(turns.getPlayer())-1);
	}
	
	public boolean playCard(Card card) {
		Player Igrac = nadjiIgraca(card.getimeVlasnika());
		if(Igrac==null) {
			System.out.println("Karta nema igraca");
			return false;
		}
		if(card instanceof Land) {
			if(playedLands==0 && field.isStackEmpty()) {
				field.addCardToField((Pernament) card);
				playedLands-=-1;
				return true;
			}else {
				return false;
			}
		}
		if (card.getCost() <= Igrac.getMana()+Igrac.manaInLands(field)) {
			if (Igrac == priority) {
				if (Igrac == turns.getPlayer() && field.isStackEmpty()) {
					if (Igrac.isCardInHand(card)) {
						cleanUpStep();
						Igrac.tapLands(field,card.getCost()-Igrac.getMana());
						Igrac.setMana(Igrac.getMana() - card.getCost());
						field.castSpell(card);
						return true;
					}
				}
			}
		}
		return false;
	}

	public void stateBaseAction() {
		for (Player player : players) {
			if (player.getHealth() <= 0) {
				players.remove(player);
			}
		}
		if (players.size() == 1) {
			winner = players.get(0);
			System.out.println("Pobednik je:" + winner + "!");
			System.exit(0); 
		}
	}

	public Player nadjiIgraca(String ime) {
		for (Player ele : players) {
			if (ele.getIme().equals(ime)) {
				return ele;
			}
		}
		return null;
	}

	public void cleanUpStep() {
		for (Player player : players) {
			while (player.getHandSize() > 7) {
				player.discardCards(player.getHandSize() - 7);
			}
		}
	}

	public void ispisiFaze() {
		System.out.println(turns.getFaze());
	}
	public Faze getFaze() {
		return turns.getFaze();
	}
}
