package com.example.examproject_restapi1.DTO.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {
    private Long id;

    private String groupName;

    private LocalDate dateOfStart;

    private String image;

    private int count;
}
