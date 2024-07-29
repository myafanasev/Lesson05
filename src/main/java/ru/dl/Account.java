package ru.dl;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column
    private Boolean bussy;
}
