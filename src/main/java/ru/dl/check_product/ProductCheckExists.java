package ru.dl.check_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.dl.entity.TppProduct;
import ru.dl.exception.ExceptionNotFound;
import ru.dl.model.ModelProduct;
import ru.dl.repo.TppProductRepo;

// Проверка таблицы ЭП (tpp_product) на существование ЭП
@Component
@Order(20)
public class ProductCheckExists implements ProductCheckable{
    @Autowired
    TppProductRepo repoTppProduct;

    @Override
    public void check(ModelProduct modelProduct) {
        if (modelProduct.getInstanceId() != null) { // только если instanceId заполнен
            if (repoTppProduct.findFirstById(modelProduct.getInstanceId()) == null) {
                throw new ExceptionNotFound("Экземпляр продукта с параметром instanceId " + modelProduct.getInstanceId() + " не найден");
            }
        }
    }
}
