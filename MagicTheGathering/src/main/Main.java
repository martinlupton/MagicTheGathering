package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Battlefield;
import model.Card;
import model.CardCollection;
import model.CardGenerator;
import model.Player;

public class Main {

	public static void main(String[] args) throws IOException {

		CardGenerator generator = new CardGenerator();
		CardCollection possibleCards = new CardCollection();
		CardCollection allLands = new CardCollection();
		CardCollection deck = new CardCollection();
		CardCollection hand = new CardCollection();
		// ADDED BY NICK, PROBABLY SHIT
		String name = "Player 1";
		Player player = new Player(name, hand, deck);
		CardCollection BFLands = new CardCollection();
		CardCollection BFCreatures = new CardCollection();
		CardCollection BFEnchant = new CardCollection();
		Battlefield BF = new Battlefield(BFLands, BFCreatures, BFEnchant);
		
		
		allLands = generator.getLandCards();

		for (int i = 0; i < 4; i++)
			possibleCards.addAll(generator.getCards());

		for (int i = 0; i < 40; i++) {
			if (possibleCards.get(i).getType().equals("creature"))
				deck.add(possibleCards.get(i));
		}

		for (int i = 0; i < 20; i++) {
			deck.add(allLands.get(i));
		}

		deck.shuffleCards();

		for (int i = 0; i < 7; i++) {
			hand.add(deck.get(deck.size() - 1));
			deck.remove(deck.size() - 1);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("You have been given a random deck, and have drawn a random hand.");
			System.out.println("Type: \"deck\" to view your deck");
			System.out.println("      \"deck details\" to view a detailed description of your deck");
			System.out.println("      \"hand\" to view your hand");
			System.out.println("      \"hand details\" to view a detailed description of your hand");
			
			String input = br.readLine();

			switch (input.toLowerCase()) {
			case "deck":
				for (int i = 0; i < deck.size(); i++) {
					System.out.println((i + 1) + ") " + deck.get(i).getName());
					deck.shuffleCards();
				}
				break;
			case "deck details":
				for (int i = 0; i < deck.size(); i++) {
					System.out.println("================================");
					System.out.println(deck.get(i).displayInfo());
					System.out.println("================================");
					System.out.println();
					System.out.println();
					deck.shuffleCards();
				}
				break;
			case "hand":
				for (int i = 0; i < hand.size(); i++) {
					System.out.println((i + 1) + ") " + hand.get(i).getName());
				}
				break;
			case "hand details":
				for (int i = 0; i < hand.size(); i++) {
					System.out.println("================================");
					System.out.println(hand.get(i).displayInfo());
					System.out.println("================================");
					System.out.println();
					System.out.println();
				}
				break;
			}

		}
	}

}
