import java.util.ArrayList;

public class Player extends Person{//player繼承person,繼承的父類別只要宣告裡有abstract就必須實作

	private String name; // 玩家姓名
	private int chips; // 玩家有的籌碼
	private int bet;// 玩家此局下注的籌碼
	private ArrayList<Card> oneRoundCard = new ArrayList<Card>();// 此牌局的卡//<Card>資料形態要有

	public Player(String name, int chips) {
		// Player constructor，新增Player物件時，需要姓名、擁有的籌碼等兩個參數
		setName(name);
		setChips(chips);

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public ArrayList getOneRoundCard() {
		return oneRoundCard;
	}

	public void setOneRoundCard(ArrayList cards) {// 設定此牌局所得到的卡 setter
		this.oneRoundCard = cards;
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	public void sayHello() {
		// TODO Auto-generated method stub
		// 玩家Say Hello
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");

	}

	public int makeBet() {
		// TODO Auto-generated method stub
		// 下注，回傳預計下注的籌碼
		// 基本下注：一次1元
		// 如
		// bet=1;
		// return bet;
		// 注意：要檢查是否還有錢，沒錢了就不能再繼續下注
		bet = 1;
		if (chips <= 0) {
			bet = 0;
		}

		return bet;
	}

//	public boolean hitMe() {
//		// TODO Auto-generated method stub
//		// 是否要牌，是回傳true，不再要牌則回傳false
//		// 基本參考條件：16點以下要牌，17點以上不要牌
//		// 提示：用oneRoundCard來算
//		int c1 = 0;// 也可以寫在最外面"全域變數"就不用一直int
//		for (int i = 0; i < oneRoundCard.size(); i++) {
//			c1 += oneRoundCard.get(i).getRank();// oneRoundCard有兩樣東西Suit
//												// rank//把c1每次都加起來
//		}
//		if (c1 < 16) {
//			return true;
//		} else {
//			return false;
//		}

//	}

//	public int getTotalValue() {
//		// TODO Auto-generated method stub
//		// 回傳此牌局所得的卡點數加總
//		/* 
//		 * A可作一點或十一點，
//		 * 2-10作該牌之點數，
//		 * J、Q、K作10點
//		 */
//		int c1 = 0;
//		for (int i = 0; i < oneRoundCard.size(); i++) {
//			if(oneRoundCard.get(i).getRank()==11 ||
//					oneRoundCard.get(i).getRank()==12||
//					oneRoundCard.get(i).getRank()==13){
//				oneRoundCard.get(i).setRank(10);
//			}
//			c1 += oneRoundCard.get(i).getRank();// oneRoundCard有兩樣東西Suit
//												// rank//把c1每次都加起來
//		}
//		return c1;
//	}

	public void increaseChips(int p1Bet) {
		// TODO Auto-generated method stub
		// 回傳玩家現有籌碼
		setChips(getChips() - p1Bet);// 用設定的籌碼拿籌碼扣賭注

	}

	public int getCurrentChips() {
		// TODO Auto-generated method stub
		return getChips();// 直接取算出來的值會一直變動

	}

	@Override
	public boolean hit_me(Table table) {
		// TODO Auto-generated method stub
		return false;
	}
}