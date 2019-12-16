package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("radi?");
		ArrayList<Player> igraci = new ArrayList<Player>();
		igraci.add(new Player(20, "marko"));
		Deck spil = new Deck(new ArrayList<Card>());
		for (int i = 0; i < 40; i++) {
			spil.addCard(new Creature(2, "Bear", igraci.get(0).getIme(), false, 2, 2));
		}
		for (int i = 0; i < 20; i++) {
			spil.addCard(new Land("Forest", igraci.get(0).getIme(), false));
		}
		spil.upisiSpilUfile("majsor.txt");
		spil.ucitajSpilIzFile("majsor.txt");
		igraci.get(0).setDeck(spil);
		Game igra = new Game(igraci);
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		String input = null;
		while (input != "stop") {
			igraci.get(0).ispisiRuku();
			System.out.println("biraj redni broj karte koju bi igrao:");
			input = myObj.nextLine(); // Read user input
			System.out.println("input:" + input);
				try {
					if (igra.playCard(igraci.get(0).lookCardByIndex(Integer.parseInt(input) - 1))) {
						igraci.get(0).takeCardByIndex(Integer.parseInt(input) - 1);
					}
				} catch (Exception e) {
					igra.passPriority();
				}
				igra.ispisiFaze();
				igra.ispisFilda();
				igra.ispisStack();
			}
		myObj.close();

		System.out.println("radi?");

	}

}
