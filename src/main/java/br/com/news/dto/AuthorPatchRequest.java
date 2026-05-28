package br.com.news.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorPatchRequest {
    private String name;

    private String email;

    private String password;

    private LocalDate birthDate;

    private String education;

    private String signature;

    private Boolean isEditor;
}
