package recipeBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import recipeBook.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    Long id(Long id);

    List<Recipe> findByUserId(Long userId);
}
