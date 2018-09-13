import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // extractAllWordsFromOriginal();
//        extractOnlyNouns();
//        System.out.println(NetworkUtil.getWordFormAndGender("Haus"));
        String wordsList = IOUtils.getList("lists/listNounsShort.txt");
        String[] words = IOUtils.getLines(wordsList);
        List<String> nounsVerified = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String word = words[i];

            try {
                String[] wordFormAndGender = NetworkUtil.getWordFormAndGender(words[i]);
                String wordForm = wordFormAndGender[0];
                String gender = wordFormAndGender[1];
                if (wordForm.equals("Substantiv")) {
                    System.out.println(word);
                    System.out.println(gender);
                }
            } catch (Exception e) {
                System.out.println("Word " + word + " not found");
            }
        }
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
