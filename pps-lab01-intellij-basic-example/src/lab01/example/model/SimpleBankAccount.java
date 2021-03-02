package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdraw is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccount extends AbstractSimpleBankAccount {

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    @Override
    boolean isWithdrawAllowed(double amount) {
        return this.getBalance() >= amount;
    }
}
