package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dl.entity.TppRefProductRegisterType;

import java.util.List;

public interface TppRefProductRegisterTypeRepo extends JpaRepository<TppRefProductRegisterType, Long> {
    TppRefProductRegisterType findByValue(String value);
    @Query("select r.value from TppRefProductRegisterType r, TppRefProductClass c where c.value = ?1 and c.value = r.productClassCode and r.accountType = \"Клиентский\"")
    List<String> getValuesByProductCode(String productCode);
}
