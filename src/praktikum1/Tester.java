package praktikum1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.LinkedList;

public class Tester {

	private BankServer bankServer;
	private CustomerClient customerClient;
	private TaxClient taxClient;

	@Before
	public void before() throws RemoteException, NotBoundException {
		bankServer = new BankServer(1099);
		customerClient = new CustomerClient(1099);
		taxClient = new TaxClient(1099);
	}

	@After
	public void after() throws RemoteException, NotBoundException {
		bankServer.close();
	}

	@Test
	public void test() throws Exception {
		int id1 = customerClient.addAccount("Hans", "password1");
		int id2 = customerClient.addAccount("Peter", "password2");
		int id3 = customerClient.addAccount("Anna", "password3");

		customerClient.deposit(id1, "Hans", 40);
		customerClient.withdraw(id1, "Hans", "password1", 30);
		customerClient.deposit(id2, "Peter", 50);
		customerClient.withdraw(id2, "Peter", "password2", 30);
		customerClient.deposit(id3, "Anna", 60);
		customerClient.withdraw(id3, "Anna", "password3", 30);

		Balance b1 = customerClient.getBalance(id1, "Hans", "password1");
		Balance b2 = customerClient.getBalance(id2, "Peter", "password2");
		Balance b3 = customerClient.getBalance(id3, "Anna", "password3");

		Assert.assertEquals("Account balance not correct", b1.getBalance(), 10);
		Assert.assertEquals("Account balance not correct", b2.getBalance(), 20);
		Assert.assertEquals("Account balance not correct", b3.getBalance(), 30);
	}

	@Test
	public void testGetSum() throws Exception {
		int id1 = customerClient.addAccount("Hans", "password1");
		int id2 = customerClient.addAccount("Hans", "password2");

		customerClient.deposit(id1, "Hans", 40);
		customerClient.deposit(id2, "Hans", 50);

		int sum = taxClient.getSum("Hans");

		Assert.assertEquals("Account Sum is not correct", sum, 90);
	}

	@Test
	public void testGetAccountNumbers() throws Exception {
		LinkedList<Integer> accountNumbers = new LinkedList<>();

		int id1 = customerClient.addAccount("Hans", "password1");
		customerClient.addAccount("Petra", "password3");
		int id2 = customerClient.addAccount("Hans", "password2");

		accountNumbers.add(id1);
		accountNumbers.add(id2);

		customerClient.deposit(id1, "Hans", 40);
		customerClient.deposit(id2, "Hans", 50);

		Collection<Integer> numbers = taxClient.getAccountNumbers("Hans");

		Assert.assertEquals("Wrong accountnumbers returned", accountNumbers, numbers);
	}
}
