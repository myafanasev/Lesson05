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
    private BigInteger penaltyRate;
    @Basic
    @Column(name = "nso", nullable = true, precision = 0)
    private BigInteger nso;
    @Basic
    @Column(name = "threshold_amount", nullable = true, precision = 0)
    private BigInteger thresholdAmount;
    @Basic
    @Column(name = "requisite_type", nullable = true, length = 50)
    private String requisiteType;
    @Basic
    @Column(name = "interest_rate_type", nullable = true, length = 50)
    private String interestRateType;
    @Basic
    @Column(name = "tax_rate", nullable = true, precision = 0)
    private BigInteger taxRate;
    @Basic
    @Column(name = "reasone_close", nullable = true, length = 100)
    private String reasoneClose;
    @Basic
    @Column(name = "state", nullable = true, length = 50)
    private String state;
}
