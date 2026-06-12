import org.junit.jupiter.api.Test;
import recipeBook.entity.Recipe;
import recipeBook.repository.RecipeRepository;
import recipeBook.service.RecipeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecipeServiceTest {

    @Test
    void checkCreateRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setName("Banana Bread");
        recipe.setIngredients("Banana,Bread");
        recipe.setInstructions("Add banana and bread");
        RecipeRepository recipeRepository = mock(RecipeRepository.class);
        RecipeService recipeService = new RecipeService(recipeRepository);
        when(recipeRepository.save(recipe))
                .thenReturn(recipe);

        Recipe createdRecipe = recipeService.createRecipe(recipe);

        assertEquals(1L,createdRecipe.getId());
        assertEquals("Banana Bread",createdRecipe.getName());
        assertEquals("Banana,Bread",createdRecipe.getIngredients());
        assertEquals("Add banana and bread",createdRecipe.getInstructions());
    }

}
