package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dl.entity.TppProductRegister;

import java.util.List;

public interface TppProductRegisterRepo extends JpaRepository<TppProductRegister, Long> {
    // поиск продуктового регистра по product_id и type
   @Query("select r.id from TppProductRegister r where r.productId = ?1 and r.type = ?2")
    Long getIdByProductIdAndType(Long productId, String type);
}
