package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private  String ownerName;
    @NotNull(message = "Email is mandatory")
    @NotEmpty(message = "Email cannot be null")
    @Size(min = 1, max = 50, message = "Email should be between 1 to 50 characters long")
    private  String ownerEmail;
    private  String phone;
    @NotEmpty(message = "Password cannot be empty")
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password should be between 1 to 16 characters long")
    private  String password;
}
