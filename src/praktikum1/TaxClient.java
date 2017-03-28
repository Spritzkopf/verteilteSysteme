package praktikum1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;

public class TaxClient {

	private AccountManager accountManager;

	public TaxClient(int bankId) throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(bankId);
		accountManager = (AccountManager) reg.lookup("accountManager");
	}

	public int getSum(String customerName) throws RemoteException {
		return accountManager.getSum(customerName);
	}

	public Collection<Integer> getAccountNumbers(String customerName) throws RemoteException {
		return accountManager.getAccountNumbers(customerName);
	}
}
