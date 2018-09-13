import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class IOUtils {
    static String getList(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        // this charset works for German
        Reader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
//        System.out.println(out.toString());
        return out.toString();
    }

    static String[] getLines(String string) {
        return string.split(System.getProperty("line.separator"));
    }

    static void writeWordsToFile(List<String> words, String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
        // TODO - UTF-8?
        Charset charset = StandardCharsets.ISO_8859_1;
//        for (String word : words) {
//            System.out.println(word);
//
//
//        }
        Files.write(Paths.get(file.toString()), words, charset, StandardOpenOption.APPEND);
    }
}
