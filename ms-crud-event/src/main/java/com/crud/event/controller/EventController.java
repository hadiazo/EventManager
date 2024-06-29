package com.crud.event.controller;

import com.crud.event.model.Event;
import com.crud.event.model.ServiceResponse;
import com.crud.event.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController {
    @Autowired
    private IEventService iEventService;

    @GetMapping("/list")
    public ResponseEntity<List<Event>> list() {
        var result = iEventService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Event event){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iEventService.save(event);
        if(result ==1){
            serviceResponse.setMessage("Item saved with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Event event){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iEventService.update(event);
        if (result == 1) {
            serviceResponse.setMessage("Item update with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iEventService.deleteById(id);
        if (result == 1) {
            serviceResponse.setMessage("Item removed with success");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

}
