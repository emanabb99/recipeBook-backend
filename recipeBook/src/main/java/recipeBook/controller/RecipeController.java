package recipeBook.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import recipeBook.entity.Recipe;
import recipeBook.service.RecipeService;

import java.util.List;

//allows spring to speak to my front end regardless of port numbers

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping //goes on the method
    public Recipe createRecipe(
            @RequestParam("name") String name, //the bit in speech marks is the name of the field from the front end request
            @RequestParam("ingredients") String ingredients,
            @RequestParam("instructions") String instructions,
            @RequestParam("file") MultipartFile file
    ) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
        recipe.setImageUrl(file.getOriginalFilename());

        return recipeService.createRecipe(recipe);
    }

    @GetMapping
    public List<Recipe> getRecipe() {
        return recipeService.getAllRecipes();
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @PutMapping("/{id}")
    public Recipe editRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe) {
        return recipeService.editRecipe(id,updatedRecipe);
    }

}
