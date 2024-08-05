package ru.dl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dl.check_account.AccountCheckable;
import ru.dl.entity.Account;
import ru.dl.entity.AccountPool;
import ru.dl.entity.TppProductRegister;
import ru.dl.model.ModelAccount;
import ru.dl.oper.AccountDB;
import ru.dl.oper.AccountFind;
import ru.dl.oper.AccountPoolFind;
import ru.dl.repo.AccountPoolRepo;
import ru.dl.response.AccountResponse;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    List<AccountCheckable> accountChecks;
    @Autowired
    AccountPoolRepo repoAccountPool;
    @Autowired
    AccountPoolFind findAccountPool;
    @Autowired
    AccountFind findAccount;
    @Autowired
    AccountDB accountDB;

    public AccountResponse make(ModelAccount modelAccount) {
        // выполняем проверки
        for (AccountCheckable ch : accountChecks)
            ch.check(modelAccount);

        // ищем запись в пуле счетов
        AccountPool accountPool = findAccountPool.find(modelAccount);

        // ищем счёт
        Account account = findAccount.find(accountPool.getId());

        // формируем новый продуктовый регистр и записываем его в БД
        TppProductRegister tppProductRegister = accountDB.write(modelAccount, account);

        // формируем ответ
        AccountResponse accountResponse = new AccountResponse(tppProductRegister.getId());

        return accountResponse;
    }
}
