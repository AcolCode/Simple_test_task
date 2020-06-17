package generatortools;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Размер и заголовки для колонок

@XmlRootElement(name = "column")
public class ColumnSize {

    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "width")
    private int width;

    public String getTitle() {
        return title;
    }
    public int getWidth() {
        return width;
    }
}
