import java.util.Scanner;

	public class AccountData {

		private String ownerName;
		private String address;
		private int balanceAmount;
		private String createdDate;
		private String status;
		private int accType;
		Scanner sc = new Scanner(System.in);

		public String getOwnerName() {
			return ownerName;
		}

		public void setOwnerName() {
			System.out.println("Please enter your name: ");
			String ownerName = sc.next();
			this.ownerName = ownerName;
		}

		public String getAddress() {
			return address;
		}

		public int getBalanceAmount() {
			return balanceAmount;
		}

		public void setBalanceAmount(int balanceAmount) {

			this.balanceAmount = balanceAmount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getAccType() {
			return accType;
		}

		public void setAccType(int accType) {
			this.accType = accType;
		}

		public String getCurrentDate() {
			return createdDate;
		}

		public void setCurrentDate() {
			long millis = System.currentTimeMillis();
			java.sql.Date mydate = new java.sql.Date(millis);
			String date = String.valueOf(mydate);
			this.createdDate = date;

		}

		public void addressDetails() {
			System.out.println("Enter city");
			String city = sc.next();
			System.out.println("Enter your state");
			String state = sc.next();
			System.out.println("Enter pincode");
			int pincode = sc.nextInt();
			System.out.println("Enter house no");
			String houseNo = sc.next();
			System.out.println("Enter your street");
			String street = sc.next();

			this.address = city + "," + state + "," + pincode + "," + houseNo + "," + street;
			setCurrentDate();
		}

		public void createAccType() {
			System.out.println("Please enter your choice to create account:\n  1.SAVINGS\n  2.DEMAT\n  3.CURRENT");
			int choice = sc.nextInt();
			setAccType(choice);
		}
		
		public void depositeAmount() {

			System.out.println("Enter the amount to be deposited");
			int amount = sc.nextInt();
			if (amount > 200) {
				this.balanceAmount = this.balanceAmount + amount;
				if (this.balanceAmount > 200) {
					this.status = "ACTIVE";
				}
				showBalance();
			} else {
				System.out.println("Minimum amount to be deposited should be more than 100 Rs. \n");
				depositeAmount();
			}
		}

		
		public void withDrawAmount() {

			System.out.println("\nEnter the amount to withdraw:");
			int withDrawAmount = sc.nextInt();
			if (withDrawAmount >= this.balanceAmount) {
				System.out.println("Oopss!!You have entered the withdrawl amount greater than your balance");
				withDrawAmount();
			} else {
				System.out.println("Amount withdrawal successfully");
				this.balanceAmount = this.balanceAmount - withDrawAmount;
				if (this.balanceAmount < 200) {
					this.status = "INACTIVE";

				}
				showBalance();
			}

		}

		public void showBalance() {
			System.out.println("Your current balance is:" + this.balanceAmount);
			System.out.println("Your account status is:" + this.status);
		}

		public void displayAccountDetails() {
			System.out.println("\nYour account details are:" + "\n\n" + "OwnerName is:" + getOwnerName() + "\n"
					+ "Address is:" + getAddress() + "\n" + "Your balance amount is:" + getBalanceAmount() + "\n"
					+ "Your account created date is:" + getCurrentDate() + "\n" + "Your account status:" + getStatus());

		}

	
		public void closeAccount() {
			System.out.println("Option for close your account ? Y/N");
			Scanner sc = new Scanner(System.in);
			char choice = sc.next().charAt(0);
			sc.close();
			if (choice == 'Y' || choice == 'N') {
				if (choice == 'Y') {
					this.status = "CLOSED";
					this.balanceAmount = 0;
					System.out.println("Your account is closed on " + this.getCurrentDate());
					this.displayAccountDetails();
				}
			} else {
				System.out.println("Enter correct choice!\n");
				closeAccount();
			}
		}


		public void createNewAccount() {
			this.createAccType();
			this.setOwnerName();
			this.depositeAmount();
			this.addressDetails();
		}

	}