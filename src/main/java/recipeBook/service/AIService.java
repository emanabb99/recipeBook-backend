package recipeBook.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String generateRecipe(String prompt) {
        return "AI would generate something for " + prompt;
    }
//
//    public String callAI(String prompt) {
//        String customisedPrompt =  """Generate a recipe in the following format
//                Recipe Name
//                Recipe Ingredients
//                Recipe Instructions
//                based on the following prompt""" + prompt;
//        return customisedPrompt;
//    }
}
