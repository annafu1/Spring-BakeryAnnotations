package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinController {
    private MuffinService service;
    @Autowired
    public MuffinController(MuffinService service) {
        this.service = service;
    }
    @RequestMapping(value = "/muffins/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }
    @RequestMapping(value = "/muffins/{id}", method = RequestMethod.GET)
    public ResponseEntity<Muffin> show(Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/muffins/", method = RequestMethod.POST)
    public ResponseEntity<Muffin> create(Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/muffins/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Muffin> update(Long id,Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @RequestMapping(value = "/muffins/destroy/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
