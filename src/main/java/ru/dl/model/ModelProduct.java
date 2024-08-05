package ru.dl.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelProduct {
    private Long instanceId;
    @NotNull(message = "Имя обязательного параметра productType не заполнено")
    private EnumTypeAgreement productType;
    @NotNull(message = "Имя обязательного параметра productCode не заполнено")
    private String productCode;
    @NotNull(message = "Имя обязательного параметра registerType не заполнено")
    private String registerType;
    @NotNull(message = "Имя обязательного параметра mdmCode не заполнено")
    private Long mdmCode;
    @NotNull(message = "Имя обязательного параметра contractNumber не заполнено")
    private String contractNumber;
    @NotNull(message = "Имя обязательного параметра contractDate не заполнено")
    private Timestamp contractDate;
    @NotNull(message = "Имя обязательного параметра priority не заполнено")
    private Long priority;
    private Double interestRatePenalty;
    private Double minimalBalance;
    private Double thresholdAmount;
    private String accountingDetails;

    private EnumRateType rateType;
    private Double taxPercentageRate;
    private Double technicalOverdraftLimitAmount;
    @NotNull(message = "Имя обязательного параметра contractId не заполнено")
    Integer contractId;
    @NotNull(message = "Имя обязательного параметра branchCode не заполнено")
    private String branchCode;
    @NotNull(message = "Имя обязательного параметра isoCurrencyCode не заполнено")
    private String isoCurrencyCode;
    @NotNull(message = "Имя обязательного параметра urgencyCode не заполнено")
    private String urgencyCode;
    Integer referenceCode;
    private ModelProp additionalPropertiesVip;
    private List<ModelAgreement> instanceArrangement = new ArrayList<>();
}
