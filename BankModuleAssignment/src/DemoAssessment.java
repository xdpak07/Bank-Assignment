import java.util.Scanner;

	public class DemoAssessment {
		public static void clearScreen() {
			System.out.print("/././.");
			System.out.flush();
		}

		static void openingMenu(AccountData newAccount) {
			System.out.println("Welcome to the Bank \nYou can create and manage your account\n");
			System.out.println("Create your account");
			System.out.println("Manage your account");
			System.out.println("Exit");
			Scanner s = new Scanner(System.in);
			int switchChoice = s.nextInt();
			s.close();
			switch (switchChoice) {
			case 1:
				clearScreen();
				newAccount.createNewAccount();
				promptEnterKey();
				clearScreen();
				ManageAccMenu(newAccount);
				break;

			case 0:
				break;
			}
		}

		static void ManageAccMenu(AccountData newAccount) {
			clearScreen();
			System.out.println("Manage your account\n");
			System.out.println("1. Deposit money");
			System.out.println("2. Withdraw money");
			System.out.println("3. Display account details");
			System.out.println("4. Close account");
			System.out.println("0. Exit from account");
			Scanner s = new Scanner(System.in);
			int switchChoice = s.nextInt();
			s.close();
			switch (switchChoice) {
			case 1:
				clearScreen();
				newAccount.depositeAmount();
				promptEnterKey();
				ManageAccMenu(newAccount);

			case 2:
				clearScreen();
				newAccount.withDrawAmount();
				promptEnterKey();
				ManageAccMenu(newAccount);

    		case 3:
				clearScreen();
				newAccount.displayAccountDetails();
				promptEnterKey();
				ManageAccMenu(newAccount);

			case 4:
				clearScreen();
				newAccount.closeAccount();
				promptEnterKey();
				break;

			case 0:
				break;
			}
		}

		static void promptEnterKey() {
			System.out.println("Press Enter to continue");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			sc.close();

		}

		public static void main(String[] args) {
			AccountData newAccount = new AccountData();

			openingMenu(newAccount);

		}

	}
