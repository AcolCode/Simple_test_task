package generatortools;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//Настройки будущего отчета

@XmlRootElement(name = "settings")
public class Settings {

    @XmlElement(name = "page")
    private PageSize page;
    @XmlElementWrapper(name="columns")
    @XmlElement(name = "column")
    private List<ColumnSize> columns;

    public PageSize getPage() {
        return page;
    }
    public List<ColumnSize> getColumns() {
        return columns;
    }
}
