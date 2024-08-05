package ru.dl.check_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.dl.exception.ExceptionBadRequest;
import ru.dl.model.ModelProduct;
import ru.dl.repo.TppProductRepo;

// Проверка таблицы ЭП (tpp_product) на дубли.
@Component
@Order(10)
public class ProductCheckDouble implements ProductCheckable{

    @Autowired
    TppProductRepo repoTppProduct;

    @Override
    public void check(ModelProduct modelProduct) {
        Long productId = repoTppProduct.getIdByNumber(modelProduct.getContractNumber());
        if (productId != null) {
            throw new ExceptionBadRequest("Параметр ContractNumber № договора " + modelProduct.getContractNumber() + " уже существует для ЭП с ИД " + productId);
        }
    }
}
