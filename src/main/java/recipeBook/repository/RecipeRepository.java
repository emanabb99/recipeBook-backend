package recipeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recipeBook.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    Long id(Long id);
}
