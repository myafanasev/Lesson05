package ru.dl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dl.check_product.ProductCheckable;
import ru.dl.entity.TppProduct;
import ru.dl.model.ModelAccount;
import ru.dl.model.ModelProduct;
import ru.dl.oper.ProductDB;
import ru.dl.oper.RegisterTypeFind;
import ru.dl.response.AccountResponse;
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
    @Autowired
    ProductDB productDB;

    @Autowired
    AccountService accountService; // обработка запроса создания продуктового регистра

    public ProductResponse make(ModelProduct modelProduct) {
        List<Long> arrRegister = new ArrayList<>(); // Идентификаторы продуктового регистра

        if (modelProduct.getInstanceId() == null) { // Если ИД ЭП в поле Request.Body.instanceId не задано (NULL/Пусто), то выполняется процесс создания нового экземпляра
            // выполняем проверки
            for (ProductCheckable ch : productCheckables) {
                ch.check(modelProduct);
            }


            // По КодуПродукта найти связные записи в Каталоге Типа регистра
            List<String> registerTypes = registerTypeFind.find(modelProduct);

            // Добавить строку в таблицу tpp_product, заполнить согласно Request.Body
            TppProduct tppProduct = productDB.write(modelProduct);
            modelProduct.setInstanceId(tppProduct.getId());

            for (String str : registerTypes) {   // Добавить в таблицу ПР (tpp_product_registry) строки
                ModelAccount modelAccount = new ModelAccount
                        (
                                tppProduct.getId(),
                                str,
                                null,
                                modelProduct.getIsoCurrencyCode(),
                                modelProduct.getBranchCode(),
                                modelProduct.getUrgencyCode(),
                                modelProduct.getMdmCode().toString(),
                                null,
                                null,
                                null,
                                null
                        );
                AccountResponse accountResponse = accountService.make(modelAccount);
                arrRegister.add(accountResponse.getDataAccountId());
            }
        }

        List<Long> arr2 = new ArrayList<>();
        arr2.add(20L);
        arr2.add(30L);

        ProductResponse productResponse = new ProductResponse(modelProduct.getInstanceId(), arrRegister, arr2);
        return productResponse;
    }
}
