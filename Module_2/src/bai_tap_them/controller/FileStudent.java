package bai_tap_them.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStudent {
    private final String NEW_LINE = "\n";
    private final String LINK_SAVE_FILE = "src\\bai_tap_them\\data\\Study.csv";
    private final String HEADER_FILE = "Id,Name,Gender,Day of birth,Class";

    public String writeFile(String data){
        try {
            String dataFile = this.readFile();
            FileWriter fileWriter = new FileWriter(LINK_SAVE_FILE);
            if (dataFile.equals("") || dataFile.equals("File cannot be read")){
                fileWriter.write(HEADER_FILE);
                fileWriter.append(NEW_LINE);
            }
            fileWriter.append(data);
            fileWriter.append(NEW_LINE);
            fileWriter.close();
            return "Write file successful";
        }catch (IOException e){
            return "Write file failed";
        }
    }

    public String readFile(){
        StringBuilder output = new StringBuilder();
        String str;
        boolean statusRead = false;
        try {
            FileReader fileReader = new FileReader(LINK_SAVE_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null){
                if (statusRead){
                    output.append(str).append("\n");
                }
                statusRead = true;
            }
        }catch (IOException e){
            return "File cannot be read";
        }
        return output.toString();
    }

//    private void writeHeaderFile(FileWriter fileWriter) throws IOException{
//        fileWriter.write(HEADER_FILE);
//        fileWriter.append(NEW_LINE);
//    }
}
