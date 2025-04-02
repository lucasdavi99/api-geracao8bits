package com.geracaooitobits.api.services;

import com.geracaooitobits.api.dtos.RegisterDTO;
import com.geracaooitobits.api.entities.User;
import com.geracaooitobits.api.enums.Role;
import com.geracaooitobits.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User createUser(RegisterDTO data){
        if(repository.findByEmail(data.email()) != null) {
            throw new RuntimeException("Email já cadastrado!");
        }

        User newUser = new User();
        newUser.setName(data.name());
        newUser.setEmail(data.email());
        newUser.setPassword(new BCryptPasswordEncoder().encode(data.password()));
        newUser.setPhone(data.phone());
        newUser.setRole(Role.USER);

        return repository.save(newUser);
    }
}
