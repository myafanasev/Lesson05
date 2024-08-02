package ru.dl.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dl.entity.Account;
import ru.dl.entity.State;
import ru.dl.entity.TppProductRegister;
import ru.dl.model.ModelAccount;
import ru.dl.repo.TppProductRegisterRepo;

@Component
public class AccountDB {
    @Autowired
    TppProductRegisterRepo repoTppProductRegister;

    // Сформировать новый продуктовый регистр и записать его в БД
    public TppProductRegister write(ModelAccount modelAccount, Account account) {
        TppProductRegister tppProductRegister = new TppProductRegister
                (
                modelAccount.getInstanceId(),
                modelAccount.getRegistryTypeCode(),
                account.getId(),
                modelAccount.getCurrencyCode(),
                State.OPEN.getNumState(),
                account.getAccountNumber()
                );
        return repoTppProductRegister.save(tppProductRegister);
    }
}
