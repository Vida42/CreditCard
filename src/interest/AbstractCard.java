package interest;

/**
 * This abstract class represents an abstract card.
 */
public abstract class AbstractCard implements Card {
  protected Type type;
  protected int balance;
  protected int interest;

  /**
   * Constructs an AbstractCard object. And initializes it to the given type and balance.
   *
   * @param type      the type of this card
   * @param balance  the balance of this card
   */

  public AbstractCard(Type type, int balance) {
    this.type = type;
    this.balance = balance;
    this.interest = 0;
  }

  @Override
  public Type getType() {
    return this.type;
  }

  @Override
  public int getBalance() {
    return this.balance;
  }

  @Override
  public void setBalance(int money) {
    this.balance = money;
  }

  @Override
  public int getInterest() {
    return this.interest;
  }

  @Override
  public void calculateInterest() {
  }
}
