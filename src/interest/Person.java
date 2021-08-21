package interest;

import java.util.List;

/**
 * This interface contains all operations that a person should support.
 */
public interface Person {
  /**
   * Return wallet having this index.
   *
   * @param index index user input
   * @return wallet in this index
   */
  Wallet getWallet(int index);

  /**
   * Return List of wallet.
   *
   * @return list of wallet
   */
  List<Wallet> getWalletList();

  /**
   * Add a wallet to person.
   *
   * @param wallet wallet want to add
   */
  void addWallet(Wallet wallet);

  /**
   * Get current interest of person.
   *
   * @return current interest of person
   */
  int getTotalInterest();

  /**
   * Get current number of wallets.
   *
   * @return current number of wallets
   */
  int getNumberOfWallets();

  /**
   * Get current number of cards for person.
   *
   * @return current number of cards for person.
   */
  int getNumberOfCards();
}
