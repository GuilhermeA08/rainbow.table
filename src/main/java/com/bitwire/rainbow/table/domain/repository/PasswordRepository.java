package com.bitwire.rainbow.table.domain.repository;

import com.bitwire.rainbow.table.domain.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordRepository  extends JpaRepository<Password, Long> {

    public Optional<Password> findByHash(String hash);
}
