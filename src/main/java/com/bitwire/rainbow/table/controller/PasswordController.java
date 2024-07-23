package com.bitwire.rainbow.table.controller;

import com.bitwire.rainbow.table.domain.dto.PasswordMultiResponseDTO;
import com.bitwire.rainbow.table.domain.model.Password;
import com.bitwire.rainbow.table.service.PasswordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private  PasswordServiceInterface passwordService;

    @PostMapping("/hash")
    public ResponseEntity<Password> getHash(@RequestBody Password password) {
        var hash = password.getHash();
        return ResponseEntity.ok(passwordService.findByHash(hash));
    }

    @PostMapping("/hash/multi")
    public ResponseEntity<PasswordMultiResponseDTO> getHashMulti(@RequestBody List<String> passwords) {
        return ResponseEntity.ok(passwordService.createMany(passwords));
    }

    @PostMapping("plainText/create")
    public ResponseEntity<Password> create(@RequestBody Password password) {
        return ResponseEntity.ok(passwordService.create(password));
    }

    @PostMapping("plainText/verify")
    public ResponseEntity<Password> verify(@RequestBody Password password) {
        return ResponseEntity.ok(passwordService.verify(password.getPlainText()));
    }
}
