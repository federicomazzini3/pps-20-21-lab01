package lab01.example.model;

public abstract class AbstractSimpleBankAccount implements BankAccount {
    private final AccountHolder holder;
    private double balance;

    public AbstractSimpleBankAccount(final double balance, final AccountHolder holder) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    abstract boolean isWithdrawAllowed(final double amount);

}
