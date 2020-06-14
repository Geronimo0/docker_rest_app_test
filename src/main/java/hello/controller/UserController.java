package hello.controller;

import hello.models.User;
import hello.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/addUser/{name}/{age}")
    public String addUser(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age) throws SQLException {

        User user = new User(name, age);
        UserService us = new UserService();
        us.addUser(user);
        return user.toString();

    }

    @DeleteMapping("/delUser/{id}")
    public String delUser(
            @PathVariable("id") Long id) throws SQLException {

        UserService us = new UserService();
        User user = us.getUserBuId(id);
        us.deleteUser(user);
        return user.toString();
    }

    @GetMapping("/userById/{id}")
    public String getUserById(
            @PathVariable("id") Long id) throws SQLException {

        UserService us = new UserService();
        User user = us.getUserBuId(id);
        return user.toString();
    }

    @GetMapping("/allUsers")
    public String getAllUsers() throws SQLException {

        UserService us = new UserService();
        List<User> users = us.getAllUsers();
        return users.toString();
    }



    @RequestMapping("/script")
    public void script(){
        UserService us = new UserService();
        us.script();
    }
}
