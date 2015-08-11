package model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;

public abstract class ActionCard implements Card {

	protected String name;
	protected String type;
	protected String description;
	protected Map<String, Integer> manaRequirements = new HashMap<String, Integer>();

	public ActionCard(String name, Map<String, Integer> manaRequirements) {

		this.name = name;
		this.manaRequirements = manaRequirements;

	}

	public ActionCard(String name, int red, int blue, int green, int white, int black, int any) {

		manaRequirements.put("red", red);
		manaRequirements.put("blue", blue);
		manaRequirements.put("green", green);
		manaRequirements.put("white", white);
		manaRequirements.put("black", black);
		manaRequirements.put("any", any);

		this.name = name;

	}

	public boolean enoughMana(Map<String, Integer> mana) {

		boolean requirementsMet = true;

		if (mana.get("red") < manaRequirements.get("red")) {
			requirementsMet = false;
		} else if (mana.get("blue") < manaRequirements.get("blue")) {
			requirementsMet = false;
		} else if (mana.get("green") < manaRequirements.get("green")) {
			requirementsMet = false;
		} else if (mana.get("white") < manaRequirements.get("white")) {
			requirementsMet = false;
		} else if (mana.get("black") < manaRequirements.get("black")) {
			requirementsMet = false;
		}

		return requirementsMet;
	}

	public String getName() {
		if (name != null)
			return name;
		else
			return "Name Not Specified";
	}

	public void setManaRequirements(Map<String, Integer> manaRequirements) {
		this.manaRequirements = manaRequirements;
	}

	public Map<String, Integer> getManaRequirements() {
		return manaRequirements;
	}

	public String getType() {
		return type;
	}

	public void setDescription(String description) {
		this.description = WordUtils.wrap(description, 30);
	}

	public String getDescription() {
		return description;
	}

}
