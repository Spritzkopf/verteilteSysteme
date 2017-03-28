package praktikum1;

public class Account {
	private final String customerName;
	private String password;
	private int balance;
	private final int accountNumber;

	public Account(String customerName, String password, int accountNumber) {
		this.password = password;
		this.balance = 0;
		this.customerName = customerName;
		this.accountNumber = accountNumber;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getPassword() {
		return password;
	}

	public int getBalance() {
		return balance;
	}

}
