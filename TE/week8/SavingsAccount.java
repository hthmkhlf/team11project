/**
* @author : Team 11
* This is a child class of the BankAccount class.
*
*/
class SavingsAccount extends BankAccount {

  double interestRate = 0.07;

  /**
  * This method sets the interest rate.
  * @param anInterest it is a new interest value between 0 and 1.
  */
  public void setInterestRate(double anInterest) {
    if (anInterest >=0 && anInterest <=1) {
      interestRate = anInterest;
    }
  }

  /**
  * Calculate interest
  * Simple interest formula: principal x rate
  */

  public void addInterest() {
    double userMoney = getBalance()*interestRate;
    deposit(userMoney);
  }
}
