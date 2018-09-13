import java.util.ArrayList;
import java.util.List;

public class ExtractWords {

    static List<String> getFirstWords(String[] lines){
        List<String> wordsOnly = new ArrayList<>();
        for (String line : lines) {
            wordsOnly.add(line.split(" ")[0]);
        }
        return wordsOnly;
    }

}
