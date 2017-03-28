package praktikum1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CustomerClient {

	private AccountManager accountManager;

	public CustomerClient(int bankId) throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(bankId);
		accountManager = (AccountManager) reg.lookup("accountManager");
	}

	public int addAccount(String customerName, String password) throws RemoteException {
		return accountManager.addAccount(customerName, password);
	}

	public void deposit(int accountNumber, String customerName, int amount) throws RemoteException, CustomerClientException {
		accountManager.deposit(accountNumber, customerName, amount);
	}

	public void withdraw(int accountNumber, String customerName, String password, int amount) throws RemoteException, CustomerClientException {
		accountManager.withdraw(accountNumber, customerName, password, amount);
	}

	public Balance getBalance(int accountNumber, String customerName, String password) throws RemoteException, CustomerClientException {
		return accountManager.getBalance(accountNumber, customerName, password);
	}

}
