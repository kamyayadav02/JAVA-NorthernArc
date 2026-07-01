package org.northernarc.springdatajpademo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long id;
    @NotBlank
    private String name;
    private String dept;
    @Email
    private String email;
}
