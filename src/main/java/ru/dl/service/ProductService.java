package ru.dl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dl.check_product.ProductCheckable;
import ru.dl.model.ModelProduct;
import ru.dl.oper.RegisterTypeFind;
import ru.dl.response.ProductResponse;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    List<ProductCheckable> productCheckables;
    @Autowired
    RegisterTypeFind registerTypeFind;

    public ProductResponse make(ModelProduct modelProduct) {
        if (modelProduct.getInstanceId() == null) { // Если ИД ЭП в поле Request.Body.instanceId не задано (NULL/Пусто), то выполняется процесс создания нового экземпляра
            // выполняем проверки
            for(ProductCheckable ch : productCheckables) {
                ch.check(modelProduct);
            }
        }

        // По КодуПродукта найти связные записи в Каталоге Типа регистра
        List<String> registerTypes = registerTypeFind.find(modelProduct);
        System.out.println(registerTypes);

        // Добавить строку в таблицу tpp_product, заполнить согласно Request.Body

        List<Long> arr1 = new ArrayList<>();
        arr1.add(2L);
        arr1.add(3L);

        List<Long> arr2 = new ArrayList<>();
        arr2.add(20L);
        arr2.add(30L);

        ProductResponse productResponse = new ProductResponse(12L, arr1, arr2);
        return productResponse;
    }
}
