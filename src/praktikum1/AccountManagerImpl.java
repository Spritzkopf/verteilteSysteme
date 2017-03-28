package praktikum1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

class AccountManagerImpl extends UnicastRemoteObject implements AccountManager {

	private HashMap<Integer, Account> accounts = new HashMap<>();

	public AccountManagerImpl() throws RemoteException {
		super();
	}

	@Override
	public int addAccount(String customerName, String password) {
		final int accountNumber = accounts.size();
		final Account a = new Account(customerName, password, accountNumber);
		accounts.put(accountNumber, a);
		return accountNumber;
	}

	@Override
	public void deposit(int accountNumber, String customerName, int amount) throws CustomerClientException {
		Account a = accounts.get(accountNumber);
		if (!customerName.equals(a.getCustomerName()))
			throw new CustomerClientException("wrong name");
		a.deposit(amount);
	}

	@Override
	public void withdraw(int accountNumber, String customerName, String password, int amount) throws CustomerClientException {
		Account a = accounts.get(accountNumber);
		if (!customerName.equals(a.getCustomerName()))
			throw new CustomerClientException("wrong name");
		if (!password.equals(a.getPassword()))
			throw new CustomerClientException("wrong password");
		if (a.getBalance() < amount)
			throw new CustomerClientException("balance too low");
		a.withdraw(amount);
	}

	@Override
	public Balance getBalance(int accountNumber, String customerName, String password) throws CustomerClientException {
		Account a = accounts.get(accountNumber);
		if (!customerName.equals(a.getCustomerName()))
			throw new CustomerClientException("wrong name");
		if (!password.equals(a.getPassword()))
			throw new CustomerClientException("wrong password");
		return new Balance(a.getBalance(), accountNumber);
	}

	@Override
	public int getSum(String customerName) {
		int count = 0;
		for (Account a : accounts.values()) {
			if (a.getCustomerName().equals(customerName)) {
				count += a.getBalance();
			}
		}
		return count;
	}

	@Override
	public Collection<Integer> getAccountNumbers(String customerName)  {
		LinkedList<Integer> accountNumbers = new LinkedList<>();
		for (Account a : accounts.values()) {
			if (a.getCustomerName().equals(customerName)) {
				accountNumbers.add(a.getAccountNumber());
			}
		}
		return accountNumbers;
	}
}
