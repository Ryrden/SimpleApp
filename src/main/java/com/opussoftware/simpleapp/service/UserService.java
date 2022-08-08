package com.opussoftware.simpleapp.service;

import com.opussoftware.simpleapp.domain.User;
import com.opussoftware.simpleapp.repositories.UserRepository;
import com.opussoftware.simpleapp.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findById(Integer id){
        Optional<User> object = repository.findById(id);
        return object.orElseThrow( () -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + User.class.getName()));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(Integer id, User object) {
        User newObject = findById(id);
        newObject.setName(object.getName());
        newObject.setLogin(object.getLogin());
        newObject.setPassword(object.getPassword());
        return repository.save(newObject); //The Save is interpreted as update because the same ID
    }

    public User create(User object) {
        object.setId(null); //Setting ID as null makes JPA infer
        return repository.save(object);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
