package generatortools;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Размер страницы

@XmlRootElement(name = "page")
public class PageSize {

    @XmlElement(name = "width")
    private int width;
    @XmlElement(name = "height")
    private int height;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
