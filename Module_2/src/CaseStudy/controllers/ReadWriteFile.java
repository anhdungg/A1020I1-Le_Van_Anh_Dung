package CaseStudy.controllers;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String LINK_FILE_VILLA = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Villa.csv";
    private static final String LINK_FILE_HOUSE = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\House.csv";
    private static final String LINK_FILE_ROOM = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Room.csv";

    private static final String HEADER_VILLA = "Id,Area used,Rental costs,Maximum people,Rent type,Standard room," +
            "Description of other amenities,Pool area, Number of floors";
    private static final String HEADER_HOUSE = "Id,Area used,Rental costs,Maximum people,Rent type,Standard room," +
            "Description of other amenities, Number of floors";
    private static final String HEADER_ROOM = "Id,Area used,Rental costs,Maximum people, Rent type, Free service included," +
            "Unit,Money";

    private boolean STATUS_CHECK_NEW_FILE_VILLA = this.checkNewFile("villa");
    private boolean STATUS_CHECK_NEW_FILE_HOUSE = this.checkNewFile("house");
    private boolean STATUS_CHECK_NEW_FILE_ROOM = this.checkNewFile("room");

    public void writeFile(String typeService, String data){
        try {
            FileWriter  fileWriter = null;
            switch (typeService){
                case "villa":
                    if(STATUS_CHECK_NEW_FILE_VILLA){
                        fileWriter = new FileWriter(LINK_FILE_VILLA);
                        writeHeaderFile(fileWriter, "villa");
                        STATUS_CHECK_NEW_FILE_VILLA = false;
                    }else {
                        fileWriter = new FileWriter(LINK_FILE_VILLA, true);
                    }
                    break;
                case "house":
                    if(STATUS_CHECK_NEW_FILE_HOUSE){
                        fileWriter = new FileWriter(LINK_FILE_HOUSE);
                        writeHeaderFile(fileWriter, "house");
                        STATUS_CHECK_NEW_FILE_HOUSE = false;
                    }else {
                        fileWriter = new FileWriter(LINK_FILE_HOUSE,true);
                    }
                    break;
                case "room":
                    if(STATUS_CHECK_NEW_FILE_ROOM){
                        fileWriter = new FileWriter(LINK_FILE_ROOM);
                        writeHeaderFile(fileWriter, "room");
                        STATUS_CHECK_NEW_FILE_ROOM = false;
                    }else {
                        fileWriter = new FileWriter(LINK_FILE_ROOM, true);
                    }

                    break;
            }
            if (fileWriter != null){
                fileWriter.append(data);
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String readFile(String typeService){
        StringBuilder dataReturn = new  StringBuilder();
        try {
            FileReader fileReader = choiceFile(typeService);
            int read;
            if(fileReader!=null) {
                while ((read = fileReader.read()) != -1) {
                    dataReturn.append((char) read);
                }
            }
        }catch (FileNotFoundException fe){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataReturn.toString();
    }
    private void writeHeaderFile(FileWriter fileWriter, String typeService){
        try{
            switch (typeService){
                case "villa":
                    fileWriter.write(HEADER_VILLA);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    break;
                case "house":
                    fileWriter.write(HEADER_HOUSE);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    break;
                case "room":
                    fileWriter.write(HEADER_ROOM);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean checkNewFile(String typeService) {
        StringBuilder dataReturn = new StringBuilder();
        try {
            FileReader fileReader = choiceFile(typeService);
            if(fileReader!=null){
                int read;
                while ((read = fileReader.read())!=-1){
                    if(read!=10 && read!=13) {
                        dataReturn.append((char) read);
                    }else break;
                }
                fileReader.close();
            }
        }catch (FileNotFoundException fe){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataReturn.toString().equals("");
    }

    private FileReader choiceFile(String typeService) throws FileNotFoundException {
        switch (typeService) {
            case "villa":
                return new FileReader(LINK_FILE_VILLA);
            case "house":
                return new FileReader(LINK_FILE_HOUSE);
            case "room":
                return new FileReader(LINK_FILE_ROOM);
            default:
                return null;
        }
    }

//    public static void main(String[] args) {
//        ReadWriteFile readWriteFile = new ReadWriteFile();
//        System.out.println(readWriteFile.readFile("room"));
//        readWriteFile.writeFile("villa","02,1234.0,2000.0,5,year,4 sao,PlayStation 5,23.0,3");
//    }
}
