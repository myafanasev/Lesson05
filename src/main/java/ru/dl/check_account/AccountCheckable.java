package ru.dl.check_account;

import ru.dl.model.ModelAccount;

// проверка при создании продуктового регистра
public interface AccountCheckable {
    void check(ModelAccount modelAccount);
}