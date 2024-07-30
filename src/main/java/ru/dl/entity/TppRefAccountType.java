package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "tpp_ref_account_type")
public class TppRefAccountType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "internal_id", nullable = false)
    private Long internalId;
    @Basic
    @Column(name = "value", nullable = false, length = 100)
    private String value;
}
