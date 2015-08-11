package model;

public class Land implements Card {
	
	private String name;
	private String type;
	private String colour;
	private String description;
	private boolean tapped = false;

	public Land(String name, String colour) {
		
		this.name = name;
		this.colour = colour;
		type = "land";
	}
	
	public boolean canPlay(){
		return true;
	}

	@Override
	public String getName() {
		return name;
	}
	public String getColour() {
		return colour;
}
	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean isTapped() {
		return tapped;
	}
	
	public void setTapped(boolean tapped){
		this.tapped = tapped;
	}
	
	public String displayInfo(){
		String info = (name + "\n" + type + "\n" + colour);
		return info;
	}
	

}
