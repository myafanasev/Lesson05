package ru.dl.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductResponse {
    ProductResponse.ProductResponseBody data;

    public ProductResponse(Long instanceId, List<Long> registerId, List<Long> supplementaryAgreementId) {
        this.data = new ProductResponseBody(instanceId, registerId, supplementaryAgreementId);
    }

    @Data
    @AllArgsConstructor
    private static class ProductResponseBody {
        Long instanceId;
        List<Long> registerId = new ArrayList<>();
        List<Long> supplementaryAgreementId = new ArrayList<>();
    }

}
