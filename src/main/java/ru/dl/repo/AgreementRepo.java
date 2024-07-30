package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dl.entity.Agreement;

public interface AgreementRepo extends JpaRepository<Agreement, Long> {
}
