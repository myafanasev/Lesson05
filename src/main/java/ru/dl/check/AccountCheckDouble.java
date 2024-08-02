package ru.dl.check;

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
        if (repoTppProductRegister.findAllByProductIdAndType(modelAccount.getInstanceId(), modelAccount.getRegistryTypeCode()).size() > 0 ) {
            throw new ExceptionBadRequest("Параметр registryTypeCode тип регистра " + modelAccount.getRegistryTypeCode() + " уже существует для ЭП с ИД " + modelAccount.getInstanceId());
        }}
}
