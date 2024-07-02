package com.crud.event.repository;

import com.crud.event.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository implements IEventRepository {
    @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    @Override
    public List<Event> findAll() {
        String sql = "SELECT * FROM event WHERE status = 1";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Event.class));
    }

    @Override
    public int save(Event event) {
        //String sql = "INSERT INTO event VALUES (?, ?, ?, ?, ?)";
        String sql = "INSERT INTO event (title, description, date, place, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{event.getTitle(),
                event.getDescription(), event.getDate(), event.getPlace(), event.getStatus()});
    }

    @Override
    public int update(Event event) {
        String sql = "UPDATE event SET title = ?, description = ?, date = ?, place = ? WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[]{event.getTitle(), event.getDescription(),
                event.getDate(), event.getPlace(), event.getId()});
    }

    @Override
    public int deleteById(int id) {
        String sql = "UPDATE event SET status=0 WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }
}
