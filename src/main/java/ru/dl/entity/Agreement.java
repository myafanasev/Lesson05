package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "agreement")
public class Agreement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "product_id", nullable = true)
    private Long productId;
    @Basic
    @Column(name = "general_agreement_id", nullable = true, length = 50)
    private String generalAgreementId;
    @Basic
    @Column(name = "supplementary_agreement_id", nullable = true, length = 50)
    private String supplementaryAgreementId;
    @Basic
    @Column(name = "arrangement_type", nullable = true, length = 50)
    private String arrangementType;
    @Basic
    @Column(name = "sheduler_job_id", nullable = true)
    private Long shedulerJobId;
    @Basic
    @Column(name = "number", nullable = true, length = 50)
    private String number;
    @Basic
    @Column(name = "opening_date", nullable = true)
    private Timestamp openingDate;
    @Basic
    @Column(name = "closing_date", nullable = true)
    private Timestamp closingDate;
    @Basic
    @Column(name = "cancel_date", nullable = true)
    private Timestamp cancelDate;
    @Basic
    @Column(name = "validity_duration", nullable = true)
    private Long validityDuration;
    @Basic
    @Column(name = "cancellation_reason", nullable = true, length = 100)
    private String cancellationReason;
    @Basic
    @Column(name = "status", nullable = true, length = 50)
    private String status;
    @Basic
    @Column(name = "interest_calculation_date", nullable = true)
    private Timestamp interestCalculationDate;
    @Basic
    @Column(name = "interest_rate", nullable = true, precision = 0)
    private Double interestRate;
    @Basic
    @Column(name = "coefficient", nullable = true, precision = 0)
    private Double coefficient;
    @Basic
    @Column(name = "coefficient_action", nullable = true, length = 50)
    private String coefficientAction;
    @Basic
    @Column(name = "minimum_interest_rate", nullable = true, precision = 0)
    private Double minimumInterestRate;
    @Basic
    @Column(name = "minimum_interest_rate_coefficient", nullable = true, precision = 0)
    private Double minimumInterestRateCoefficient;
    @Basic
    @Column(name = "minimum_interest_rate_coefficient_action", nullable = true, length = 50)
    private String minimumInterestRateCoefficientAction;
    @Basic
    @Column(name = "maximal_interest_rate", nullable = true, precision = 0)
    private Double maximalInterestRate;
    @Basic
    @Column(name = "maximal_interest_rate_coefficient", nullable = true, precision = 0)
    private Double maximalInterestRateCoefficient;
    @Basic
    @Column(name = "maximal_interest_rate_coefficient_action", nullable = true, length = 50)
    private String maximalInterestRateCoefficientAction;

    public Agreement() {
    }

    public Agreement(Long productId, String generalAgreementId, String supplementaryAgreementId, String arrangementType, Long shedulerJobId, String number, Timestamp openingDate, Timestamp closingDate, Timestamp cancelDate, Long validityDuration, String cancellationReason, String status, Timestamp interestCalculationDate, Double interestRate, Double coefficient, String coefficientAction, Double minimumInterestRate, Double minimumInterestRateCoefficient, String minimumInterestRateCoefficientAction, Double maximalInterestRate, Double maximalInterestRateCoefficient, String maximalInterestRateCoefficientAction) {
        this.productId = productId;
        this.generalAgreementId = generalAgreementId;
        this.supplementaryAgreementId = supplementaryAgreementId;
        this.arrangementType = arrangementType;
        this.shedulerJobId = shedulerJobId;
        this.number = number;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.cancelDate = cancelDate;
        this.validityDuration = validityDuration;
        this.cancellationReason = cancellationReason;
        this.status = status;
        this.interestCalculationDate = interestCalculationDate;
        this.interestRate = interestRate;
        this.coefficient = coefficient;
        this.coefficientAction = coefficientAction;
        this.minimumInterestRate = minimumInterestRate;
        this.minimumInterestRateCoefficient = minimumInterestRateCoefficient;
        this.minimumInterestRateCoefficientAction = minimumInterestRateCoefficientAction;
        this.maximalInterestRate = maximalInterestRate;
        this.maximalInterestRateCoefficient = maximalInterestRateCoefficient;
        this.maximalInterestRateCoefficientAction = maximalInterestRateCoefficientAction;
    }
}
