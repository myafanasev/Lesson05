package ru.dl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "tpp_ref_product_class")
public class TppRefProductClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "internal_id", nullable = false)
    private Long internalId;
    @Basic
    @Column(name = "value", nullable = false, length = 100)
    private String value;
    @Basic
    @Column(name = "gbi_code", nullable = true, length = 50)
    private String gbiCode;
    @Basic
    @Column(name = "gbi_name", nullable = true, length = 100)
    private String gbiName;
    @Basic
    @Column(name = "product_row_code", nullable = true, length = 50)
    private String productRowCode;
    @Basic
    @Column(name = "product_row_name", nullable = true, length = 100)
    private String productRowName;
    @Basic
    @Column(name = "subclass_code", nullable = true, length = 50)
    private String subclassCode;
    @Basic
    @Column(name = "subclass_name", nullable = true, length = 100)
    private String subclassName;
}
