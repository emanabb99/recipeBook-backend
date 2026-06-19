package recipeBook.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class CreateRecipeRequest {
    private Long userId;
    private String recipeName;
    private List<String> ingredients;
    private List<String> instructions;
}
