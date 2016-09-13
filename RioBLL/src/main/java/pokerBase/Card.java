package pokerBase;

import java.util.Comparator;

public class Card {

	private int iCardNbr;
	private int iCardSuit;
	private int iCardRank; 
	
	//TODO should these be private methods?
	public Card(int iCardNbr, int iCardSuit, int iCardRank) {
		this.iCardNbr = iCardNbr;
		this.iCardSuit = iCardSuit;
		this.iCardRank = iCardSuit;
	}
	
	public int getiCardNbr() {
		return iCardNbr;
	}
	
	public int getiCardSuit() {
		return iCardSuit;
	}
	
	public int getiCardRank() {
		return iCardRank;
	}
	
}