package interest;

/**
 * This class represents a discover card.
 */
public class Discover extends AbstractCard {
  /**
   * Constructs a Discover object. And initializes it to the given type and balance.
   *
   * @param type    the type of this card
   * @param balance the balance of this card
   */
  public Discover(Type type, int balance) {
    super(type, balance);
    if (!(this.type == Type.DISCOVER)) {
      throw new IllegalArgumentException("Type of Discover should be DISCOVER");
    }
  }

  @Override
  public void calculateInterest() {
    super.interest = (int) (super.balance * 0.01);
  }
}