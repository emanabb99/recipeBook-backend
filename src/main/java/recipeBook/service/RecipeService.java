package recipeBook.service;

import org.springframework.stereotype.Service;
import recipeBook.entity.Recipe;
import recipeBook.entity.User;
import recipeBook.repository.RecipeRepository;
import recipeBook.repository.UserRepository;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository; //once this repository is given to this service it can never change
    private final UserRepository userRepository;

    //use a constructor to inject the repository;
    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    public Recipe createRecipe(Recipe recipe, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        recipe.setUser(user);
        return recipeRepository.save(recipe);
    }

    public List<Recipe> viewRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe editRecipe(Recipe recipe) {
        Recipe existingRecipe = recipeRepository.findById(recipe.getId())
                .orElseThrow();
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
