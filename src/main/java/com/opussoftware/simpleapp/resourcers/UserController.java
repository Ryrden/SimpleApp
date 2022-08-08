package com.opussoftware.simpleapp.resourcers;

import com.opussoftware.simpleapp.domain.User;
import com.opussoftware.simpleapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id ){
        User object = this.service.findById(id);
        return ResponseEntity.ok().body(object);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> usersList = service.findAll();
        return ResponseEntity.ok().body(usersList);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @Valid @RequestBody User object){
        User newObject = service.update(id,object);
        return ResponseEntity.ok().body(newObject);
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User object){
        User newObject = service.create(object);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObject.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
