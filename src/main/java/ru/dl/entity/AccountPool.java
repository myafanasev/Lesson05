package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "account_pool")
public class AccountPool {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "branch_code", nullable = true, length = 50)
    private String branchCode;
    @Basic
    @Column(name = "currency_code", nullable = true, length = 30)
    private String currencyCode;
    @Basic
    @Column(name = "mdm_code", nullable = true, length = 50)
    private String mdmCode;
    @Basic
    @Column(name = "priority_code", nullable = true, length = 30)
    private String priorityCode;
    @Basic
    @Column(name = "registry_type_code", nullable = true, length = 50)
    private String registryTypeCode;
}
