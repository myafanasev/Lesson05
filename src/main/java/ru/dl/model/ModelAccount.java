package ru.dl.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelAccount {
    @NotNull(message = "Имя обязательного параметра instanceId не заполнено")
    private Long instanceId;            // Идентификатор экземпляра продукта
    private String registryTypeCode;    // Тип регистра
    private String accountType;         // Тип счета
    private String currencyCode;        // Код валюты
    private String branchCode;          // Код филиала
    private String priorityCode;        // Код срочности
    private String mdmCode;             // Id клиента
    private String clientCode;          // Код клиента
    private String trainRegion;         // Регион принадлежности железной дороги
    private String counter;             // Счетчик
    private String salesCode;           // Код точки продаж
}
