package com.ryanshores.wisdompet.data.repositories;

import com.ryanshores.wisdompet.data.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Optional<Account> findOneByEmail(String email);
}
