package com.bitwire.rainbow.table.service.impl;

import com.bitwire.rainbow.table.domain.model.Password;
import com.bitwire.rainbow.table.domain.repository.PasswordRepository;
import com.bitwire.rainbow.table.service.PasswordServiceInterface;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

@Service
public class PasswordService implements PasswordServiceInterface {

    private final int SHA256_HASH_SIZE = 64;

    @Autowired
    private PasswordRepository passwordRepository;

    private String plainTextToHash(String plainText) {
        return Hashing.sha256().hashString(plainText, StandardCharsets.UTF_8).toString();
    }


    @Override
    public Password findById(Long id) {
        return passwordRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Password create(Password password) {
        String plainText = password.getPlainText();
        String hash = Hashing.sha256().hashString(plainText, StandardCharsets.UTF_8).toString();

        password.setHash(hash);

        var passwordAlreadyExist = this.findByHash(hash);

        if (passwordAlreadyExist != null) {
            throw new IllegalArgumentException("Password already exists");
        }

        return passwordRepository.save(password);
    }

    @Override
    public Password update(Password password) {
        return null;
    }

    @Override
    public void delete(Long id) {
         passwordRepository.deleteById(id);
    }

    @Override
    public Password findByHash(String hash) {
        if (hash == null) {
            throw new IllegalArgumentException("Hash is required");
        }
        // Verifica tamanho do hash sha256
        if (hash.length() != SHA256_HASH_SIZE){
            throw new IllegalArgumentException("Hash must be 64 characters long");
        }

        var password = passwordRepository.findByHash(hash);

        return password.orElse(null);
    }

    @Override
    public Password verify(String plainText) {
        var hash = this.plainTextToHash(plainText);

        return this.findByHash(hash);
    }
}
