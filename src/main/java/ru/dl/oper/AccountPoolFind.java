package ru.dl.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dl.entity.AccountPool;
import ru.dl.exception.ExceptionNotFound;
import ru.dl.model.ModelAccount;
import ru.dl.repo.AccountPoolRepo;

// Найти значение номера счета по параметрам branchCode, currencyCode, mdmCode, priorityCode, registryTypeCode из Request.Body в таблице Пулов счетов (account_pool)
@Component
public class AccountPoolFind {
    @Autowired
    AccountPoolRepo repoAccountPool;

    public AccountPool find(ModelAccount modelAccount) {
        AccountPool accountPool = repoAccountPool.findByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegistryTypeCode
                (
                        modelAccount.getBranchCode(),
                        modelAccount.getCurrencyCode(),
                        modelAccount.getMdmCode(),
                        modelAccount.getPriorityCode(),
                        modelAccount.getRegistryTypeCode()
                );
        if (accountPool == null)
            throw new ExceptionNotFound("Не найден запись в таблице пуле счетов account_pool по параметрам: " +
                    "Код филиала = " + modelAccount.getBranchCode() +
                    ", Код валюты = " + modelAccount.getCurrencyCode() +
                    ", Id клиента = " + modelAccount.getMdmCode() +
                    ", Код срочности = " + modelAccount.getPriorityCode() +
                    ", Тип регистра = " + modelAccount.getRegistryTypeCode()
                    );

        return accountPool;
    }
}
