package praktikum1;

import org.junit.Assert;
import org.junit.Test;

public class Tester {

	@Test
	public void test() throws Exception {
		CustomerClient cc = new CustomerClient();
		TaxClient tc = new TaxClient();

		cc.addAccount("Hans", "password1");
		cc.addAccount("Peter", "password2");
		cc.addAccount("Anna", "password3");

		cc.deposit("Hans", "password1", 40);
		cc.deposit("Hans", "password1", 30);
		cc.deposit("Peter", "password2", 50);
		cc.deposit("Peter", "password2", 30);
		cc.deposit("Anna", "password3", 60);
		cc.deposit("Anna", "password3", 30);

		Balance b1 = cc.getBalance("Hans", "password1", 0);
		Balance b2 = cc.getBalance("Peter", "password2", 0);
		Balance b3 = cc.getBalance("Anna", "password3", 0);

		Assert.assertEquals("Account balance not correct", b1.getBalance(), 10);
		Assert.assertEquals("Account balance not correct", b2.getBalance(), 20);
		Assert.assertEquals("Account balance not correct", b3.getBalance(), 30);
	}
}
