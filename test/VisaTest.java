import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interest.Card;
import interest.Visa;
import interest.Type;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Visa class.
 */
public class VisaTest {

  private Card card0;

  /**
   * Construct a Visa object for test.
   */
  @Before
  public void setUp() {
    card0 = new Visa(Type.VISA, 50);
  }

  /**
   * Tests a Visa object to make sure it's properly constructed.
   */
  @Test
  public void testVisa() {
    try {
      new Visa(Type.VISA, 0);
      new Visa(Type.VISA, -100);
      new Visa(Type.VISA, 200);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Tests getType method.
   */
  @Test
  public void testGetType() {
    assertEquals(Type.VISA, card0.getType());
  }

  /**
   * Tests getBalance method.
   */
  @Test
  public void testGetBalance() {
    assertEquals(50, card0.getBalance());
  }

  /**
   * Tests setBalance method.
   */
  @Test
  public void testSetBalance() {
    card0.setBalance(20);
    assertEquals(20, card0.getBalance());
  }

  /**
   * Tests getInterest method.
   */
  @Test
  public void testGetInterest() {
    assertEquals(0, card0.getInterest());
  }

  /**
   * Tests calculateInterest method.
   */
  @Test
  public void testCalculateInterest() {
    assertEquals(0, card0.getInterest());
    card0.calculateInterest();
    assertEquals(5, card0.getInterest());
  }

  /**
   * Tests the Visa constructor to make sure that it throws an
   * IllegalArgumentException when the type is not one Visa type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidType() {
    new Visa(Type.DISCOVER, 100);
  }
}
