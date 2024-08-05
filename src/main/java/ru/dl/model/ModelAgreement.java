package ru.dl.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ModelAgreement {
    private String generalAgreementId;
    private String supplementaryAgreementId;
    private EnumTypeAgreement arrangementType;
    private Long shedulerJobId;
    @NotNull(message = "Имя обязательного параметра number не заполнено")
    private String number;
    @NotNull(message = "Имя обязательного параметра openingDate не заполнено")
    private Timestamp openingDate;
    private Timestamp closingDate;
    private Timestamp cancelDate;
    private Long validityDuration;
    private String cancellationReason;
    private String status;
    private Timestamp interestCalculationDate;
    private Double interestRate;
    private Double coefficient;
    private EnumPlusMinus coefficientAction;
    private Double minimumInterestRate;
    private Double minimumInterestRateCoefficient;
    private EnumPlusMinus minimumInterestRateCoefficientAction;
    private Double maximalnterestRate;
    private Double maximalnterestRateCoefficient;
    private EnumPlusMinus maximalnterestRateCoefficientAction;
}
