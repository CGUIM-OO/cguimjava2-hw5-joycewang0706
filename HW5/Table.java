import java.util.ArrayList;

class Table {
	/*
	 * �s�WClass field, final, int, MAXPLAYER = 4
	 * 
	 * �̦h�@�i�P��৤�X�ӤH
	 */
	private static final int MAXPLAYER = 4;// ���γ�������
	private static Deck deck;// �s��Ҧ����P
	private static ArrayList<Player> players;// �s��Ҧ������a
	private static Dealer dealer;// �s��@�Ӳ��a
	private static ArrayList<Integer> pos_betArrary;// �s��C�Ӫ��a�b�@���U���`(instance
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
	 * �s�W int[] pos_betArray�A�s��C�Ӫ��a�b�@���U���`(instance field)
	 */
	// public static void pos_betArrary(){
	// int pos_betArrary=0;
	// pos_betArrary=player1.get(makeBet());
	// }
	/*
	 * ��J�ѼƬ� int nDeck �бNDeck class����ơA�æs�J�W�z�s�W��Deck�ܼ�(instance field) �s�W
	 * �Ъ�l�ƤW�z�s�W���O��Player[]���ܼ�(instance field) �ŧi�@�Ӫ��׬OMAXPLAYER ��Player array
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
	 * �ШC�Ӫ��a���۩I (���� say_hello()) �ШC�Ӫ��a�U�` (���� make_bet())
	 * �C�Ӫ��a�U���`�n�s�bpos_betArray�Ѥ���ϥ�
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
		 * �o�P�����a����a�A���o��i���}���P �����a�A�@�i�\�۪��P�A�H�Τ@�i���}���P�����a
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
		for (Card c : dealerCard) {// dealerCard�o�ձ��ܦ��@�i�@�i��card
			c.printCard();// print player1�Ҧ�����
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
	 * �NDealer���P��W(�N�Y�NDealer��� ���O��Dealer ���ܼ�(instance field) ���A���ܼƤ�setter)�C
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
					c.printCard();// print player1�Ҧ�����
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
		for (Card c : dealerCard) {// dealerCard�o�ձ��ܦ��@�i�@�i��card
			c.printCard();// print player1�Ҧ�����
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
		for (Card c : dealerCard) {// dealerCard�o�ձ��ܦ��@�i�@�i��card
			c.printCard();// print player1�Ҧ�����
		}
		dealervalue=((Person) dealerCard).getTotalValue();
		System.out.println("Dealer's card value is "+dealervalue+" ,Cards:"+c);
		}

	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	

}
