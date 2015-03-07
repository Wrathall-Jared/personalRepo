import static org.junit.Assert.*;

import org.junit.Test;


public class BankAccountTest {

	@Test
	public void testDeposit() {
		
		// create a BankAccount class instance
		BankAccount account = new BankAccount();
		
		// deposit $50
		account.deposit(50);
		
		// did the deposit go through?
		assertEquals(account.getBalance(), 50);
		
		
	}
	
	@Test
	public void testWithdraw() {
		
		// create a BankAccount class instance
		BankAccount account = new BankAccount(75);
		
		
		// withdraw $50
		account.withdraw(50);
		
		// did the withdraw work?
		assertEquals(account.getBalance(), 25);
		
	}
	
	@Test
	public void testWithdrawWithPenalty() {
		
		// create a BankAccount class instance
		BankAccount account = new BankAccount(10);
		
		
		// withdraw $30
		account.withdraw(20);
		
		// did the withdraw work with charge?
		assertEquals(account.getBalance(), -15);
		
	}

}
