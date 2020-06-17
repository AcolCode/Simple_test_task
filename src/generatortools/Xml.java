package generatortools;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

//Чтение xml файла

public class Xml {

    private Settings parsedSettings;

    public void parse(String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
            XMLStreamReader xss = XMLInputFactory.newFactory().createXMLStreamReader(new FileInputStream(fileName));
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            xss.nextTag();
            parsedSettings = (Settings) unmarshaller.unmarshal(xss);
        } catch (XMLStreamException | JAXBException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public Settings getParsedSettings() {
        return parsedSettings;
    }
}
