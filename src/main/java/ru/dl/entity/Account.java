package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "account_pool_id", nullable = true)
    private Long accountPoolId;
    @Basic
    @Column(name = "account_number", nullable = true, length = 25)
    private String accountNumber;
    @Basic
    @Column(name = "bussy", nullable = true)
    private Boolean bussy;
}
