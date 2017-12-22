import java.util.ArrayList;

public class Player extends Person{//player�~��person,�~�Ӫ������O�u�n�ŧi�̦�abstract�N������@

	private String name; // ���a�m�W
	private int chips; // ���a�����w�X
	private int bet;// ���a�����U�`���w�X
	private ArrayList<Card> oneRoundCard = new ArrayList<Card>();// ���P�����d//<Card>��ƧκA�n��

	public Player(String name, int chips) {
		// Player constructor�A�s�WPlayer����ɡA�ݭn�m�W�B�֦����w�X����ӰѼ�
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

	public void setOneRoundCard(ArrayList cards) {// �]�w���P���ұo�쪺�d setter
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
		// ���aSay Hello
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");

	}

	public int makeBet() {
		// TODO Auto-generated method stub
		// �U�`�A�^�ǹw�p�U�`���w�X
		// �򥻤U�`�G�@��1��
		// �p
		// bet=1;
		// return bet;
		// �`�N�G�n�ˬd�O�_�٦����A�S���F�N����A�~��U�`
		bet = 1;
		if (chips <= 0) {
			bet = 0;
		}

		return bet;
	}

//	public boolean hitMe() {
//		// TODO Auto-generated method stub
//		// �O�_�n�P�A�O�^��true�A���A�n�P�h�^��false
//		// �򥻰Ѧұ���G16�I�H�U�n�P�A17�I�H�W���n�P
//		// ���ܡG��oneRoundCard�Ӻ�
//		int c1 = 0;// �]�i�H�g�b�̥~��"�����ܼ�"�N���Τ@��int
//		for (int i = 0; i < oneRoundCard.size(); i++) {
//			c1 += oneRoundCard.get(i).getRank();// oneRoundCard����˪F��Suit
//												// rank//��c1�C�����[�_��
//		}
//		if (c1 < 16) {
//			return true;
//		} else {
//			return false;
//		}

//	}

//	public int getTotalValue() {
//		// TODO Auto-generated method stub
//		// �^�Ǧ��P���ұo���d�I�ƥ[�`
//		/* 
//		 * A�i�@�@�I�ΤQ�@�I�A
//		 * 2-10�@�ӵP���I�ơA
//		 * J�BQ�BK�@10�I
//		 */
//		int c1 = 0;
//		for (int i = 0; i < oneRoundCard.size(); i++) {
//			if(oneRoundCard.get(i).getRank()==11 ||
//					oneRoundCard.get(i).getRank()==12||
//					oneRoundCard.get(i).getRank()==13){
//				oneRoundCard.get(i).setRank(10);
//			}
//			c1 += oneRoundCard.get(i).getRank();// oneRoundCard����˪F��Suit
//												// rank//��c1�C�����[�_��
//		}
//		return c1;
//	}

	public void increaseChips(int p1Bet) {
		// TODO Auto-generated method stub
		// �^�Ǫ��a�{���w�X
		setChips(getChips() - p1Bet);// �γ]�w���w�X���w�X����`

	}

	public int getCurrentChips() {
		// TODO Auto-generated method stub
		return getChips();// ��������X�Ӫ��ȷ|�@���ܰ�

	}

	@Override
	public boolean hit_me(Table table) {
		// TODO Auto-generated method stub
		return false;
	}
}