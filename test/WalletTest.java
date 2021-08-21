import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interest.Card;
import interest.Discover;
import interest.Type;
import interest.Visa;
import interest.Wallet;
import interest.WalletImpl;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Wallet class.
 */
public class WalletTest {
  private Wallet wallet0;
  private Card card0;

  /**
   * Construct a Wallet object for test.
   */
  @Before
  public void setUp() {
    wallet0 = new WalletImpl();
    card0 = new Visa(Type.VISA, 100);
  }

  /**
   * Tests a Wallet object to make sure it's properly constructed.
   */
  @Test
  public void testWallet() {
    try {
      new WalletImpl();
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Tests getCard method.
   */
  @Test
  public void testGetCard() {
    assertEquals(null, wallet0.getCard(0));
  }

  /**
   * Tests getCardList method.
   */
  @Test
  public void testGetCardList() {
    assertEquals(0, wallet0.getCardList().size());
  }

  /**
   * Tests addCard method.
   */
  @Test
  public void testAddCard() {
    assertEquals(0, wallet0.getCardList().size());
    wallet0.addCard(card0);
    assertEquals(1, wallet0.getCardList().size());
    assertEquals(Type.VISA, wallet0.getCard(0).getType());
    assertEquals(10, wallet0.getCard(0).getInterest());
  }

  /**
   * Tests getTotalInterest method.
   */
  @Test
  public void testGetTotalInterest() {
    assertEquals(0, wallet0.getTotalInterest());
    wallet0.addCard(card0);
    assertEquals(10, wallet0.getTotalInterest());
  }

  /**
   * Tests getNumberOfCards method.
   */
  @Test
  public void testGetNumberOfCards() {
    assertEquals(0, wallet0.getNumberOfCards());
    wallet0.addCard(card0);
    assertEquals(1, wallet0.getNumberOfCards());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidIndex() {
    wallet0 = new WalletImpl();
    wallet0.getCard(-1);
  }
}
