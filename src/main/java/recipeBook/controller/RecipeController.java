package recipeBook.controller;

import org.springframework.web.bind.annotation.*;
import recipeBook.entity.Recipe;
import recipeBook.service.RecipeService;

import java.util.List;


@CrossOrigin(origins="http://localhost:5173") //allows spring to speak to my front end regardless of port numbers

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipes") //goes on the method
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/recipes")
    public List<Recipe> viewRecipes() {
        return recipeService.viewRecipes();
    }

    @PutMapping("/recipes")
    public Recipe editRecipe(@RequestBody Recipe recipe) {
        return recipeService.editRecipe(recipe);
    }

    @DeleteMapping("/recipes/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

}
