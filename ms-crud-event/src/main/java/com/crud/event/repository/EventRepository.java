package com.crud.event.repository;

import com.crud.event.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class EventRepository implements IEventRepository {
    @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    @Override
    public List<Event> findAll() {
        String sql = "SELECT * FROM event";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Event.class));
    }

    @Override
    public int save(Event event) {
        String sql = "INSERT INTO event VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{event.getId(), event.getTitle(),
                event.getDescription(), event.getDate(), event.getPlace()});
    }

    @Override
    public int update(Event event) {
        String sql = "UPDATE event SET title = ?, description = ?, date = ?, place = ? WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[]{event.getId(), event.getTitle(),
                event.getDescription(), event.getDate(), event.getPlace()});
    }

    @Override
    public int deleteById(int id) {
        String sql = "UPDATE event SET status=0 WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }
}
