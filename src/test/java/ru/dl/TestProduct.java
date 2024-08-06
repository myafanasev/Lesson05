package ru.dl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.dl.entity.Agreement;
import ru.dl.entity.TppProduct;
import ru.dl.entity.TppProductRegister;
import ru.dl.model.*;
import ru.dl.repo.AgreementRepo;
import ru.dl.repo.TppProductRegisterRepo;
import ru.dl.repo.TppProductRepo;
import ru.dl.response.AccountResponse;
import ru.dl.response.ProductResponse;
import ru.dl.service.AccountService;
import ru.dl.service.ProductService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestProduct {

    @Autowired
    AccountService accountService; // обработка запроса создания продуктового регистра
    @Autowired
    ProductService productService; // обработка запроса создания нового объекта ЭКЗЕМПЛЯР ПРОДУКТА
    @Autowired
    TppProductRegisterRepo repoTppProductRegister;
    @Autowired
    TppProductRepo repoTppProduct;
    @Autowired
    AgreementRepo repoAgreement;

    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine").withInitScript("schema.sql");

    @BeforeAll
    static void beforeAll() {postgres.start();}

    @AfterAll
    static void afterAll() {postgres.stop();}

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    @DisplayName("Проверка создания продуктового регистра")
    void testAccount() {
        repoTppProductRegister.deleteAll();
        // готовим данные
        ModelAccount modelAccount = new ModelAccount(
                16L,
                "03.012.002_47533_ComSoLd",
                "Пассивный",
                "800",
                "0022",
                "00",
                "15",
                null,
                null,
                null,
                null
        );
        AccountResponse accountResponse = accountService.make(modelAccount);

        List<TppProductRegister> regs = repoTppProductRegister.findAll();
        Assertions.assertEquals(1, regs.size());   //должна быть создана 1 запись
    }
    @Test
    @DisplayName("Проверка создания экземпляра продукта")
    void testProduct() {
        repoTppProductRegister.deleteAll();
        repoTppProduct.deleteAll();
        // готовим данные
        List<ModelAgreement> instanceArrangement = new ArrayList<>();
        instanceArrangement.add
                (
                        new ModelAgreement
                                (
                                        "155",
                                        "156",
                                        EnumTypeAgreement.ЕЖО,
                                        1L,
                                        "DS-161",
                                        Timestamp.valueOf("2024-01-02 00:00:00.000"),
                                        Timestamp.valueOf("2025-01-02 00:00:00.000"),
                                        null,
                                        12L,
                                        "Изменение планов",
                                        "Открыт",
                                        Timestamp.valueOf("2024-01-03 00:00:00.000"),
                                        2.36,
                                        2.0,
                                        EnumPlusMinus.HIGHT,
                                        1.05,
                                        3.0,
                                        EnumPlusMinus.LOW,
                                        5.25,
                                        9.0,
                                        EnumPlusMinus.HIGHT
                                )
                );
        ModelProduct modelProduct = new ModelProduct(
                null,
                EnumTypeAgreement.НСО,
                "03.012.002",
                "03.012.002_47533_ComSoLd",
                15L,
                "N100",
                Timestamp.valueOf("2024-01-02 00:00:00.000"),
                1L,
                1.25,
                5.23,
                8.14,
                "ecamlpe",
                EnumRateType.DIFFERENT,
                0.25,
                0.29,
                28,
                "0022",
                "800",
                "00",
                3,
                null,
                instanceArrangement
                );
        ProductResponse accountResponse = productService.make(modelProduct);

        List<TppProduct> regs = repoTppProduct.findAll();
        Assertions.assertEquals(1, regs.size());   // должна быть создана 1 запись

        List<Agreement> agr = repoAgreement.findAll();
        Assertions.assertEquals(1, agr.size());   // и здесь должна быть создана 1 запись
    }
}