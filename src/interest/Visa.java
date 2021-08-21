package interest;

/**
 * This class represents a visa card.
 */
public class Visa extends AbstractCard {
  /**
   * Constructs an Visa object. And initializes it to the given type and balance.
   *
   * @param type    the type of this card
   * @param balance the balance of this card
   */
  public Visa(Type type, int balance) {
    super(type, balance);
    if (!(this.type == Type.VISA)) {
      throw new IllegalArgumentException("Type of Visa should be VISA");
    }
  }

  @Override
  public void calculateInterest() {
    super.interest = (int) (super.balance * 0.1);
  }
}