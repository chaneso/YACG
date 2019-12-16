package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9192578968943740756L;
	private ArrayList<Card> deck = new ArrayList<Card>();

	public Deck(ArrayList<Card> deck) {
		super();
		this.deck = deck;
	}
	
	public void upisiSpilUfile(String lokacija) {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File(lokacija));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            System.out.println("Stavio si spil u file");
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	public void ucitajSpilIzFile(String lokacija) {
		try {
			FileInputStream fi = new FileInputStream(new File(lokacija));
			ObjectInputStream oi = new ObjectInputStream(fi);
			this.deck = ((Deck) oi.readObject()).getDeck();
			oi.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void ispis() {
		for(Card ele:deck) {
			System.out.println(ele);
		}
	}
	
	public void addCard(Card a) {
		deck.add(a);
	}

	public int getDuzina() {
		return deck.size();
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

	public Card izvuciKartu() {
		return deck.remove(getDuzina() - 1);
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

}
