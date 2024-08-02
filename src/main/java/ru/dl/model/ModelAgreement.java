package ru.dl.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ModelAgreement {
    private String generalAgreementId;
    private String supplementaryAgreementId;
    private EnumTypeAgreement arrangementType;
    private Long shedulerJobId;
    @NotNull(message = "Имя обязательного параметра number не заполнено")
    private String number;
    @NotNull(message = "Имя обязательного параметра openingDate не заполнено")
    private Date openingDate;
    private Date closingDate;
    private Date cancelDate;
    private Long validityDuration;
    private String cancellationReason;
    private String status;
    private Date interestCalculationDate;
    private Double interestRate;
    private Double coefficient;
    private EnumPlusMinus coefficientAction;
    private Double minimumInterestRate;
    private String minimumInterestRateCoefficient;
    private EnumPlusMinus minimumInterestRateCoefficientAction;
    private Double maximalnterestRate;
    private Double maximalnterestRateCoefficient;
    private EnumPlusMinus maximalnterestRateCoefficientAction;
}
