package ru.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dl.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
