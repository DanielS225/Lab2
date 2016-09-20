package pokerBase;

import java.util.ArrayList;
import java.util.Collections;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck  {
	
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck() {
		int iCardNum = 1;
		for (eRank eRank : eRank.values()) {
				for (eSuit eSuit : eSuit.values()) {
					DeckCards.add(new Card(eRank, eSuit, iCardNum++));//add card to deck where new card has a rank of x (1-13), suit y (1-4), and number x*y (1-52)
			}
		}
		Collections.shuffle(DeckCards);
	}
	
	public Card drawCard() {
		return DeckCards.remove(0);
	}
	
	public ArrayList<Card> getDeckCards() {
		return DeckCards;
	}
	
	private int getDeckSize() {
		return DeckCards.size();
	}
}
