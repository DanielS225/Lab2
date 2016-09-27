package pokerBase;

import java.util.ArrayList;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand {
	
	private ArrayList<Card> CardsInHand;

	private ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}

	private static boolean isHandFlush(ArrayList<Card> cards) {
		
		boolean bIsFlush = false;
		if ((cards.get(eCardNo.FirstCard.getCardNo()).geteSuit() == cards.get(eCardNo.SecondCard.getCardNo())
				.geteSuit()) && (cards.get(eCardNo.FirstCard.getCardNo()).geteSuit() == cards.get(eCardNo.ThirdCard
						.getCardNo()).geteSuit()) && (cards.get(eCardNo.FirstCard.getCardNo()).geteSuit() == cards
						.get(eCardNo.FourthCard.getCardNo()).geteSuit()) && (cards.get(eCardNo.FirstCard.getCardNo())
								.geteSuit() == cards.get(eCardNo.FifthCard.getCardNo()).geteSuit())) {
			
			bIsFlush = true;
		}
		
		return bIsFlush;
	}

	private static boolean isHandStraight(ArrayList<Card> cards) {
		
		boolean bIsStraight = false;
		if ((((cards.get(eCardNo.FirstCard.getCardNo()).geteRank()).getiRankNbr() - 1) == cards.get(eCardNo.SecondCard.getCardNo())
				.geteRank().getiRankNbr()) && (((cards.get(eCardNo.SecondCard.getCardNo()).geteRank()).getiRankNbr() - 1) == cards
				.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr()) && (((cards.get(eCardNo.ThirdCard.getCardNo())
						.geteRank()).getiRankNbr() - 1) == cards.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr()) && (((cards
								.get(eCardNo.FourthCard.getCardNo()).geteRank()).getiRankNbr() - 1) == cards.get(eCardNo.FifthCard.getCardNo())
								.geteRank().getiRankNbr())){
			bIsStraight = true;
		}
		return bIsStraight;
	}

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {
		
		boolean isRoyalFlush = false;
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == eRank.ACE) {//if highest card is an ace, 
			if ((Hand.isHandStraight(h.getCardsInHand()) == true) && (Hand.isHandFlush(h.getCardsInHand()) == true)) {//and it is a straight flush
				isRoyalFlush = true;//it is a royal flush
				hs.setHandStrength(eHandStrength.RoyalFlush.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(0);
				hs.setKickers(null);//no kickers
			}
		}
		return isRoyalFlush;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		
		boolean isStraightFlush = false;
		if ((Hand.isHandStraight(h.getCardsInHand()) == true) && (Hand.isHandFlush(h.getCardsInHand()) == true)) {
			isStraightFlush = true;
			hs.setHandStrength(eHandStrength.StraightFlush.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			hs.setKickers(null);//no kickers
		}
		return isStraightFlush;
	}

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {

		boolean bHandCheck = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
			
		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return bHandCheck;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {

		boolean isFullHouse = false;
		
		if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) && ((h.getCardsInHand()
						.get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank()))) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setKickers(null);//no kickers

		} else if ((h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) && ((h.getCardsInHand()
						.get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank()))) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setKickers(null);//no kickers
			
		}
		return isFullHouse;

	}

	public static boolean isHandFlush(Hand h, HandScore hs) {
		
		boolean bIsFlush = false;
		if (Hand.isHandFlush(h.getCardsInHand()) == true) {
			bIsFlush = true;
			hs.setHandStrength(eHandStrength.Flush.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return bIsFlush;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {

		boolean bIsStraight = false;
		if (Hand.isHandStraight(h.getCardsInHand()) == true) {
			bIsStraight = true;
			hs.setHandStrength(eHandStrength.Straight.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			hs.setKickers(null);//no kickers
		}
		return bIsStraight;
	}

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {
		
		boolean isThreeOfAKind = false;
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()//first three of a kind
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) {//kickers are last two
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()//middle three of a kind
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {//kickers are first and last
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()//last three of a kind
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {//kickers are first two
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return isThreeOfAKind;
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {
		
		boolean isTwoPair = false;
		if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()//first two pairs
				.get(eCardNo.SecondCard.getCardNo()).geteRank()) && (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo())
						.geteRank() == h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank())) {//kicker at end
			isTwoPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() > 
					h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr()) {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			}
			else {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			}
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if ((h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()// first and last two pairs
				.get(eCardNo.SecondCard.getCardNo()).geteRank())
				&& (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.FifthCard.getCardNo()).geteRank())) {// kicker in middle
			isTwoPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() > h.getCardsInHand()
					.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr()) {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			} else {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			}
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			hs.setKickers(kickers);

		} else if ((h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()//last two pairs
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) && (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo())
						.geteRank() == h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank())) {//kicker at end
			isTwoPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr() > h.getCardsInHand()
					.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr()) {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			} else {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			}
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);

		}
		return isTwoPair;
	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		boolean isPair = false;
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()//first pair
				.get(eCardNo.SecondCard.getCardNo()).geteRank())  {//kickers at end
			isPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()//second pair
				.get(eCardNo.ThirdCard.getCardNo()).geteRank())  {//kicker at beginning, two kickers at end
			isPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()//third pair
				.get(eCardNo.FourthCard.getCardNo()).geteRank())  {//two kickers at beginning, one kicker at end
			isPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()//last pair
				.get(eCardNo.FifthCard.getCardNo()).geteRank())  {//kickers at beginning
			isPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			hs.setKickers(kickers);

		}
		return isPair;
	}

	public static boolean isHandHighCard(Hand h, HandScore hs) {
		
		hs.setHandStrength(eHandStrength.HighCard.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
		hs.setLoHand(0);
		ArrayList<Card> kickers = new ArrayList<Card>();
		kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
		kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
		hs.setKickers(kickers);
		return true;
	}
}
