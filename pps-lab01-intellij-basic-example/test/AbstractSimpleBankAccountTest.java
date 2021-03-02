import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractSimpleBankAccountTest<B extends BankAccount> {
    private static final int ID_ACCOUNT_HOLDER = 1;
    private static final String NAME_ACCOUNT_HOLDER = "Mario";
    private static final String SURNAME_ACCOUNT_HOLDER = "Rossi";

    private static final int INITIAL_BALANCE_BANK_ACCOUNT = 0;
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int WITHDRAW_AMOUNT = 70;

    protected static final int WRONG_ID_ACCOUNT_HOLDER = 2;
    protected static final int WRONG_DEPOSIT_AMOUNT = 50;
    private static final int WRONG_WITHDRAW_AMOUNT = 70;

    protected AccountHolder accountHolder;
    protected B bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder(NAME_ACCOUNT_HOLDER, SURNAME_ACCOUNT_HOLDER, ID_ACCOUNT_HOLDER);
        bankAccount = setTestedTypeBankAccount(accountHolder, INITIAL_BALANCE_BANK_ACCOUNT);
    }

    abstract B setTestedTypeBankAccount(AccountHolder accountHolder, final double initialBalance);

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE_BANK_ACCOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(WRONG_ID_ACCOUNT_HOLDER, WRONG_DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - WITHDRAW_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(WRONG_ID_ACCOUNT_HOLDER, WRONG_WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }
}
