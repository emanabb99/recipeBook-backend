package recipeBook.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import recipeBook.entity.Recipe;
import recipeBook.service.RecipeService;


@CrossOrigin(origins = "http://localhost:5173") //allows spring to speak to my front end regardless of port numbers

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipes") //goes on the method
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        System.out.println("Recipe in spring");
        return recipeService.createRecipe(recipe);
    }

}
