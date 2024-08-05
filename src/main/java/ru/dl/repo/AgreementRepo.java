package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dl.entity.Agreement;

public interface AgreementRepo extends JpaRepository<Agreement, Long> {

    @Query("select a.id from Agreement a where a.number = ?1")
    Long getIdByNumber(String number);
}
