/**
* @author : Team 11
* This is a child class of the BankAccount class.
* Modified March 9, 2017 9:00pm
*
*/

// For the pre-questions 1(both) 2(both) 3(savings) 4(savings??)
// 5(savings) 6(both) Double check!


class SavingsAccount extends BankAccount {

  private double interestRate = 0.07;
  private double minimumBalance = 1000.00;

  public SavingsAccount(){
    super();
  }

  public SavingsAccount(SavingsAccount aSavingsAccount){
    //this(aSavingsAccount.getBalance());
    super(aSavingsAccount);
    interestRate = aSavingsAccount.interestRate;

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

  public void withdraw(double amount){
    if ((getBalance()-amount) < minimumBalance){
    }else {
      super.withdraw(amount);
    }
  }
}
