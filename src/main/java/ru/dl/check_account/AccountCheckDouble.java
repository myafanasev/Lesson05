package ru.dl.check_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.dl.exception.ExceptionBadRequest;
import ru.dl.model.ModelAccount;
import ru.dl.repo.TppProductRegisterRepo;

// Проверка таблицы ПР (таблица tpp_product_register) на дубли
@Component
@Order(10)
public class AccountCheckDouble implements AccountCheckable{
    @Autowired
    TppProductRegisterRepo repoTppProductRegister;

    @Override
    public void check(ModelAccount modelAccount) {
        Long registerId = repoTppProductRegister.getIdByProductIdAndType(modelAccount.getInstanceId(), modelAccount.getRegistryTypeCode());
        if (registerId != null) {
            throw new ExceptionBadRequest("Параметр registryTypeCode тип регистра " + modelAccount.getRegistryTypeCode() + " уже существует для ЭП с ИД " + registerId);
        }}
}
