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
}
