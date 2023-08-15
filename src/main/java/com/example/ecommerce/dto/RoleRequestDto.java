package com.example.ecommerce.dto;

import com.example.ecommerce.validation.annotation.ValidRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestDto {
    @ValidRole(message = "Role must be either 'buyer' or 'seller'")
    private String name;
}
