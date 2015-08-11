package model;

import java.util.ArrayList;
import java.util.Random;

public class CardCollection extends ArrayList<Card> {

	private static final long serialVersionUID = 1201312450825431804L;

	public CardCollection() {

	}

	public void shuffleCards() {

		ArrayList<Card> newCollection = new ArrayList<Card>();
		ArrayList<Card> oldCollection = new ArrayList<Card>();
		
		oldCollection.addAll(this);

		Random rnd = new Random(this.size());

		for (int i = 0; i < this.size(); i++) {

			rnd = new Random();
			int index = rnd.nextInt(oldCollection.size());
			
			newCollection.add(oldCollection.get(index));
			oldCollection.remove(index);
		}
		
		this.removeAll(this);
		this.addAll(newCollection);

	}

}
