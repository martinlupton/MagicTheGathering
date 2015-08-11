package model;

public interface Card {
	
	public String getName();
	public String getType();
	public String getDescription();
	public boolean isTapped();
	public void setTapped(boolean tapped);
	public String displayInfo();

}