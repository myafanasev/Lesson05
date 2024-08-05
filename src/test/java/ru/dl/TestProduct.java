package ru.dl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.dl.entity.TppProductRegister;
import ru.dl.model.ModelAccount;
import ru.dl.repo.TppProductRegisterRepo;
import ru.dl.response.AccountResponse;
import ru.dl.service.AccountService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestProduct {

    @Autowired
    AccountService accountService; // обработка запроса создания продуктового регистра

    @Autowired
    TppProductRegisterRepo repoTppProductRegister;

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
        // готовим данные
        ModelAccount modelAccount = new ModelAccount(
                15L,
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
}