package model;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {
	List<Card> mLands = new ArrayList<>();
	List<Card> mCreatures = new ArrayList<>();
	List<Card> mEnchant = new ArrayList<>();
	private int mRedLand;
	private int mBlueLand;
	int mTotalUntapped;
	public Battlefield(List<Card> lands, List<Card> creatures, List<Card> enchant ){
		mLands = lands;
		mCreatures = creatures;
		mEnchant = enchant;
		//mTotalUntapped = 
	}
	public int getBlueLand(Battlefield A){
		mBlueLand = 0;
		for(int i = 1; i <= A.getLands().size(); i++ ){
			int j = i - 1;
				if(A.getLands().get(j).getLandColour() == 2){
					mBlueLand++;
				}
		}	
	return mBlueLand;
}
	public int getRedLand(Battlefield A){
	mRedLand = 0;
		for(int i = 1; i <= A.getLands().size(); i++ ){
			int j = i - 1;
			
				if(A.getLands().get(j).getLandColour() == 1){
					mRedLand++;
				}
		}	
	return mRedLand;
}
	//DISPLAY BATTLEFIELD
	//NEEDS A TAPPED BOOLEAN
	public void DisplayBF(Battlefield A){
		System.out.printf("\n---------------BATTLEFIELD-------------\n");
		
		System.out.printf("\n----------------CREATURES--------------\n");
		for (int i = 1; i <= A.getCreatures().size(); i++){
			int j = i - 1;
			A.getCreatures().get(j).displayCard();
		}
	
		System.out.printf("\n---------------ENCHANTMENTS------------\n");
		for (int i = 1; i <= A.getEnchant().size(); i++){
			int j = i - 1;
			A.getEnchant().get(j).displayCard();
		}
		System.out.printf("\n-----------------LANDS-----------------\n");
		for (int i = 1; i <= A.getLands().size(); i++){
			int j = i - 1;
			A.getLands().get(j).displayCard();
		}
	}
	
	// GETTERS AND SETTERS
public List<Card> getCreatures() {
	return mCreatures;
}
public List<Card> getEnchant() {
	return mEnchant;
}
public List<Card> getLands() {
	return mLands;
}
public void setCreatures(List<Card> Creatures) {
	mCreatures = Creatures;
}
public void setEnchant(List<Card> Enchant) {
	mEnchant = Enchant;
}
public void setLands(List<Card> Lands) {
	mLands = Lands;
}
}
