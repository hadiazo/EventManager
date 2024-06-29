package com.crud.event.repository;

import java.util.List;
import com.crud.event.model.Event;

public interface IEventRepository {
    public List<Event> findAll();
    public int save(Event event);
    public int update(Event event);
    public int deleteById(int id);
}
