package recipeBook.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false) //ensures email is unique and cant be null
    private String email;
    private String password;

    @OneToMany (mappedBy = "user")//this has to match the User user in recipe
    @JsonIgnore
    private List<Recipe> recipes;

}
