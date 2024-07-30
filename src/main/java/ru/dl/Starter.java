package ru.dl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.dl.repo.AccountRepo;

@SpringBootApplication(scanBasePackages = "ru.dl")
public class Starter {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Starter.class, args);
        System.out.println("Привет, Мир!");

        AccountRepo accountRepo = ctx.getBean(AccountRepo.class);
        accountRepo.findAll().stream().forEach(System.out::println);
    }
}
