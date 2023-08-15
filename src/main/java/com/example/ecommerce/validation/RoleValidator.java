package com.example.ecommerce.validation;

import com.example.ecommerce.util.Roles;
import com.example.ecommerce.validation.annotation.ValidRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleValidator implements ConstraintValidator<ValidRole, String> {
    private final List<String> allowedRoles = Arrays
            .stream(Roles.values())
            .map(Roles::getValue)
            .toList();

    @Override
    public boolean isValid(String role, ConstraintValidatorContext context) {
        return role != null && allowedRoles.contains(role);
    }
}
