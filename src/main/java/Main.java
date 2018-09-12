import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // extractAllWordsFromOriginal();
        extractOnlyNouns();
    }

    private static void extractAllWordsFromOriginal() throws IOException {
        String originalList = IOUtils.getList("lists/listOriginal.txt");
        String[] lines = IOUtils.getLines(originalList);
        List<String> firstWords = ExtractWords.getFirstWords(lines);
        IOUtils.writeWordsToFile(firstWords, "lists/listWordsOnly.txt");
    }

    private static void extractOnlyNouns() throws IOException {
        String listAllWords = IOUtils.getList("lists/listWordsOnly.txt");
        String[] lines = IOUtils.getLines(listAllWords);
        List<String> nouns = ExtractNouns.getOnlyNouns(lines);
        IOUtils.writeWordsToFile(nouns, "lists/listNouns.txt");
    }


}
