package model;

public class Player {
	// member variables
		String mName;
		CardCollection mHand;
		int mHealth;
		int mTotalMana;
		int mRedMana;
		int mBlueMana;
		
		CardCollection mLibrary;
		
		public Player(String name, CardCollection hand, CardCollection library){
			mName = name;
			mHand = hand;
			mHealth = 20;
			mLibrary = library;
			mTotalMana =  mBlueMana + mRedMana;
			
		}
		
		//method for tapping
		public void tapLand(Player player,int redWant, int blueWant, Battlefield A){
		
			
			int blueLand = A.getBlueLand(A);
			int redLand = A.getRedLand(A);
			
			if(blueLand >= blueWant){
				player.setBlueMana(blueWant);
				for(int i = 1; i <= blueWant; i++){
					int j= i -1;
					A.getLands().get(j).setTapped(true);
					
				}
			}else{
				System.out.println("You do not have enough Lands for that.");
			}
			if(redLand >= redWant){
				player.setRedMana(redWant);
				for(int i = 1; i <= redWant; i++){
					int j= i -1;
					A.getLands().get(j).setTapped(true);
				}
			}else{
				System.out.println("You do not have enough Lands for that.");
			}
			
			
			//player.setTotalUntapped(totalUntapped);
			
			System.out.printf("You have %d blue mana and %d red mana.\n\n", blueWant, redWant);
			
		}
		
		
		//getters and setters
		
		public String getName(){
			return mName;
		}
		public CardCollection getHand(){
			return mHand;
		}
		public CardCollection getLibrary(){
			return mLibrary;
		}
		public int getTotalMana(){
			return mTotalMana;
		}
		public int getRedMana(){
			return mRedMana;
		}
		public int getBlueMana(){
			return mBlueMana;
		}
		//public int getTotalUntapped(){
			//return mTotalUntapped;	
		//}
		//public void setTotalUntapped(int totalUntapped){
			//mTotalUntapped = totalUntapped;
		//}
		
		public void setTotalMana(){
			mTotalMana = getRedMana()+getBlueMana();
		}
		public void setRedMana(int landCount){
			mRedMana = landCount;
		}
		public void setBlueMana(int landCount){
			mBlueMana = landCount;
			
			}
}
