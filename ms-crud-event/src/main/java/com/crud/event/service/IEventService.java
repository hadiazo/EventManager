package com.crud.event.service;

import com.crud.event.model.Event;

import java.util.List;

public interface IEventService {
    public List<Event> findAll();
    public int save(Event event);
    public int update(Event event);
    public int deleteById(int id);
}
