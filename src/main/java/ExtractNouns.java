import java.util.ArrayList;
import java.util.List;

public class ExtractNouns {

    static List<String> getOnlyNouns(String[] lines){
            List<String> onlyNouns = new ArrayList<>();
            for (String line : lines) {
                // codePointAt instead of charAt because of umlaut at the beginning
                if(Character.isUpperCase(line.codePointAt(0))){
                    onlyNouns.add(line);
                }
            }
            return onlyNouns;
        }
}
