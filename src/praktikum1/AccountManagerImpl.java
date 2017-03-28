package praktikum1;

import java.util.Collection;
import java.util.HashMap;

class AccountManagerImpl implements AccountManager {

	private HashMap<Integer, Account> accounts = new HashMap<>();

	@Override
	public void addAccount(String customerName, String password) {
		Account a = new Account();
	}

	@Override
	public void deposit(String customerName, String password, int amount) throws CustomerClientException {

	}

	@Override
	public void withdraw(String customerName, String password, int amount) throws CustomerClientException {

	}

	@Override
	public Balance getBalance(String customerName, String password, int accountNumber) {
		return null;
	}

	@Override
	public int getSum(String customerName) throws TaxClientException {
		return 0;
	}

	@Override
	public Collection<Integer> getAccountNumbersForCustomer(String customerName) throws TaxClientException {
		return null;
	}
}
