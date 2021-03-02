package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account with ATM allows the deposit and the withdraw also with ATM.
 * Each transaction with ATM implies a fee.
 */
public class SimpleBankAccountWithAtm extends AbstractSimpleBankAccount {

    private static final int DEPOSIT_ATM_FEE = 1;
    private static final int WITHDRAW_ATM_FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(balance, holder);
    }

    public void depositWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.setBalance(this.getBalance() + getDepositAmountWithFee(amount));
        }
    }

    public void withdrawWithAtm(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.setBalance(this.getBalance() - getWithdrawAmountWithFee(amount));
        }
    }

    @Override
    boolean isWithdrawAllowed(double amount) {
        return this.getBalance() >= getWithdrawAmountWithFee(amount);
    }

    private double getWithdrawAmountWithFee(double amount){
        return amount + WITHDRAW_ATM_FEE;
    }

    private double getDepositAmountWithFee(double amount){
        return amount - DEPOSIT_ATM_FEE;
    }
}
