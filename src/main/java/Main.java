import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        extractAllWordsFromOriginal();
//        extractOnlyNouns();

        String wordsList = IOUtils.getList("lists/listNouns.txt");
        String[] words = IOUtils.getLines(wordsList);
        File file = new File("lists/listNounsVerified.txt");
        file.createNewFile();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            try {
                String[] wordFormAndGender = NetworkUtil.getWordFormAndGender(words[i]);
                String wordForm = wordFormAndGender[0];
                String gender = wordFormAndGender[1];
                if (wordForm.equals("Substantiv")) {
                    Files.write(Paths.get(file.toString()), (word.trim() + "," + gender + "\n").getBytes(), StandardOpenOption.APPEND);
                    count++;
                    System.out.println("" + count);
                    if (count >= 10000){
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
