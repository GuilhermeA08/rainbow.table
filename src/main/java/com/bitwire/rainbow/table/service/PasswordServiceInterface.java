package com.bitwire.rainbow.table.service;

import com.bitwire.rainbow.table.domain.dto.PasswordMultiResponseDTO;
import com.bitwire.rainbow.table.domain.model.Password;

import java.util.List;

public interface PasswordServiceInterface extends CrudServiceInterface<Password>{
    Password findByHash(String hash);
    Password verify(String plainText);
    PasswordMultiResponseDTO createMany(List<String> passwords);
}
