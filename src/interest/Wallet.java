package interest;

import java.util.List;

/**
 * This interface contains all operations that a wallet should support.
 */
public interface Wallet {
  /**
   * Return card having this index.
   *
   * @param index index user input
   * @return card in this index
   */
  Card getCard(int index);

  /**
   * Return List of card.
   *
   * @return list of card
   */
  List<Card> getCardList();

  /**
   * Add a card into wallet.
   *
   * @param card card want to add
   */
  void addCard(Card card);

  /**
   * Get current interest of wallet.
   *
   * @return current interest of wallet
   */
  int getTotalInterest();

  /**
   * Get current number of cards of wallet.
   *
   * @return current number of cards of wallet
   */
  int getNumberOfCards();
}
