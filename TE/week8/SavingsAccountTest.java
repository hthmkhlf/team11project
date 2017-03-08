import static org.junit.Assert.*;

import org.junit.Test;

public class SavingsAccountTest {
        
    private static int accountCounter = 0;

    
	@Test
    public void test_toString() {
        SavingsAccount b = new SavingsAccount();
        accountCounter++;
        assertEquals(accountCounter + ",0.00", b.toString());
    }
    
	@Test
    public void test_equals() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(10.50);
        SavingsAccount b2 = new SavingsAccount();
        b2.deposit(10.50);
        accountCounter += 2;
        assertEquals("They have different account numbers, so should be considered unequal", 
                                false,b1.equals(b2));
    }
    
	@Test
    public void test_deposit() {
        SavingsAccount b = new SavingsAccount();
        accountCounter++;
        b.deposit(10.0);
        assertEquals("Unexpected balance", 10.0,b.getBalance(),0.00001);
    }
    
	@Test
    public void test_deposit_multipleCalls() {
        SavingsAccount b = new SavingsAccount();
        accountCounter++;
        b.deposit(5.00);
        b.deposit(4.56);
        b.deposit(11.90);
        b.deposit(16.00);
        assertEquals("Unexpected balance", 37.46, b.getBalance(),0.00001);
    }
    
	@Test
    public void test_deposit_negativeAmount() {
        SavingsAccount b = new SavingsAccount();
        accountCounter++;
        b.deposit(-12.45);
        assertEquals("Unexpected balance", 0.0,b.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdraw() {
        SavingsAccount b = new SavingsAccount();
        b.deposit(20.0);
        accountCounter++;
        b.withdraw(15.50);
        assertEquals("Unexpected balance", 4.50,b.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdraw_moreThanAvailable() {
        SavingsAccount b = new SavingsAccount();
        b.deposit(15.0);
        accountCounter++;
        b.withdraw(20.0);
        assertEquals("Unexpected balance", 15.00,b.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdraw_entireBalance() {
        SavingsAccount b = new SavingsAccount();
        b.deposit(5.0);
        accountCounter++;
        b.withdraw(5.00);
        assertEquals("Unexpected balance", 0.00,b.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdraw_sequenceOfWithdraws() {
        SavingsAccount b = new SavingsAccount();
        b.deposit(50.0);
        accountCounter++;
        b.withdraw(.5);
        b.withdraw(5.1);
        b.withdraw(20.0);
        assertEquals("Unexpected balance", 24.40,b.getBalance(),0.00001);
    }
    
	@Test
    public void test_transfer() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(50.0);
        SavingsAccount b2 = new SavingsAccount();
        b2.deposit(546.21);
        accountCounter+=2;
        b1.transfer(15.45,b2);
        assertEquals("Unexpected balance for first account", 34.55,b1.getBalance(),0.00001);
		assertEquals("Unexpected balance for 2nd account", 561.66,b2.getBalance(),0.00001);
    }
    
	@Test
    public void test_transfer_entireBalance() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(50.0);
        SavingsAccount b2 = new SavingsAccount();
        b2.deposit(546.21);
        accountCounter+=2;
        b1.transfer(50.00,b2);
        assertEquals("Unexpected balance for first account", 0.0,b1.getBalance(),0.00001);
		assertEquals("Unexpected balance for 2nd account", 596.21,b2.getBalance(),0.00001);
    }
    
	@Test
    public void test_transfer_moreThanBalance() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(50.0);
        SavingsAccount b2 = new SavingsAccount();
        b2.deposit(546.21);
        accountCounter+=2;
        b1.transfer(51.00,b2);
        assertEquals("Unexpected balance for first account", 50.0,b1.getBalance(),0.00001);
		assertEquals("Unexpected balance for 2nd account", 546.21,b2.getBalance(),0.00001);
    }
    
	@Test
    public void test_addInterest() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(500.0);
        b1.addInterest();
        accountCounter++;
        assertEquals(535.0, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test_addInterest_zeroBalance() {
        SavingsAccount b1 = new SavingsAccount();
        b1.addInterest();
        accountCounter++;
        assertEquals(0.0, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test_setInterestRate_negativeRate() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(500.0);
        b1.setInterestRate(-0.1);
        b1.addInterest();
        accountCounter++;
        assertEquals(535.0, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test_setInterestRate_PositiveRate() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(500.0);
        b1.setInterestRate(0.1);
        b1.addInterest();
        accountCounter++;
        assertEquals(550.0, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test21_setInterestRate_MoreThan100Percent() {
        SavingsAccount b1 = new SavingsAccount();
        b1.deposit(500.0);
        b1.setInterestRate(1.01);
        b1.addInterest();
        accountCounter++;
        assertEquals(535.0, b1.getBalance(),0.00001);
    }
}
