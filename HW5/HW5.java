
public class HW5 {
	public static void main(String[] args) {
		Table tbl=new Table(4);
		tbl.set_Player(0, new Player("Palyer 1",300));
		tbl.set_Player(1, new Player("Palyer 2",300));
		tbl.set_Player(2, new Player("Palyer 3",300));
		tbl.set_Player(3, new Player("Palyer 4",300));
		tbl.set_dealer(new Dealer());
		
		tbl.play();
	}
}
