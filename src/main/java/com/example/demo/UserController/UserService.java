package com.example.demo.UserController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    static List<User> users = new ArrayList<>();
    int usersCount = 3;

    static {
        users.add(new User(1, "Rishab", new Date()));
        users.add(new User(2, "Raja", new Date()));
        users.add(new User(3, "Princy", new Date()));
    }

    public List<User> getUsers() {
        return users;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if (user.getId() == 0) {
        user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }
}
