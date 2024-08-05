package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dl.entity.TppProduct;

import java.util.List;

public interface TppProductRepo extends JpaRepository<TppProduct, Long> {
    @Query("select p.id from TppProduct p where p.number = ?1")
    Long getIdByNumber(String number);
    TppProduct findFirstById(Long id);
}
