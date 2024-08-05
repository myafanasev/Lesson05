package ru.dl.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dl.entity.TppProduct;
import ru.dl.model.ModelProduct;
import ru.dl.repo.TppProductRepo;
import ru.dl.repo.TppRefProductClassRepo;
import ru.dl.repo.TppRefProductRegisterTypeRepo;

@Component
public class ProductDB {
    @Autowired
    TppRefProductClassRepo repoTppRefProductClass;
    @Autowired
    TppRefProductRegisterTypeRepo repotppRefProductRegisterType;
    @Autowired
    TppProductRepo repoTppProduct;


    public TppProduct write(ModelProduct modelProduct) {
        TppProduct tppProduct = new TppProduct
        (
                repoTppRefProductClass.findFirstByValue(modelProduct.getProductCode()).getInternalId(),
                modelProduct.getMdmCode(),
                repotppRefProductRegisterType.findByValue(modelProduct.getRegisterType()).getInternalId().toString(),
                modelProduct.getContractNumber(),
                modelProduct.getPriority(),
                modelProduct.getContractDate(),
                null,
                null,
                null,
                modelProduct.getInterestRatePenalty(),
                null,
                modelProduct.getThresholdAmount(),
                modelProduct.getMinimalBalance().toString(),
                modelProduct.getRateType().getName(),
                modelProduct.getTaxPercentageRate(),
                null,
                null
        );
        repoTppProduct.save(tppProduct);
        return tppProduct;
    }
}
