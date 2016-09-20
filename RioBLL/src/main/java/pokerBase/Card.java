package pokerBase;

import java.util.Comparator;

public class Card {

	private int iCardNbr;
	private int iCardSuit;
	private int iCardRank; 
	
	public Card(int iCardRank, int iCardSuit, int iCardNbr) {
		this.iCardRank = iCardRank;
		this.iCardSuit = iCardSuit;
		this.iCardNbr = iCardNbr;
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
	
	@Override
	public int compareTo(Object arg0) {
		Card c = (Card)arg0;
		return c.iCardRank - this.iCardRank;
	}
	
}