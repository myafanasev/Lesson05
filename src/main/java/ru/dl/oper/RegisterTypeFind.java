package ru.dl.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dl.exception.ExceptionBadRequest;
import ru.dl.exception.ExceptionNotFound;
import ru.dl.model.ModelProduct;
import ru.dl.repo.TppRefProductRegisterTypeRepo;

import java.util.List;

// По КодуПродукта найти связные записи в Каталоге Типа регистра
@Component
public class RegisterTypeFind {
    @Autowired
    TppRefProductRegisterTypeRepo repoTppRefProductRegisterType;

    public List<String> find(ModelProduct modelProduct) {
        List<String> registerTypes = repoTppRefProductRegisterType.getValuesByProductCode(modelProduct.getProductCode());
        if (registerTypes.size() == 0)
            throw new ExceptionNotFound("КодПродукта " + modelProduct.getProductCode() + " не найдено в Каталоге продуктов tpp_ref_product_class");
        return registerTypes;
    }

}
