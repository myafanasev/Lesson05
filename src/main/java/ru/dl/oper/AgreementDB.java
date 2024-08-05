package ru.dl.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dl.entity.Agreement;
import ru.dl.model.ModelAgreement;
import ru.dl.model.ModelProduct;
import ru.dl.repo.AgreementRepo;

@Component
public class AgreementDB {
    @Autowired
    AgreementRepo repoAgreement;

    public Agreement write(ModelProduct modelProduct, ModelAgreement modelAgreement) {
        Agreement agreement = new Agreement
        (
                modelProduct.getInstanceId(),
                modelAgreement.getGeneralAgreementId(),
                modelAgreement.getSupplementaryAgreementId(),
                modelAgreement.getArrangementType().toString(),
                modelAgreement.getShedulerJobId(),
                modelAgreement.getNumber(),
                modelAgreement.getOpeningDate(),
                modelAgreement.getClosingDate(),
                modelAgreement.getCancelDate(),
                modelAgreement.getValidityDuration(),
                modelAgreement.getCancellationReason(),
                modelAgreement.getStatus(),
                modelAgreement.getInterestCalculationDate(),
                modelAgreement.getInterestRate(),
                modelAgreement.getCoefficient(),
                modelAgreement.getCoefficientAction().getName(),
                modelAgreement.getMinimumInterestRate(),
                modelAgreement.getMinimumInterestRateCoefficient(),
                modelAgreement.getMinimumInterestRateCoefficientAction().getName(),
                modelAgreement.getMaximalnterestRate(),
                modelAgreement.getMaximalnterestRateCoefficient(),
                modelAgreement.getMaximalnterestRateCoefficientAction().getName()
        );
        repoAgreement.save(agreement);
        return agreement;
    }
}
