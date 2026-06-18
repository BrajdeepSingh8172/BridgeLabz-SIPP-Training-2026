// Custom Exception storing state information
class InsufficientBalanceException extends Exception {
    private final double balance;
    private final double requestedAmount;

    public InsufficientBalanceException(double balance, double requestedAmount) {
        super(String.format("Transaction Declined: Requested ₹%.2f but balance is only ₹%.2f.", requestedAmount, balance));
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }

    public double getShortfall() {
        return requestedAmount - balance;
    }
}

public class AtmWithdrawalSystem {
    private double balance = 5000.0;

    // Core method throws the exception
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining balance: ₹" + balance);
    }

    public static void main(String[] args) {
        AtmWithdrawalSystem atm = new AtmWithdrawalSystem();
        double withdrawalRequest = 8000.0;

        // Handled at the application/user execution layer
        try {
            System.out.println("Attempting to withdraw: ₹" + withdrawalRequest);
            atm.withdraw(withdrawalRequest);
        } catch (InsufficientBalanceException e) {
            System.err.println(e.getMessage());
            System.err.println("Shortfall details: You need an additional ₹" + e.getShortfall() + " to complete this request.");
        }
    }
}