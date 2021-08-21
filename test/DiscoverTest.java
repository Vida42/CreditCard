import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interest.Card;
import interest.Discover;
import interest.Type;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Discover class.
 */
public class DiscoverTest {

  private Card card0;

  /**
   * Construct a Discover object for test.
   */
  @Before
  public void setUp() {
    card0 = new Discover(Type.DISCOVER, 100);
  }

  /**
   * Tests a Discover object to make sure it's properly constructed.
   */
  @Test
  public void testDiscover() {
    try {
      new Discover(Type.DISCOVER, 0);
      new Discover(Type.DISCOVER, -100);
      new Discover(Type.DISCOVER, 200);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Tests getType method.
   */
  @Test
  public void testGetType() {
    assertEquals(Type.DISCOVER, card0.getType());
  }

  /**
   * Tests getBalance method.
   */
  @Test
  public void testGetBalance() {
    assertEquals(100, card0.getBalance());
  }

  /**
   * Tests setBalance method.
   */
  @Test
  public void testSetBalance() {
    card0.setBalance(200);
    assertEquals(200, card0.getBalance());
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
    assertEquals(1, card0.getInterest());
  }

  /**
   * Tests the Discover constructor to make sure that it throws an
   * IllegalArgumentException when the type is not one Discover type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidType() {
    new Discover(Type.MC, 100);
  }
}
