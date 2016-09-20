package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

public class Deck  {
	
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck() {
		for (int x = 1; x <= 13; x++) {
			for (int y = 1; y <= 4; y++) {
				DeckCards.add(new Card(x,y,x*y));//add card to deck where new card has a rank of x (1-13), suit y (1-4), and number x*y (1-52)
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
