package com.agata.jeeshop.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class OrderFormDto {

    @NotEmpty
    @Size(min = 5, message = "Imie musi miec minimum 5 znaków.")
    private String firstName;

    @NotEmpty
    @Size(min = 5, message = "Nazwisko musi miec minimum 5 znaków.")
    private String lastName;

    @NotEmpty
    @Email(message = "Email jest niepoprawny.")
    private String email;
}
