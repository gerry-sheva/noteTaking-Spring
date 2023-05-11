package com.sheva.notetaking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequest {

    private Integer uid;
    private Integer id;
    private String title;
    private String message;
}
