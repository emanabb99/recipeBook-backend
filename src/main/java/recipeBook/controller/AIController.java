package recipeBook.controller;

import org.springframework.web.bind.annotation.*;
import recipeBook.dto.AIResponse;
import recipeBook.service.AIService;

import java.util.Map;

@CrossOrigin(origins="http://localhost:5173", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})//allows spring to speak to my front end regardless of port numbers

@RestController
@RequestMapping("/api/ai")
public class AIController {
    AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/generate")
    public AIResponse generateRecipe(@RequestBody Map<String,String> prompt) {
        String promptMessage = prompt.get("prompt");
        return aiService.generateRecipe(promptMessage);
    }
}
