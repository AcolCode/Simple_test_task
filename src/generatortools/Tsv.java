package generatortools;

import com.univocity.parsers.tsv.TsvParserSettings;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

//Чтение TAB-delimited файла

public class Tsv {

    List<String[]> tsvParserData;

    public void parse(String fileName) {
        TsvParserSettings settings = new TsvParserSettings();
        com.univocity.parsers.tsv.TsvParser parser = new com.univocity.parsers.tsv.TsvParser(settings);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            tsvParserData = parser.parseAll(new InputStreamReader(fis, "UTF-16"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
    public List<String[]> getTsvParserData() {
        return tsvParserData;
    }
}
