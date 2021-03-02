import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest<SimpleBankAccountWithAtm>{

    private static final int DEPOSIT_AMOUNT_WITH_ATM = 100;
    private static final int WITHDRAW_AMOUNT_WITH_ATM = 70;
    private static final int DEPOSIT_ATM_FEE = 1;
    private static final int WITHDRAW_ATM_FEE = 1;

    @Override
    SimpleBankAccountWithAtm setTestedTypeBankAccount(AccountHolder accountHolder, double initialBalance) {
        return new SimpleBankAccountWithAtm(accountHolder, initialBalance);
    }

    @Test
    void testDepositWithAtm(){
        bankAccount.depositWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - DEPOSIT_ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        bankAccount.depositWithAtm(WRONG_ID_ACCOUNT_HOLDER, WRONG_DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - DEPOSIT_ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        bankAccount.withdrawWithAtm(accountHolder.getId(), WITHDRAW_AMOUNT_WITH_ATM);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - DEPOSIT_ATM_FEE - WITHDRAW_AMOUNT_WITH_ATM - WITHDRAW_ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), DEPOSIT_AMOUNT_WITH_ATM);
        bankAccount.withdrawWithAtm(WRONG_ID_ACCOUNT_HOLDER, WRONG_DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT_WITH_ATM - DEPOSIT_ATM_FEE, bankAccount.getBalance());
    }
}
