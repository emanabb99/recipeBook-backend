package recipeBook.service;

import org.springframework.stereotype.Service;
import recipeBook.entity.Recipe;
import recipeBook.repository.RecipeRepository;

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
}
