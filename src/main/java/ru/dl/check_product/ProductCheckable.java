package ru.dl.check_product;

import ru.dl.model.ModelAccount;
import ru.dl.model.ModelProduct;

// проверки при создании экземпляра продукта
public interface ProductCheckable {
    void check(ModelProduct modelProduct);
}
