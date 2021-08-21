package interest;

/**
 * This interface contains all operations that Card should support.
 */
public interface Card {
  /**
   * Get the type of this card.
   *
   * @return the type of this card
   */
  public Type getType();

  /**
   * Get the balance of this card.
   *
   * @return the balance of this card
   */
  public int getBalance();

  /**
   * Set balance of this card.
   *
   * @param money money want to set
   */
  void setBalance(int money);

  /**
   * Get the interest of this card.
   *
   * @return the interest of this card
   */
  public int getInterest();

  /**
   * Calculate interest of this card.
   */
  void calculateInterest();
}
