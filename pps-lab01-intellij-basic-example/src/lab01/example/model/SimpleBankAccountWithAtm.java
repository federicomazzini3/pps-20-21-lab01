package lab01.example.model;

public class SimpleBankAccountWithAtm extends AbstractSimpleBankAccount {

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    public void depositWithAtm(final int usrID, final double amount) {
        if(checkUser(usrID)){
            this.balance += amount - 1;
        }
    }

    public void withdrawWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + 1;
        }
    }

    @Override
    boolean isWithdrawAllowed(double amount) {
        return this.balance >= amount + 1;
    }
}
