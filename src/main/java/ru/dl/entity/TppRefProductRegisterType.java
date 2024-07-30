package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "tpp_ref_product_register_type")
public class TppRefProductRegisterType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "internal_id", nullable = false)
    private Integer internalId;
    @Basic
    @Column(name = "value", nullable = false, length = 100)
    private String value;
    @Basic
    @Column(name = "register_type_name", nullable = false, length = 100)
    private String registerTypeName;
    @Basic
    @Column(name = "product_class_code", nullable = false, length = 100)
    private String productClassCode;
    @Basic
    @Column(name = "register_type_start_date", nullable = true)
    private Timestamp registerTypeStartDate;
    @Basic
    @Column(name = "register_type_end_date", nullable = true)
    private Timestamp registerTypeEndDate;
    @Basic
    @Column(name = "account_type", nullable = true, length = 100)
    private String accountType;
}
