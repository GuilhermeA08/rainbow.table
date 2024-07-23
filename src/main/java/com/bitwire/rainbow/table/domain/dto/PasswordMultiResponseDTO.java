package com.bitwire.rainbow.table.domain.dto;

import com.bitwire.rainbow.table.domain.model.Password;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PasswordMultiResponseDTO {
    private List<Password> newPasswords;
    private List<Password> known;

    public PasswordMultiResponseDTO() {
        this.newPasswords = new ArrayList<Password>();
        this.known = new ArrayList<Password>();
    }
}
