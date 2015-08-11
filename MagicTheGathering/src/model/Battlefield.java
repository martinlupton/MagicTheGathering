package model;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {
	CardCollection mLands = new CardCollection();
	CardCollection mCreatures = new CardCollection();
	CardCollection mEnchant = new CardCollection();
	private int mRedLand;
	private int mBlueLand;
	int mTotalUntapped;
	// TODO implement the lists for another player
	public Battlefield(CardCollection lands, CardCollection creatures, CardCollection enchant ){
		mLands = lands;
		mCreatures = creatures;
		mEnchant = enchant;
		//mTotalUntapped = 
	}
	public int getBlueLand(Battlefield A){
		mBlueLand = 0;
		for(int i = 1; i <= A.getLands().size(); i++ ){
			int j = i - 1;
				if(A.getLands().get(j).getColour() == 2){
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
public CardCollection getCreatures() {
	return mCreatures;
}
public CardCollection getEnchant() {
	return mEnchant;
}
public CardCollection getLands() {
	return mLands;
}
public void setCreatures(CardCollection Creatures) {
	mCreatures = Creatures;
}
public void setEnchant(CardCollection Enchant) {
	mEnchant = Enchant;
}
public void setLands(CardCollection Lands) {
	mLands = Lands;
}
}
