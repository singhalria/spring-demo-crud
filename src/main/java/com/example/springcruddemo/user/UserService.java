package com.example.springcruddemo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(String id, User user) {
        Optional<User> optionalUser = userRepository.findById(Integer.parseInt(id));

        if (!optionalUser.isPresent()) {
            System.out.println("User not found");
            return null;
        }

        User data = optionalUser.get();

        data.setName(user.getName());
        data.setPrice(user.getPrice());
        data.setStock(user.getStock());

        return userRepository.save(data);
    }

    public String delete(String id) {
        Optional<User> optionalUser = userRepository.findById(Integer.parseInt(id));

        if (!optionalUser.isPresent()) {
            System.out.println("User not found");
            return null;
        }

        userRepository.deleteById(Integer.parseInt(id));  // to covert string to integer
        return "User Delete";
    }
  

    
}
