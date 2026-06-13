package recipeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import recipeBook.entity.User;

import java.util.Optional;

@CrossOrigin(origins="http://localhost:5173", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})//allows spring to speak to my front end regardless of port numbers

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
