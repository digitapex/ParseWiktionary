import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
