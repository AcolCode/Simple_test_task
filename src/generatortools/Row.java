package generatortools;

import org.apache.commons.lang3.StringUtils;
import java.util.List;

//Формирует ряды

public class Row {
    private static final char columnDelimiter = '|';
    private static final char rowDelimiter = '-';
    private static final char wordDelimiter = ' ';
    String headRow;
    String delimiterRow;
    private Settings settings;

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
    public String getHeadRow() {
        return headRow;
    }
    public String getDelimiterRow() {
        return delimiterRow;
    }

    public String generate(String[] data){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(columnDelimiter);
        for (int i = 0; i < settings.getColumns().size(); i++) {
            stringBuilder.append(generateColumn(data[i], settings.getColumns().get(i).getWidth()));
        }
        return stringBuilder.toString();
    }
    private StringBuilder generateColumn(String s, int columnWidth) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(wordDelimiter);
        stringBuilder.append(s);
        int diffSize = columnWidth - s.length() ;
        if(diffSize > 0) {
            stringBuilder.append(StringUtils.repeat(" ", diffSize));
        }
        stringBuilder.append(wordDelimiter).append(columnDelimiter);
        return stringBuilder;
    }

    public void generateRowDelimiter() {
        delimiterRow = StringUtils.repeat(rowDelimiter, settings.getPage().getWidth());
    }

    public void generateHead(List<ColumnSize> columns) {

        String[] columnsTitles = new String[columns.size()];
        int i = 0;
        for (ColumnSize column: columns) {
            columnsTitles[i] = column.getTitle();
            i++;
        }
        headRow = generate(columnsTitles);
    }
}
