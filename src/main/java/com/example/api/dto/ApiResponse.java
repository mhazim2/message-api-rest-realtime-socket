package com.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The api response transaction model.
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponse {
    private Boolean success;
    private String message;
}
