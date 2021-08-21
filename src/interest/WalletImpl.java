package interest;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a wallet.
 */
public class WalletImpl implements Wallet {
  private List<Card> cardList;
  private int totalInterest;
  private int numberOfCards;

  /**
   * Constructs a WalletImpl object. And initializes it.
   */
  public WalletImpl() {
    this.cardList = new ArrayList<>();
    this.totalInterest = 0;
    this.numberOfCards = 0;
  }

  @Override
  public Card getCard(int index) {
    if (index < 0) {
      throw new IllegalArgumentException("Index is non-negative.");
    }
    if (this.cardList.isEmpty()) {
      return null;
    }
    return cardList.get(index);
  }

  @Override
  public List<Card> getCardList() {
    return cardList;
  }

  @Override
  public void addCard(Card card) {
    cardList.add(card);
    card.calculateInterest();
    this.totalInterest += card.getInterest();
    this.numberOfCards += 1;
  }

  @Override
  public int getTotalInterest() {
    return totalInterest;
  }

  @Override
  public int getNumberOfCards() {
    return numberOfCards;
  }
}
