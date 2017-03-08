/**
* @author : Team 11
* This is a child class of the BankAccount class.
*/
public class ChequingAccount extends BankAccount {
  private double minBalance = 500;
  private double penaltyRate = 0.1;

  /**
  * This method checks account balance and if low than $500 withdrwas the penalty
  */
  public void withdrawPenalty() {
    if (getBalance()<500) {
      withdraw(getBalance()*penaltyRate);
    }
  }
}
