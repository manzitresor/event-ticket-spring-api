package com.thegym.eventtickets.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class CreateTypeResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Integer totalAvailable;
}
