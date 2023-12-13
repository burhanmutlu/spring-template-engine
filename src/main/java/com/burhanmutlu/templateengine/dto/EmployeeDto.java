package com.burhanmutlu.templateengine.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private Long id;

    private String name;

    private String email;

}
