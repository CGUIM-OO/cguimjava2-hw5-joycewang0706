import java.util.ArrayList;

class Table {
	/*
	 * 新增Class field, final, int, MAXPLAYER = 4
	 * 
	 * 最多一張牌桌能坐幾個人
	 */
	private static final int MAXPLAYER = 4;// 怎麼用都不能改值
	private static Deck deck;// 存放所有的牌
	private static ArrayList<Player> players;// 存放所有的玩家
	private static Dealer dealer;// 存放一個莊家
	private static ArrayList<Integer> pos_betArrary;// 存放每個玩家在一局下的注(instance
													// field)
	private static Card c;
	Player player1 = new Player("Player 1", 300);
	Player player2 = new Player("Player 2", 300);
	Player player3 = new Player("Player 3", 300);
	Player player4 = new Player("Player 4", 300);

	// private ArrayList<Table> tbl;
	// tbl=new ArrayList<Table>(4);
	// int maxplayer=4;
	// for(int i=1;i<=maxplayer;i++){
	// tbl.get(i);
	// }

	/*
	 * 新增 int[] pos_betArray，存放每個玩家在一局下的注(instance field)
	 */
	// public static void pos_betArrary(){
	// int pos_betArrary=0;
	// pos_betArrary=player1.get(makeBet());
	// }
	/*
	 * 輸入參數為 int nDeck 請將Deck class實體化，並存入上述新增的Deck變數(instance field) 新增
	 * 請初始化上述新增型別為Player[]的變數(instance field) 宣告一個長度是MAXPLAYER 的Player array
	 */
	public Table(int nDeck) {
		// TODO Auto-generated constructor stub
		deck = new Deck(nDeck);
		players = new ArrayList<Player>(MAXPLAYER);

	}

	public Card get_face_up_card_of_dealer() {

		return null;
	}

	/*
	 * 請每個玩家打招呼 (提示 say_hello()) 請每個玩家下注 (提示 make_bet())
	 * 每個玩家下的注要存在pos_betArray供之後使用
	 */
	private void ask_each_player_about_bets() {

		// Player player1=new Player("Player 1",300);
		// Player player2=new Player("Player 2",300);
		// Player player3=new Player("Player 3",300);
		// Player player4=new Player("Player 4",300);
		player1.sayHello();
		player2.sayHello();
		player3.sayHello();
		player4.sayHello();
		int p1Bet = player1.makeBet();
		int p2Bet = player2.makeBet();
		int p3Bet = player3.makeBet();
		int p4Bet = player4.makeBet();
		pos_betArrary.add(p1Bet + p2Bet + p3Bet + p4Bet);

	}

	private void distribute_cards_to_dealer_and_players() {
		/*
		 * 發牌給玩家跟莊家，先發兩張打開的牌 給玩家再一張蓋著的牌，以及一張打開的牌給莊家
		 */
		ArrayList<Card> player1Card = new ArrayList<Card>();
		player1Card.add(deck.getOneCard(true));
		player1Card.add(deck.getOneCard(true));
		player1.setOneRoundCard(player1Card);

		ArrayList<Card> player2Card = new ArrayList<Card>();
		player2Card.add(deck.getOneCard(true));
		player2Card.add(deck.getOneCard(true));
		player2.setOneRoundCard(player2Card);

		ArrayList<Card> player3Card = new ArrayList<Card>();
		player3Card.add(deck.getOneCard(true));
		player3Card.add(deck.getOneCard(true));
		player3.setOneRoundCard(player3Card);

		ArrayList<Card> player4Card = new ArrayList<Card>();
		player4Card.add(deck.getOneCard(true));
		player4Card.add(deck.getOneCard(true));
		player4.setOneRoundCard(player4Card);

		ArrayList<Card> dealerCard = new ArrayList<Card>();
		dealerCard.add(deck.getOneCard(true));
		for (Card c : dealerCard) {// dealerCard這組排變成一張一張的card
			c.printCard();// print player1所有的排
		}
		dealerCard.add(deck.getOneCard(false));
		dealer.setOneRoundCard(dealerCard);
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static void set_Player(int pos, Player p) {
		players.add(p);
		pos = MAXPLAYER;
	}

	// public static Dealer getDealer() {
	// return dealer;
	// }
	/*
	 * 將Dealer放到牌桌上(意即將Dealer放到 型別為Dealer 的變數(instance field) 中，為變數之setter)。
	 */
	public static void set_dealer(Dealer d) {
		Table.dealer = dealer;
	}

	private void ask_each_player_about_hits() {
		ArrayList<Card> player1Card = new ArrayList<Card>();
		player1Card.add(deck.getOneCard(true));
		player1Card.add(deck.getOneCard(true));
		player1.setOneRoundCard(player1Card);

		ArrayList<Card> player2Card = new ArrayList<Card>();
		player2Card.add(deck.getOneCard(true));
		player2Card.add(deck.getOneCard(true));
		player2.setOneRoundCard(player2Card);

		ArrayList<Card> player3Card = new ArrayList<Card>();
		player3Card.add(deck.getOneCard(true));
		player3Card.add(deck.getOneCard(true));
		player3.setOneRoundCard(player3Card);

		ArrayList<Card> player4Card = new ArrayList<Card>();
		player4Card.add(deck.getOneCard(true));
		player4Card.add(deck.getOneCard(true));
		player4.setOneRoundCard(player4Card);
		boolean hit = false;
		do {
			hit = player1.hit_me(null); // this
			if (hit) {
				player1Card.add(deck.getOneCard(true));
				player1.setOneRoundCard(player1Card);
				System.out.print("Hit! ");
				System.out.println(player1.getName() + "'s Cards now:");
				for (Card c : player1Card) {
					c.printCard();// print player1所有的排
				}
			} else {
				System.out.println(player1.getName() + ", Pass hit!");
				System.out.println(player1.getName() + ", Final Card:");
				for (Card c : player1Card) {
					c.printCard();
				}
			}
		} while (hit);

		hit = false;
		do {
			hit = player2.hit_me(null); // this
			if (hit) {
				player2Card.add(deck.getOneCard(true));
				player2.setOneRoundCard(player2Card);
				System.out.print("Hit! ");
				System.out.println(player2.getName() + "'s Cards now:");
				for (Card c : player2Card) {
					c.printCard();
				}
			} else {
				System.out.println(player2.getName() + ", Pass hit!");
				System.out.println(player2.getName() + ", Final Card:");
				for (Card c : player2Card) {
					c.printCard();
				}
			}
		} while (hit);
		hit = false;
		do {
			hit = player3.hit_me(null); // this
			if (hit) {
				player3Card.add(deck.getOneCard(true));
				player3.setOneRoundCard(player3Card);
				System.out.print("Hit! ");
				System.out.println(player3.getName() + "'s Cards now:");
				for (Card c : player3Card) {
					c.printCard();
				}
			} else {
				System.out.println(player3.getName() + ", Pass hit!");
				System.out.println(player3.getName() + ", Final Card:");
				for (Card c : player3Card) {
					c.printCard();
				}
			}
		} while (hit);
		hit = false;
		do {
			hit = player4.hit_me(null); // this
			if (hit) {
				player4Card.add(deck.getOneCard(true));
				player4.setOneRoundCard(player4Card);
				System.out.print("Hit! ");
				System.out.println(player4.getName() + "'s Cards now:");
				for (Card c : player4Card) {
					c.printCard();
				}
			} else {
				System.out.println(player4.getName() + ", Pass hit!");
				System.out.println(player4.getName() + ", Final Card:");
				for (Card c : player4Card) {
					c.printCard();
				}
			}
		} while (hit);
	}

	private void ask_dealer_about_hits() {
		ArrayList<Card> dealerCard = new ArrayList<Card>();
		dealerCard.add(deck.getOneCard(true));
		for (Card c : dealerCard) {// dealerCard這組排變成一張一張的card
			c.printCard();// print player1所有的排
		}
		dealerCard.add(deck.getOneCard(false));
		dealer.setOneRoundCard(dealerCard);
		boolean hit = false;
		do {
			hit = dealer.hit_me(null); // this
			if (hit) {
				dealerCard.add(deck.getOneCard(true));
				dealer.setOneRoundCard(dealerCard);
				System.out.print("Hit! ");
				System.out.println("Dealer" + "'s Cards now:");
				for (Card c : dealerCard) {
					c.printCard();
				}
			} else {
				System.out.println("Dealer's hit is over");
				for (Card c : dealerCard) {
					c.printCard();
				}
			}
		} while (hit);
	}

	private void calculate_chips() {
		int dealervalue=0;
		ArrayList<Card> dealerCard = new ArrayList<Card>();
		dealerCard.add(deck.getOneCard(true));
		dealerCard.add(deck.getOneCard(false));
		for (Card c : dealerCard) {// dealerCard這組排變成一張一張的card
			c.printCard();// print player1所有的排
		}
		dealervalue=((Person) dealerCard).getTotalValue();
		System.out.println("Dealer's card value is "+dealervalue+" ,Cards:"+c);
		}

	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	

}
