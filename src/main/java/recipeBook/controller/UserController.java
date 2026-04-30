package recipeBook.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipeBook.entity.User;
import recipeBook.service.UserService;

@CrossOrigin(origins="http://localhost:5173")

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users") //this has to match the fetch on the UserService in front end for them to have different endpoints
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
