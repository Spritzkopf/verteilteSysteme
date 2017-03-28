package praktikum1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BankServer {

	private final Registry registry;
	private final AccountManager accountManager;

	public BankServer(int id) throws RemoteException {
		registry = LocateRegistry.createRegistry(id);
		accountManager = new AccountManagerImpl();
		registry.rebind("accountManager", accountManager);
	}

	public void close() throws RemoteException, NotBoundException {
		registry.unbind("accountManager");
		UnicastRemoteObject.unexportObject(registry, true);
	}
}
