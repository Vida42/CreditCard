package interest;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a person.
 */
public class PersonImpl implements Person {
  private List<Wallet> walletList;
  private int totalInterest;
  private int numberOfWallets;
  private int numberOfCards;

  /**
   * Constructs a PersonImpl object. And initializes it.
   */
  public PersonImpl() {
    this.walletList = new ArrayList<>();
    this.totalInterest = 0;
    this.numberOfWallets = 0;
    this.numberOfCards = 0;
  }

  @Override
  public Wallet getWallet(int index) {
    if (index < 0) {
      throw new IllegalArgumentException("Index is non-negative.");
    }
    if (this.walletList.isEmpty()) {
      return null;
    }
    return walletList.get(index);
  }

  @Override
  public List<Wallet> getWalletList() {
    return walletList;
  }

  @Override
  public void addWallet(Wallet wallet) {
    walletList.add(wallet);
    this.totalInterest += wallet.getTotalInterest();
    this.numberOfWallets += 1;
    this.numberOfCards += wallet.getNumberOfCards();
  }

  private void checkNew() {
    int tmpNum = 0;
    int tmpInterest = 0;
    for (Wallet each : this.walletList) {
      tmpNum += each.getNumberOfCards();
      tmpInterest += each.getTotalInterest();
    }
    if (tmpNum != this.numberOfCards) {
      this.numberOfCards = tmpNum;
      this.totalInterest = tmpInterest;
    }
  }

  @Override
  public int getTotalInterest() {
    this.checkNew();
    return totalInterest;
  }

  @Override
  public int getNumberOfWallets() {
    return numberOfWallets;
  }

  @Override
  public int getNumberOfCards() {
    this.checkNew();
    return numberOfCards;
  }
}
