package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "tpp_product_register")
public class TppProductRegister {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "product_id", nullable = true)
    private Long productId;
    @Basic
    @Column(name = "type", nullable = false, length = 100)
    private String type;
    @Basic
    @Column(name = "account", nullable = true)
    private Long account;
    @Basic
    @Column(name = "currency_code", nullable = true, length = 30)
    private String currencyCode;
    @Basic
    @Column(name = "state", nullable = true, length = 50)
    private String state;
    @Basic
    @Column(name = "account_number", nullable = true, length = 25)
    private String accountNumber;
}
