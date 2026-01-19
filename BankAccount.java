class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } 
        else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } 
        else {
            balance -= amount;
            System.out.println("✅ Please collect your cash.");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}
