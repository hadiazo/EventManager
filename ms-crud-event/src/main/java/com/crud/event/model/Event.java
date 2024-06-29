package com.crud.event.model;

import lombok.Data;

@Data
public class Event {
    int id;
    String title;
    String description;
    String date;
    String place;
}
