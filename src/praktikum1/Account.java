package praktikum1;

public class Account {
	private String customerName;
	private String password;
	private int balance;

	public Account(String password, int balance, String customerName) {
		this.password = password;
		this.balance = balance;
		this.customerName = customerName;
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
