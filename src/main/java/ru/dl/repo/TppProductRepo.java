package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dl.entity.TppProduct;

public interface TppProductRepo extends JpaRepository<TppProduct, Long> {
}
