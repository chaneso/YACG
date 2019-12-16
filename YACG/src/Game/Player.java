package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2899362168792623005L;
	private int health;
	private String ime;
	private ArrayList<Card> hand;
	private Deck deck;
	private int mana;

	public Player(int health, String ime, Deck deck) {
		super();
		this.health = health;
		this.ime = ime;
		this.hand = drawHand(7);
		this.deck = deck;
		mana = 0;
	}

	public Player(int health, String ime) {
		super();
		this.health = health;
		this.ime = ime;
		this.hand = null;
		this.deck = null;
		mana = 0;
	}

	@Override
	public String toString() {
		return ime;
	}
	
	public void ispisiRuku() {
		for(Card ele:hand) {
			System.out.println(String.valueOf(hand.indexOf(ele)+1)+". "+ele.toString());
		}
	}
	public void discardCards(int kolicina) {
		System.out.println("Odaberi i diskarduj" + kolicina + "karata");
		for (Card card : hand) {
			System.out.println(card.getName());
		}
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < kolicina; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < hand.size(); j++) {
				if (hand.get(j).getName() == input) {
					hand.remove(hand.get(j));
					break;
				}
			}
		}
		sc.close();
	}

	public ArrayList<Card> drawHand(int brKarata) {
		deck.shuffleDeck();
		ArrayList<Card> ruka = new ArrayList<Card>();
		for (int i = 0; i < brKarata; i++) {
			ruka.add(deck.izvuciKartu());
		}
		return ruka;
	}

	public void mulligan() {
		int brKarata = hand.size();
		for (Card karta : hand) {
			deck.addCard(karta);
			hand.remove(karta);
		}
		drawHand(7);
		sendCardsDeck(7 - brKarata);
	}

	public void freeMulligan() {
		int brKarata = hand.size();
		for (Card karta : hand) {
			deck.addCard(karta);
			hand.remove(karta);
		}
		drawHand(brKarata);
	}

	public void sendCardsDeck(int kolicina) {
		System.out.println("Odaberi da posaljes u deck" + kolicina + "karata");
		for (Card card : hand) {
			System.out.println(card.getName());
		}
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < kolicina; i++) {
			String input = sc.nextLine();
			for (int j = 0; j < hand.size(); j++) {
				if (hand.get(j).getName() == input) {
					hand.remove(hand.get(j));
					break;
				}
			}
		}
		sc.close();
	}

	public boolean isCardInHand(Card card) {
		for (Card element : hand) {
			if (element == card) {
				return true;
			}
		}
		return false;
	}

	public int getHandSize() {
		return hand.size();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
		setHand(drawHand(7));
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Card takeCardByIndex(int i) {
		if(hand.get(i)!=null)
			return hand.remove(i);
		return null;
	}
	public Card lookCardByIndex(int i) {
		if(hand.get(i)!=null)
			return hand.get(i);
		return null;
	}
	public void drawCards(int i) {
		for(int k=0;k<i;k++) {
			hand.add(deck.izvuciKartu());
		}
	}
	public int manaInLands(Field field) {
		ArrayList<Pernament> pernamente = field.getField();
		int brojalo=0;
		for(Pernament ele:pernamente) {
			if(ele instanceof Land && ele.getimeVlasnika()==ime && ele.isTapped()==false) {
				brojalo-=-1;
			}
		}
		return brojalo;
	}
	public int tapLands(Field field,int i) {
		if(i<1) {
			return 0;
		}
		ArrayList<Pernament> pernamente = field.getField();
		int brojalo=0;
		for(Pernament ele:pernamente) {
			if(ele instanceof Land && ele.getimeVlasnika()==ime && ele.isTapped()==false) {
				ele.setTapped(true);
				brojalo-=-1;
				if(brojalo==i) {
					return i;
				}
			}
		}
		return brojalo;
	}
}
