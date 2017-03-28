package praktikum1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CustomerClient extends Thread {

	@Override
	public void run() {
		super.run();
		try {
			Registry reg = LocateRegistry.getRegistry(1099);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void addAccount(String customerName, String password) {

	}

	public void deposit(String customerName, String password, int amount) throws CustomerClientException {

	}

	public void withdraw(String customerName, String password, int amount) throws CustomerClientException {

	}

	public Balance  getBalance(String customerName, String password, int accountNumber) {
		return null;
	}

}
