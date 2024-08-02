package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dl.entity.TppProductRegister;

import java.util.List;

public interface TppProductRegisterRepo extends JpaRepository<TppProductRegister, Long> {
    // поиск продуктового регистра по product_id и type
    List<TppProductRegister> findAllByProductIdAndType(Long productId, String type);
}
