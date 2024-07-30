package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dl.entity.TppProductRegister;

public interface TppProductRegisterRepo extends JpaRepository<TppProductRegister, Long> {
}
