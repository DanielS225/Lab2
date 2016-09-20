package pokerBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;
//THIS IS THE HARDEST PART
public class Hand {
//sort hand first
	
	private ArrayList<Card> CardsInHand = new ArrayList<Card>();
	private boolean bScored;
	private HandScore score;
	
	public Hand() {
		
	}
	
	public void setHandScore(HandScore score) {
		this.score = score;
		this.bScored = true;
	}
	
	public HandScore getHandScore() {
		return score;
	}
	
	public void evalHand() {
		//Collections.sort(CardsInHand);TODO populate hand, how does it sort (ascending or descending)?
	}

	//public Handscore 
}
