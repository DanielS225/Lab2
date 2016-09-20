package pokerBase;

import java.util.*;
/*import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;*/

//THIS IS THE HARDEST PART
public class Hand {
//sort hand first
	
	private ArrayList<Card> CardsInHand = new ArrayList<Card>();
	private UUID handID = UUID.randomUUID();
	private boolean bScored;
	private HandScore score;
	
	public Hand() {
		//what does this do?
	}
	
	private void setHandScore(HandScore score) {
		this.score = score;
		this.bScored = true;
	}
	
	public HandScore getHandScore() {
		return score;
	}
	
	private void evalHand() {
		//TODO populate hand, how does it sort (ascending or descending)?
		Collections.sort(CardsInHand);
		
	}
}
