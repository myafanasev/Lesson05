package ru.dl.service;

import org.springframework.stereotype.Service;
import ru.dl.model.ModelProduct;
import ru.dl.response.ProductResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public ProductResponse make(ModelProduct modelProduct) {
        System.out.println(modelProduct);
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
