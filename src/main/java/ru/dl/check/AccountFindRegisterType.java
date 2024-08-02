
package ru.dl.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.dl.entity.TppRefProductRegisterType;
import ru.dl.exception.ExceptionNotFound;
import ru.dl.model.ModelAccount;
import ru.dl.repo.TppRefProductRegisterTypeRepo;

// Взять значение из Request.Body.registryTypeCode и найти соответствующие ему записи в tpp_ref_product_register_type.value
@Component
@Order(10)
public class AccountFindRegisterType implements AccountCheckable{
    @Autowired
    TppRefProductRegisterTypeRepo repotppRefProductRegisterType;

    @Override
    public void check(ModelAccount modelAccount) {
        TppRefProductRegisterType tppRefProductRegisterType = repotppRefProductRegisterType.findByValue(modelAccount.getRegistryTypeCode());
        if (tppRefProductRegisterType == null)
            throw new ExceptionNotFound("Код Продукта " + modelAccount.getRegistryTypeCode() + " не найдено в Каталоге продуктов tpp_ref_product_register_type для данного типа Регистра");
    }
}
