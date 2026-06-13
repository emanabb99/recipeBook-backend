package recipeBook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipeBook.entity.User;
import recipeBook.service.UserService;

import java.util.Map;

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

    @PostMapping("login")
    public ResponseEntity<?> getUser(@RequestBody Map<String,String> loginCredentials){
        try {
            String email = loginCredentials.get("email");
            String password = loginCredentials.get("password");
            User user = userService.getUser(email, password);
            return ResponseEntity.ok(user);
        }
        catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
