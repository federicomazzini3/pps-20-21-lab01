import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest<SimpleBankAccountWithAtm>{

    @Override
    SimpleBankAccountWithAtm getBankAccount(AccountHolder accountHolder, double initialAmount) {
        return new SimpleBankAccountWithAtm(accountHolder, initialAmount);
    }

    @Test
    void testDepositWithAtm(){
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.depositWithAtm(2, 50);
        assertEquals(99, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(28, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.depositWithAtm(accountHolder.getId(), 100);
        bankAccount.withdrawWithAtm(2, 70);
        assertEquals(99, bankAccount.getBalance());
    }
}
