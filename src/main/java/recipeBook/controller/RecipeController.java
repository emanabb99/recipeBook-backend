package recipeBook.controller;

import org.springframework.web.bind.annotation.*;
import recipeBook.entity.CreateRecipeRequest;
import recipeBook.entity.Recipe;
import recipeBook.repository.UserRepository;
import recipeBook.service.RecipeService;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins="http://localhost:5173", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})//allows spring to speak to my front end regardless of port numbers

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService, UserRepository userRepository) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipes") //goes on the method
    public Recipe createRecipe(@RequestBody CreateRecipeRequest recipeRequest) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeRequest.getName());
        recipe.setIngredients(recipeRequest.getIngredients());
        recipe.setInstructions(recipeRequest.getInstructions());

        return recipeService.createRecipe(recipe,recipeRequest.getUserId());
    }

    @GetMapping("/recipes/{userId}")
    public List<Recipe> viewRecipes(@PathVariable("userId") Long userId) {
        return recipeService.viewRecipes(userId);
    }

    @PutMapping("/recipes")
    public Recipe editRecipe(@RequestBody Recipe recipe) {
        return recipeService.editRecipe(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
    }

}
