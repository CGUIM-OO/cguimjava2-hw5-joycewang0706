import java.util.ArrayList;
import java.util.Random;

public class Deck {

	
		
			private ArrayList<Card> cards;
			// TODO: Please implement the constructor (30 points)
			ArrayList<Card>usedCard;//�o�X�h���ưO���b
			ArrayList<Card> store;
			private ArrayList<Card> openCard = new ArrayList<Card>();//�s�񦹰ƵP���Ҧ����}���P�A�~�P�ɭn���m
			
			public int nUsed;//�o�F�X�i�P
			public Deck(int nDeck) {
				cards = new ArrayList<Card>();

				for (int i = 1; i <= nDeck; i++) {// �Ĥ@�Ӱj��O�i�H�h�ƵP�A�]�ܼ�i�C�@�}�l���@�ƵP�A�C�C�i�֥[

					for (Card.Suit s:Card.Suit.values()){// 
						for (int rank = 1; rank<= 13; rank++) {// �ĤT�Ӱj��O�P��
							Card card = new Card(s, rank);
							cards.add(card);// �s���d�[��M���
						}
					}
				}shuffle();
				// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
				// Hint: Use new Card(x,y) and 3 for loops to add card into deck
				// Sample code start
				// Card card=new Card(1,1); ->means new card as clubs ace
				// cards.add(card);//�s���d�[��M���
				// Sample code end

}

			
			public void shuffle(){
				store=new ArrayList<Card>();
			    for(int u=0;u<51;u++){
				Random rnd=new Random();
				int j=rnd.nextInt(52-u);//Arrary�O0~51

				store.add(cards.get(j));//�üƩ�X�@�i�s�bstore�̡A����52���N���@�ƵP
				
				cards.remove(cards.get(j));//�üƦ��i���쭫�СA�ҥH�n���L���R��
				//System.out.println(store.size());
			    }
				for(int t=0;t<51;t++){
					cards.add(store.get(t));
				}
				nUsed=0;//�o�F�P�|����i�s�b�̭��A�ҥH�n�k�s
				openCard = new ArrayList<Card>();
			    
			}
			/*
			 * ����@�i�P�A�ק�즳method�A�[�JisOpened�Ѽ�
			 * �A�M�w�o�X�h���P�O�}���٬O�\�_�Ӫ��A�Y�O�}�۪��P�A�[�JopenCard
			 * */
			public Card getOneCard(boolean isOpened){//
				
				Card out=new Card(cards.get(nUsed).getSuit(),cards.get(nUsed).getRank());
				usedCard=new ArrayList<Card>();
				usedCard.add(cards.get(nUsed));//�N�o�X���P�s�busedCard
				if(isOpened==true){
				if(nUsed>=1){//nused�O�X�i�P�A�n�s��i�P
					openCard.add(out);//out�O���쪺�P�A�s�iopenCard�o�� Array
				}
				}
				else{//false
					return out;//��\�۱o�P�s�iplayer ArrayList ��
				}
				nUsed++;//�C��@���[�@
				
				if(nUsed==52){//�n�q�i�ӴN���P�_
				//�ˬd�P�o��
		        
				shuffle();
				nUsed=0;}
				return out;
			}

			// TODO: Please implement the method to print all cards on screen (10
			// points)
			public void printDeck() {

				// Hint: print all items in ArrayList<Card> cards,
				// TODO: please implement and reuse printCard method in Card class (5
				// points)
				int a = cards.size();// �]a���M�椤���j�p�A�o�˴N��O�h�ƵP�]�i�H�M�i�j���
				for (int j = 0; j <= a - 1; j++) {// j�O��l ex:new
													// Card(cards.get(0).getSuit(),
													// cards.get(0).getRank());���X"��"(0,0)�P

					Card card = new Card(cards.get(j).getSuit(), cards.get(j).getRank());// Card�O�U����//card�O�W��
					card.printCard();//�I�s�U����printCard
				}
			}

			public ArrayList<Card> getAllCards() {
				return cards;

	}



			

}