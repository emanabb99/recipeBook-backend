package recipeBook.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="recipe") //store this entity in a table called RECIPES
@Getter //automatically does getter methods
@Setter //automatically does setter methods
@NoArgsConstructor //will run the class without using arguments

public class Recipe {

    @Id //we need this as its used as a database tracking number
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //we dont have to set the ID now, it will automatically happen
    private Long id;
    private String name;
    private String ingredients;
    private String instructions;
    private String imageUrl;

}



