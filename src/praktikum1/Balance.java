package praktikum1;

import java.io.Serializable;

public class Balance implements Serializable {

	private int accountNumber;
	private int balance;

	public Balance(int balance, int accountNumber) {
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
}
