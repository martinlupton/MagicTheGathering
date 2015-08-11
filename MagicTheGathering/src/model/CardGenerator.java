package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.json.*;

public class CardGenerator {

	private CardCollection allCards = new CardCollection();

	public CardGenerator() throws IOException {

		String jsonFile = readFile("ORI.json");
		JSONObject obj = new JSONObject(jsonFile);
		JSONArray arr = obj.getJSONArray("cards");

		for (int i = 0; i < arr.length(); i++) {

			JSONObject currentObj = arr.getJSONObject(i);

			if (currentObj.getString("type").toLowerCase().contains("creature")) {
				String name = currentObj.getString("name");
				int power;
				int toughness;
				if (currentObj.getString("power").equals("*")) {
					power = 10;
				} else {
					power = Integer.valueOf(currentObj.getString("power"));
				}
				if (currentObj.getString("toughness").equals("*")) {
					toughness = 10;
				} else {
					toughness = Integer.valueOf(currentObj.getString("toughness"));
				}

				String description;
				try {
					description = currentObj.getString("text");
				} catch (JSONException e) {
					description = null;
				}

				int red = 0;
				int blue = 0;
				int green = 0;
				int white = 0;
				int black = 0;
				int any = 0;
					
					String s = currentObj.getString("manaCost");

					s = s.replace("{", "");
					s = s.replace("}", "");

					for(Character c: s.toCharArray()){

					if (c.equals('R'))
						red++;
					else if (c.equals('U'))
						blue++;
					else if (c.equals('G'))
						green++;
					else if (c.equals('W'))
						white++;
					else if (c.equals('B'))
						black++;
					if (Character.isDigit(c)) {
						any = Character.getNumericValue(c);
					}
				}
				// System.out.println(name + ", " + power + ", " + toughness);
				Creature creature = new Creature(name, red, blue, green, white, black, any, power, toughness);
				if (description != null)
					creature.setDescription(description);
				allCards.add(creature);

			} else if (currentObj.getString("type").toLowerCase().contains("basic land")) {
				Card card = null;
				switch (currentObj.getString("name").toLowerCase()) {

				case "forest":
					card = new Land("Forest", "green");
					break;
				case "swamp":
					card = new Land("Swamp", "black");
					break;
				case "plains":
					card = new Land("Plains", "white");
					break;
				case "mountain":
					card = new Land("Mountain", "red");
					break;
				case "island":
					card = new Land("Island", "blue");
					break;
				default: System.out.println("NULL CARD ALERT!: " + currentObj.getString("rarity").toLowerCase());
				}
				try {
					allCards.add(card);
				} catch (NullPointerException e) {
					System.out.println("Basic Land card is absent a type: "
							+ currentObj.getString("color").toLowerCase() + " is not a valid colour");
				}
			}

		}
	}

	public CardCollection getCards() {
		return allCards;
	}
	
	public CardCollection getLandCards(){
		CardCollection lands = new CardCollection();
		for(Card c: allCards){
			if(c.getType().equals("land"))
				lands.add(c);
		}
		return lands;
	}

	private String readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");

		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}

		reader.close();
		
		return stringBuilder.toString();
	}

}
