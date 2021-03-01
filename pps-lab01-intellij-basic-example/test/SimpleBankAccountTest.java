import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */

class SimpleBankAccountTest extends AbstractSimpleBankAccountTest {

    @Override
    BankAccount getBankAccount(AccountHolder accountHolder, double initialAmount) {
        return new SimpleBankAccount(accountHolder, initialAmount);
    }
}
