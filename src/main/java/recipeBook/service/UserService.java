package recipeBook.service;

import org.springframework.stereotype.Service;
import recipeBook.repository.UserRepository;
import recipeBook.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(String email, String password) {
        Optional<User> foundUser = userRepository.findUserByEmail(email);
            if (foundUser.isPresent() && foundUser.get().getPassword().equals(password)) {
                return foundUser.get();
            }
        throw new RuntimeException("Invalid email or password");
    }
}
