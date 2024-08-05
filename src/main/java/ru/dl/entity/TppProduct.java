package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "tpp_product")
public class TppProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "product_code_id", nullable = true)
    private Long productCodeId;
    @Basic
    @Column(name = "client_id", nullable = true)
    private Long clientId;
    @Basic
    @Column(name = "type", nullable = true, length = 50)
    private String type;
    @Basic
    @Column(name = "number", nullable = true, length = 50)
    private String number;
    @Basic
    @Column(name = "priority", nullable = true)
    private Long priority;
    @Basic
    @Column(name = "date_of_conclusion", nullable = true)
    private Timestamp dateOfConclusion;
    @Basic
    @Column(name = "start_date_time", nullable = true)
    private Timestamp startDateTime;
    @Basic
    @Column(name = "end_date_time", nullable = true)
    private Timestamp endDateTime;
    @Basic
    @Column(name = "days", nullable = true)
    private Long days;
    @Basic
    @Column(name = "penalty_rate", nullable = true, precision = 0)
    private Double penaltyRate;
    @Basic
    @Column(name = "nso", nullable = true, precision = 0)
    private BigInteger nso;
    @Basic
    @Column(name = "threshold_amount", nullable = true, precision = 0)
    private Double thresholdAmount;
    @Basic
    @Column(name = "requisite_type", nullable = true, length = 50)
    private String requisiteType;
    @Basic
    @Column(name = "interest_rate_type", nullable = true, length = 50)
    private String interestRateType;
    @Basic
    @Column(name = "tax_rate", nullable = true, precision = 0)
    private Double taxRate;
    @Basic
    @Column(name = "reasone_close", nullable = true, length = 100)
    private String reasoneClose;
    @Basic
    @Column(name = "state", nullable = true, length = 50)
    private String state;

    public TppProduct() {}

    public TppProduct(Long productCodeId, Long clientId, String type, String number, Long priority, Timestamp dateOfConclusion, Timestamp startDateTime, Timestamp endDateTime, Long days, Double penaltyRate, BigInteger nso, Double thresholdAmount, String requisiteType, String interestRateType, Double taxRate, String reasoneClose, String state) {
        this.productCodeId = productCodeId;
        this.clientId = clientId;
        this.type = type;
        this.number = number;
        this.priority = priority;
        this.dateOfConclusion = dateOfConclusion;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.days = days;
        this.penaltyRate = penaltyRate;
        this.nso = nso;
        this.thresholdAmount = thresholdAmount;
        this.requisiteType = requisiteType;
        this.interestRateType = interestRateType;
        this.taxRate = taxRate;
        this.reasoneClose = reasoneClose;
        this.state = state;
    }
}
