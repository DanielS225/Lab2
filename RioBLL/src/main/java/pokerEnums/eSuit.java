package pokerEnums;

public enum eSuit {
	
	HEARTS(1), SPADES(2), CLUBS(3), DIAMONDS(4);
	
	private int iSuit;
	
	private eSuit(int iSuit) {
		this.iSuit = iSuit;
	}
	
	public int getiSuit() {
		return iSuit;
	}
}
