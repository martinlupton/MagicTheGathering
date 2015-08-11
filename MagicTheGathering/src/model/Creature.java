package model;

public class Creature extends ActionCard {

	private int power;
	private int toughness;
	private int healthCounter;
	private boolean tapped = true;

	public Creature(String name, int red, int blue, int green, int white, int black, int any, int strength,
			int toughness) {
		super(name, red, blue, green, white, black, any);
		type = "creature";
		this.setStrength(strength);
		this.setToughness(toughness);
	}

	public int getStrength() {
		return power;
	}

	public void setStrength(int strength) {
		this.power = strength;
	}

	public int getToughness() {
		return toughness;
	}

	public void setToughness(int toughness) {
		this.toughness = toughness;
	}

	public int getHealthCounter() {
		return healthCounter;
	}

	public void setHealthCounter(int healthCounter) {
		this.healthCounter = healthCounter;
	}

	@Override
	public boolean isTapped() {
		return tapped;
	}

	@Override
	public void setTapped(boolean tapped) {
		this.tapped = tapped;
		
	}

	@Override
	public String displayInfo() {
		String info = (name + "  " + manaRequirements + "\n" + description + "\n" + power + "/" + toughness);
		return info;
	}
	

}
