package ru.dl.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dl.entity.Account;
import ru.dl.exception.ExceptionNotFound;
import ru.dl.repo.AccountRepo;

@Component
public class AccountFind {
    @Autowired
    AccountRepo repoAccount;

    public Account find(Long accountPoolId) {
        Account account = repoAccount.findFirstByAccountPoolId(accountPoolId);
        if (account == null)
            throw new ExceptionNotFound("Не найдена запись в таблице счетов account по id пула счетов = " + accountPoolId);
        return account;
    }
}
