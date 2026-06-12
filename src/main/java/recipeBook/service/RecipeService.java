package recipeBook.service;

import org.springframework.stereotype.Service;
import recipeBook.entity.Recipe;
import recipeBook.repository.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository; //once this repository is given to this service it can never change

    //use a constructor to inject the repository;
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> viewRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe editRecipe(Recipe recipe) {
        Optional<Recipe> recipeToEdit = recipeRepository.findById(recipe.getId());
        Recipe existingRecipe = recipeToEdit.orElseThrow();
        existingRecipe.setName(recipe.getName());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setInstructions(recipe.getInstructions());
        return recipeRepository.save(existingRecipe);
    }


public void deleteRecipe(Long id) {
    if (recipeRepository.existsById(id)) {
        recipeRepository.deleteById(id);
    } else {
        throw new RuntimeException("Recipe not found");
    }
}
}
