package pokerBase;

import java.util.Comparator;
import pokerEnums.eSuit;
import pokerEnums.eRank;

public class Card {

	private int iCardNbr;
	private eSuit iCardSuit;
	private eRank iCardRank; 
	
	public Card(eRank iCardRank, eSuit iCardSuit, int iCardNbr) {
		this.iCardRank = iCardRank;
		this.iCardSuit = iCardSuit;
		this.iCardNbr = iCardNbr;
	}
	
	public int getiCardNbr() {
		return iCardNbr;
	}
	
	public eSuit geteSuit() {
		return iCardSuit;
	}
	
	public eRank geteRank() {
		return iCardRank;
	}
	
	public int compareTo(Object o) {
		Card c = (Card) o;
		return c.geteRank().compareTo(this.geteRank());
	}
	
}