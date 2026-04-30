package recipeBook.service;

import org.springframework.stereotype.Service;
import recipeBook.repository.UserRepository;
import recipeBook.entity.User;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
