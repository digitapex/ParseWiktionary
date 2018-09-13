import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class NetworkUtil {

    final static String DE_WIKTIONARY_BASE_URL = "https://de.wiktionary.org/wiki/";

    static String[] getWordFormAndGender(String word) throws IOException {
        String fullUrl = DE_WIKTIONARY_BASE_URL + word;
        Document document = Jsoup.connect(fullUrl).get();
        Element wordFormElement = document.select("[title=Hilfe:Wortart]").get(0);
        Element genderElement = wordFormElement.nextElementSibling();
        return new String[]{wordFormElement.text(), genderElement.text()};
    }
}
