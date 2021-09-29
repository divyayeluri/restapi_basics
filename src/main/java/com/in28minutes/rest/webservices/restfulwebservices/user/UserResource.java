package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResource {
        @Autowired
        private UserDaoService service;
        @GetMapping("/users")
        public List<User> retrieveAllUsers()
        {
            return service.findAll();
        }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)
    {
       User  user =service.findOne(id);
       if(user == null){
           throw new UserNotFoundException("id" + id);
       }
        return user;
    }
    @PostMapping("/users")
    public void CreateUser(@Valid @RequestBody User user)
    {

        User saved =service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable int id)
    {
        User  user =service.deleteById(id);
        if(user == null){
            throw new UserNotFoundException("id" + id);
        }
        return user;
    }
}

