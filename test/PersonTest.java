import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import interest.Type;
import interest.Card;
import interest.Discover;
import interest.Visa;
import interest.MC;
import interest.Wallet;
import interest.WalletImpl;
import interest.Person;
import interest.PersonImpl;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {
  private Person person0;
  private Wallet wallet0;
  private Card card0;

  /**
   * Construct a Person object for test.
   */
  @Before
  public void setUp() {
    person0 = new PersonImpl();
    wallet0 = new WalletImpl();
    card0 = new Visa(Type.VISA, 100);
  }

  /**
   * Tests a Person object to make sure it's properly constructed.
   */
  @Test
  public void testWallet() {
    try {
      new PersonImpl();
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  /**
   * Tests getWallet method.
   */
  @Test
  public void testGetWallet() {
    assertEquals(null, person0.getWallet(0));
  }

  /**
   * Tests getWalletList method.
   */
  @Test
  public void testGetWalletList() {
    assertEquals(0, person0.getWalletList().size());
  }

  /**
   * Tests addWallet method.
   */
  @Test
  public void testAddWallet() {
    assertEquals(0, person0.getWalletList().size());
    wallet0.addCard(card0);
    person0.addWallet(wallet0);
    assertEquals(1, person0.getWalletList().size());
    assertEquals(1, person0.getWallet(0).getNumberOfCards());
    assertEquals(10, person0.getWallet(0).getTotalInterest());
  }

  /**
   * Tests getTotalInterest method.
   */
  @Test
  public void testGetTotalInterest() {
    assertEquals(0, person0.getTotalInterest());
    wallet0.addCard(card0);
    person0.addWallet(wallet0);
    assertEquals(10, person0.getWallet(0).getTotalInterest());
  }

  /**
   * Tests getNumberOfWallets method.
   */
  @Test
  public void testGetNumberOfWallets() {
    assertEquals(0, person0.getNumberOfWallets());
    person0.addWallet(wallet0);
    assertEquals(1, person0.getNumberOfWallets());
  }

  /**
   * Tests getNumberOfCards method.
   */
  @Test
  public void testGetNumberOfCards() {
    assertEquals(0, person0.getNumberOfCards());
    wallet0.addCard(card0);
    person0.addWallet(wallet0);
    assertEquals(1, person0.getNumberOfCards());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidIndex() {
    person0 = new PersonImpl();
    person0.getWallet(-1);
  }

  /**
   * Tests customised example1.
   */
  @Test
  public void testCustomised1() {
    Card card1 = new Visa(Type.VISA, 100);
    Card card2 = new MC(Type.MC, 100);
    Card card3 = new Discover(Type.DISCOVER, 100);
    Wallet wallet1 = new WalletImpl();
    wallet1.addCard(card1);
    wallet1.addCard(card2);
    wallet1.addCard(card3);
    Person person1 = new PersonImpl();
    person1.addWallet(wallet1);
    assertEquals(16, person1.getTotalInterest());
    assertEquals(10, person1.getWallet(0).getCard(0).getInterest());
    assertEquals(5, person1.getWallet(0).getCard(1).getInterest());
    assertEquals(1, person1.getWallet(0).getCard(2).getInterest());
  }

  /**
   * Tests customised example2.
   */
  @Test
  public void testCustomised2() {
    Card card1 = new Visa(Type.VISA, 100);
    Card card2 = new Discover(Type.DISCOVER, 100);
    Card card3 = new MC(Type.MC, 100);
    Wallet wallet1 = new WalletImpl();
    Wallet wallet2 = new WalletImpl();
    wallet1.addCard(card1);
    wallet1.addCard(card2);
    wallet2.addCard(card3);
    Person person1 = new PersonImpl();
    person1.addWallet(wallet1);
    person1.addWallet(wallet2);
    assertEquals(16, person1.getTotalInterest());
    assertEquals(11, person1.getWallet(0).getTotalInterest());
    assertEquals(5, person1.getWallet(1).getTotalInterest());
  }

  /**
   * Tests customised example3.
   */
  @Test
  public void testCustomised3() {
    Card card1 = new Visa(Type.VISA, 100);
    Card card2 = new MC(Type.MC, 100);
    Wallet wallet1 = new WalletImpl();
    Wallet wallet2 = new WalletImpl();
    wallet1.addCard(card1);
    wallet1.addCard(card2);
    wallet2.addCard(card1);
    wallet2.addCard(card2);
    Person person1 = new PersonImpl();
    Person person2 = new PersonImpl();
    person1.addWallet(wallet1);
    person2.addWallet(wallet2);
    assertEquals(15, person1.getTotalInterest());
    assertEquals(15, person2.getTotalInterest());
    assertEquals(15, person1.getWallet(0).getTotalInterest());
    assertEquals(15, person2.getWallet(0).getTotalInterest());
  }
}
