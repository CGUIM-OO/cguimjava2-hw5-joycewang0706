import java.util.ArrayList;

public abstract class Person {
	//5注意: Person.java中，有一setOneRoundCard()，為oneRoundCard之setter，供後續程式使用
	private ArrayList<Card> oneRoundCard;
	public void setOneRoundCard(ArrayList<Card> cards){
		oneRoundCard=cards;
	}
	public ArrayList<Card> getOneRoundCard(){
		return oneRoundCard;
	}
	
	
	public abstract boolean hit_me(Table table);
	
	
	public int getTotalValue() {
		int Ace_count = 0;
		int total_value = 0;
		for (Card c : oneRoundCard) {
			if (Ace_count == 0 && c.getRank() == 1) {
				Ace_count = 1;
				continue;
			} else {
				if (c.getRank() == 11 || c.getRank() == 12 || c.getRank() == 13)
					total_value += 10;
				else
					total_value += c.getRank();
			}
		}
		if (Ace_count != 0) {
			if (total_value < 11) {
				total_value += 11;
			} else {
				total_value += 1;
			}

		}
		return total_value;
	}
	public boolean hasAce() {
		boolean hasAce= false;
		for (Card c : oneRoundCard) {
			if (c.getRank() == 1) {
				hasAce = true;
			} 
		}
		return hasAce;
	}
	/*	注意: Person.java中，有一printAllCard()，供後續程式使用
	�X	提示: Dealer.java也是繼承Person，可參考使用*/
	public void printAllCard(){
		for(Card c : oneRoundCard){
			c.printCard();
		}
	}
}
