package recipeBook.service;

import org.springframework.stereotype.Service;
import recipeBook.dto.AIResponse;

import java.util.List;

@Service
public class AIService {


    public AIResponse generateRecipe(String prompt) {
        AIResponse aiResponse = new AIResponse();
        aiResponse.setName("Mock Spaghetti Bolognese");
        aiResponse.setIngredients(List.of("Spaghetti","Bolognese"));
        aiResponse.setInstructions(List.of("Boil Spaghetti","Cook mince"));
        return aiResponse;
    }
}
