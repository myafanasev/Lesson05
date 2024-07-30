package ru.dl;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettlementAccount {
    @NotNull(message = "Имя обязательного параметра instanceId не заполнено")
    private Long instanceId;
    private String registryTypeCode;
    private String accountType;
    private String currencyCode;
    private String branchCode;
    private String priorityCode;
    private String mdnCode;
    private String clientCode;
    private String trainRegion;
    private String counter;
    private String salesCode;
}
