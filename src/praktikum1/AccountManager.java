package praktikum1;

import java.rmi.Remote;
import java.util.Collection;

public interface AccountManager extends Remote {

	void addAccount(String customerName, String password);

	void deposit(String customerName, String password, int amount) throws CustomerClientException;

	void withdraw(String customerName, String password, int amount) throws CustomerClientException;

	Balance getBalance(String customerName, String password, int accountNumber);

	int getSum(String customerName) throws TaxClientException;

	Collection<Integer> getAccountNumbersForCustomer(String customerName) throws TaxClientException;

}
