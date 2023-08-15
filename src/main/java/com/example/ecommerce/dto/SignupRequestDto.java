package com.example.ecommerce.dto;

import com.example.ecommerce.validation.annotation.ValidRole;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//{firstName, lastName, email, password, role}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @ValidRole(message = "Role must be either 'buyer' or 'seller'")
    private String role;


}
