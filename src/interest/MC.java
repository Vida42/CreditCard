package interest;

/**
 * This class represents a MC card.
 */
public class MC extends AbstractCard {
  /**
   * Constructs a MC object. And initializes it to the given type and balance.
   *
   * @param type      the type of this card
   * @param balance  the balance of this card
   */
  public MC(Type type, int balance) {
    super(type, balance);
    if (!(this.type == Type.MC)) {
      throw new IllegalArgumentException("Type of MC should be MC");
    }
  }

  @Override
  public void calculateInterest() {
    super.interest = (int) (super.balance * 0.05);
  }
}
