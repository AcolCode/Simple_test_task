package generatortools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Генерирует отчет

public class Report {

    private static final String newLine = "\r\n";
    private Settings settings;
    private List<String[]> inputData;
    private List<String> result = new ArrayList<>();
    private String fileName;

    public Report(String fileName) { this.fileName = fileName; }

    public void generate() {
        Page page = new Page(settings);
        result = page.generate(inputData);

        try {
            File fileDir = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF-16"));

            for (String line : result) {
                bw.append(line).append(newLine);
            }
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
    public void setInputData(List<String[]> inputData) {
        this.inputData = inputData;
    }

}
