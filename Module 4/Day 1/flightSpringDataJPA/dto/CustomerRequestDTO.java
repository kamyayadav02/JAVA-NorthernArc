package org.northernarc.springdatajpademo2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerRequestDTO {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    private String phoneno;
}
