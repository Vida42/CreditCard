import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interest.Card;
import interest.MC;
import interest.Type;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the MC class.
 */
public class MCTest {

  private Card card0;

  /**
   * Construct a MC object for test.
   */
  @Before
  public void setUp() {
    card0 = new MC(Type.MC, 40);
  }

  /**
   * Tests a MC object to make sure it's properly constructed.
   */
  @Test
  public void testMC() {
    try {
      new MC(Type.MC, 0);
      new MC(Type.MC, -100);
      new MC(Type.MC, 200);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Tests getType method.
   */
  @Test
  public void testGetType() {
    assertEquals(Type.MC, card0.getType());
  }

  /**
   * Tests getBalance method.
   */
  @Test
  public void testGetBalance() {
    assertEquals(40, card0.getBalance());
  }

  /**
   * Tests setBalance method.
   */
  @Test
  public void testSetBalance() {
    card0.setBalance(300);
    assertEquals(300, card0.getBalance());
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
    assertEquals(2, card0.getInterest());
  }

  /**
   * Tests the MC constructor to make sure that it throws an
   * IllegalArgumentException when the type is not one MC type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidType() {
    new MC(Type.DISCOVER, 100);
  }
}
