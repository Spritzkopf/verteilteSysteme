package praktikum1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface AccountManager extends Remote {

	int addAccount(String customerName, String password) throws RemoteException;

	void deposit(int accountNumber, String customerName, int amount) throws RemoteException, CustomerClientException;

	void withdraw(int accountNumber, String customerName, String password, int amount) throws RemoteException, CustomerClientException;

	Balance getBalance(int accountNumber, String customerName, String password) throws RemoteException, CustomerClientException;

	int getSum(String customerName) throws RemoteException;

	Collection<Integer> getAccountNumbers(String customerName) throws RemoteException;

}
