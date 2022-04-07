import org.junit.Test;
import static org.junit.Assert.*;


	public class DepoAndWithdraw {
		@Test
		// Deposite method
		public void testDepositeAmount() {
			System.out.println("\nDeposite");
			AccountData testObj = new AccountData();
			testObj.depositeAmount();
			assertEquals(testObj.getBalanceAmount(), 1000);
			testObj.depositeAmount();
			assertFalse(testObj.getBalanceAmount() == 600);
		}

		@Test
		// Close account method
		public void testCloseAccount() {
			System.out.println("\nClose account");
			AccountData testObj = new AccountData();
			testObj.setBalanceAmount(100);
			testObj.closeAccount();
			assertEquals(testObj.getBalanceAmount(), 0);
			assertEquals(testObj.getStatus(), "CLOSED");
		}

		@Test
		// testWithDrawAmount method
		public void testWithDrawAmount() {
			System.out.println("\ntestWithDrawAmount");
			AccountData testObj = new AccountData();
			testObj.setBalanceAmount(1000);
			testObj.withDrawAmount();
			assertEquals(testObj.getBalanceAmount(), 200);
			System.out.println("\ninactive status in testWithDrawAmount");
			testObj.setBalanceAmount(500);
			testObj.withDrawAmount();
			assertEquals(testObj.getBalanceAmount(), 1);
			assertEquals(testObj.getStatus(), "INACTIVE");

		}

	}