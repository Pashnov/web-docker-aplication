package com.example.Spring_Boot_Application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    private String id;
    private String name;
    private String description;

}
