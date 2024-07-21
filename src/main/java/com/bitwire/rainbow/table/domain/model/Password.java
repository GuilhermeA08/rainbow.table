package com.bitwire.rainbow.table.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plainText;
    @Column(unique = true)
    private String hash;

    public Password(String plainText, String hash) {
        this.plainText = plainText;
        this.hash = hash;
    }

}
