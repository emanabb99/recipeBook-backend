package recipeBook.service;

import org.springframework.stereotype.Service;
import recipeBook.entity.Recipe;
import recipeBook.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository; //once this repository is given to this service it can never change

    //use a constructor to inject the repository;
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    //Spring creates and calls this constructor for you and brings in the repository

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe editRecipe(Long id, Recipe updatedRecipe) {
        //find existing recipe
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        //set this recipe with updated recipe features
        recipe.setName(updatedRecipe.getName());
        recipe.setIngredients(updatedRecipe.getIngredients());
        recipe.setInstructions(updatedRecipe.getInstructions());

        return recipeRepository.save(updatedRecipe);
    }



}
