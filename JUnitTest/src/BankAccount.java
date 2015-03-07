
public class BankAccount {

	private int balance;

	public BankAccount(int i) {
		// TODO Auto-generated constructor stub
		balance = i;
	}

	public BankAccount() {
		// TODO Auto-generated constructor stub
		balance = 0;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int amount) {
		// TODO Auto-generated method stub
		setBalance(getBalance() + amount);
		
	}

	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		setBalance(getBalance() - amount);
		
		if (balance < 0){
			balance -= 5;
		}
		
	}

}
