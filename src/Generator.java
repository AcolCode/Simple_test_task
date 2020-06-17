import generatortools.Report;
import generatortools.Tsv;
import generatortools.Xml;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

//Генератор текстовых отчетов

public class Generator {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, UnsupportedEncodingException, JAXBException {

        Xml xml = new Xml(); //Создание объекта для извлечения настроек формата xml
        xml.parse(args[0]); //Чтение xml файл для извлечения настроек

        Tsv tsv = new Tsv(); //Создание объекта для извлечения данных формата tsv
        tsv.parse(args[1]); //Чтение tsv файла для извлечения данных

        Report report = new Report(args[2]); //Создание объекта для генерирования отчёта
        report.setSettings(xml.getParsedSettings()); //Установка настроек для генератора
        report.setInputData(tsv.getTsvParserData()); //Подача исходных данных для формирования отчета
        report.generate(); //Генеририрование отчета
    }
}
