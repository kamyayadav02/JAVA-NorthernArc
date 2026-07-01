package org.northernarc.springdatajpademo2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponseDTO {
    private int id;
    @NotBlank
    private String name;
}
