import org.junit.jupiter.api.Test;
import recipeBook.entity.Recipe;
import recipeBook.repository.RecipeRepository;
import recipeBook.service.RecipeService;
import java.util.List;
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
        when(recipeRepository.save(recipe))
                .thenReturn(recipe);

        RecipeService recipeService = new RecipeService(recipeRepository);
        Recipe createdRecipe = recipeService.createRecipe(recipe);

        assertEquals(1L,createdRecipe.getId());
        assertEquals("Banana Bread",createdRecipe.getName());
        assertEquals("Banana,Bread",createdRecipe.getIngredients());
        assertEquals("Add banana and bread",createdRecipe.getInstructions());
    }

    @Test
    void checkViewRecipes() {
        RecipeRepository recipeRepository = mock(RecipeRepository.class);
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        when(recipeRepository.findAll())
                .thenReturn(List.of(recipe1,recipe2));

        RecipeService recipeService = new RecipeService(recipeRepository);
        List<Recipe> allRecipes = recipeService.viewRecipes();

        assertEquals(recipe1,allRecipes.get(0));
        assertEquals(recipe2,allRecipes.get(1));
        assertEquals(2,allRecipes.size());
    }


}
