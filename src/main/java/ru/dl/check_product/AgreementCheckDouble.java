package ru.dl.check_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.dl.exception.ExceptionBadRequest;
import ru.dl.model.ModelAgreement;
import ru.dl.model.ModelProduct;
import ru.dl.repo.AgreementRepo;
import ru.dl.repo.TppProductRepo;

@Component
@Order(20)
public class AgreementCheckDouble implements ProductCheckable{
    @Autowired
    AgreementRepo repoAgreement;

    @Override
    public void check(ModelProduct modelProduct) {
        Long agreementId;
        for (ModelAgreement agr : modelProduct.getInstanceArrangement()) {  // цикл по массиву доп. соглашений
            agreementId = repoAgreement.getIdByNumber(agr.getNumber());
            if (agreementId != null) {
                throw new ExceptionBadRequest("Параметр № Дополнительного соглашения (сделки) Number " + agr.getNumber() + " уже существует для ЭП с ИД " + agreementId);
            }
        }
    }
}