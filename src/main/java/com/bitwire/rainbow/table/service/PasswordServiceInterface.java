package com.bitwire.rainbow.table.service;

import com.bitwire.rainbow.table.domain.model.Password;

public interface PasswordServiceInterface extends CrudServiceInterface<Password>{
    Password findByHash(String hash);
    Password verify(String plainText);
}
