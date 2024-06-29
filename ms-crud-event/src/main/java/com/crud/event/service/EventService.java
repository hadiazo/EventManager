package com.crud.event.service;

import com.crud.event.model.Event;
import com.crud.event.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {
    @Autowired
    private IEventRepository iEventRepository;

    @Override
    public List<Event> findAll() {
        List<Event> list;
        try {
            list = iEventRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    @Override
    public int save(Event event) {
        int row;
        try {
            row = iEventRepository.save(event);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int update(Event event) {
        int row;
        try {
            row = iEventRepository.update(event);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = iEventRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }
}
