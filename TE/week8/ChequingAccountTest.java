import static org.junit.Assert.*;

import org.junit.Test;

public class ChequingAccountTest {
        
    private static int accountCounter = 0;
    
	@Test
    public void test_withdrawPenalty_500balance() {
        ChequingAccount b1 = new ChequingAccount();
		b1.deposit(500.0);
        b1.withdrawPenalty();
        accountCounter++;
        assertEquals(500.0, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdrawPenalty_501Balance() {
        ChequingAccount b1 = new ChequingAccount();
		b1.deposit(501.0);
        b1.withdrawPenalty();
        accountCounter++;
        assertEquals(501.0, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdrawPenalty_499Balance() {
        ChequingAccount b1 = new ChequingAccount();
		b1.deposit(499.0);
        b1.withdrawPenalty();
        accountCounter++;
        assertEquals(449.10, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdrawPenalty_ZeroBalance() {
        ChequingAccount b1 = new ChequingAccount();
        b1.withdrawPenalty();
        accountCounter++;
        assertEquals(0.0, b1.getBalance(),0.00001);
    }
    
	@Test
    public void test_withdrawPenalty_10Balance() {
        ChequingAccount b1 = new ChequingAccount();
		b1.deposit(10.0);
        b1.withdrawPenalty();
        accountCounter++;
        assertEquals(9.0, b1.getBalance(),0.00001);
    }
}
