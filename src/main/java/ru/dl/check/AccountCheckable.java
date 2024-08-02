package ru.dl.check;

import ru.dl.model.ModelAccount;

// проверка при создании продуктового регистра
public interface AccountCheckable {
    void check(ModelAccount modelAccount);
}