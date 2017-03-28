package praktikum1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BankServer extends Thread {




	@Override
	public void run() {
		try {

			Registry reg = LocateRegistry.createRegistry (1099);

			ComplexAdderImpl ad = new ComplexAdderImpl ("myComplexAdder", reg);
			//AdderImpl ad = new AdderImpl ("rmi://localhost:1099/myComplexAdder");

			System.out.println ("ComplAdder Server ready.");
		}
		catch (Exception e) {
			System.out.println ("ServerException: " + e.getMessage());
		}
	}
}
