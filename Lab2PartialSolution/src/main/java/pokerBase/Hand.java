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

		// TODO Implement this method
		boolean bIsFlush = false;
		return bIsFlush;
	}

	private static boolean isStraight(ArrayList<Card> cards, Card highCard) {
		boolean bIsStraight = false;
		// TODO Implement this method

		return bIsStraight;
	}

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {

		boolean isRoyalFlush = false;
		// TODO Implement this method
		return isRoyalFlush;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		boolean isRoyalFlush = false;
		// TODO Implement this method
		return isRoyalFlush;
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
		// TODO Implement this method
		return isFullHouse;

	}

	public static boolean isHandFlush(Hand h, HandScore hs) {

		boolean bIsFlush = false;
		// TODO Implement this method
		return bIsFlush;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {

		boolean bIsStraight = false;
		// TODO Implement this method
		return bIsStraight;
	}

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {

		boolean isThreeOfAKind = false;
		// TODO Implement this method
		return isThreeOfAKind;
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {

		boolean isTwoPair = false;
		// TODO Implement this method
		return isTwoPair;
	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		boolean isPair = false;
		// TODO Implement this method
		return isPair;
	}

	public static boolean isHandHighCard(Hand h, HandScore hs) {
		// TODO Implement this method
		return true;
	}
}
