package br.com.springboot.demo.controller;

import br.com.springboot.demo.model.User;
import br.com.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){

        System.out.println("O id é " + id);

        Optional<User> userFind = users.stream().filter(user -> Objects.equals(user.getId(), id)).findFirst();

        if (userFind.isPresent()){
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public User postUser(@RequestBody User user){
        this.userRepository.save(user);
        // users.add(user); // Não vamos mais salvar na lista, mas sim no repositório
        return user;
    }

    @GetMapping("/list")
    public List<User> list() {
        return users;
    }



}

