package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private double balance;
    private final AccountHolder holder;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(int usrID, double amount) {

    }

    @Override
    public void withdraw(int usrID, double amount) {

    }
}
