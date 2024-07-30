package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dl.entity.AccountPool;

public interface AccountPoolRepo extends JpaRepository<AccountPool, Long> {
}
