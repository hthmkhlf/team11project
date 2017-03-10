/**
* @author : Team 11
* This is a child class of the BankAccount class.
* Modified March 9, 2017 9:00pm
*
*/
class SavingsAccount extends BankAccount {

  double interestRate = 0.07;

  public SavingsAccount(){
    super();
  }

  public SavingsAccount(SavingsAccount aSavingsAccount){
    this(aSavingsAccount.getBalance());

  }

  public SavingsAccount(double aBalance){
    super(aBalance);
  }

  public SavingsAccount(double aBalance, double newInterestRate){
    this(aBalance);
    interestRate = newInterestRate;
  }

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
