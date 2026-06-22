package recipeBook.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter //automatically does getter methods
@Setter //automatically does setter methods
@NoArgsConstructor //will run the class without using arguments

public class AIResponse {
    private String name;
    private List<String> ingredients;
    private List<String> instructions;

}
