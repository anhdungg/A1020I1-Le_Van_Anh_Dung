package CaseStudy.controllers;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String HEADER_VILLA = "Id,Area used,Rental costs,Maximum people,Rent type,Standard room," +
            "Description of other amenities,Pool area, Number of floors";
    private static final String HEADER_HOUSE = "Id, Diện tích, Chi phí, Số người tối đa, Kiểu thuê, Tiêu chuẩn phòng," +
            "Mô tả tiện nghi khác, Số tầng";
    private static final String HEADER_ROOM = "Id, Diện tích, Chi phí, Số người tối đa, Kiểu thuê, Tiêu chuẩn phòng," +
            "Dịch vụ miễn phí đi kèm";
    private final boolean STATUS_CHECK_NEW_FILE_VILLA = this.checkNewFile("villa");
    private final boolean STATUS_CHECK_NEW_FILE_HOUSE = this.checkNewFile("house");
    private final boolean STATUS_CHECK_NEW_FILE_ROOM = this.checkNewFile("room");

    public void writeFile(String typeService, String data){
        try {
            FileWriter  fileWriter = null;
            switch (typeService){
                case "villa":
                    if(STATUS_CHECK_NEW_FILE_VILLA){
                        fileWriter = new FileWriter("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Villa.csv");
                        writeHeaderFile(fileWriter, "villa");
//                        STATUS_CHECK_NEW_FILE_VILLA = false;
                    }else {
                        fileWriter = new FileWriter("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Villa.csv", true);
                    }
                    break;
                case "house":
                    if(STATUS_CHECK_NEW_FILE_HOUSE){
                        fileWriter = new FileWriter("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\House.csv");
                        writeHeaderFile(fileWriter, "house");
//                        STATUS_CHECK_NEW_FILE_HOUSE = false;
                    }else {
                        fileWriter = new FileWriter("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\House.csv",true);
                    }
                    break;
                case "room":
                    if(STATUS_CHECK_NEW_FILE_ROOM){
                        fileWriter = new FileWriter("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Room.csv");
                        writeHeaderFile(fileWriter, "room");
//                        STATUS_CHECK_NEW_FILE_ROOM = false;
                    }else {
                        fileWriter = new FileWriter("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Room.csv", true);
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

    private void writeHeaderFile(FileWriter fileWriter, String typeService){
        try{
            switch (typeService){
                case "villa":
                    System.out.println("Write header file");
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
        FileReader fileReader = null;
        StringBuilder dataReturn = new StringBuilder("");
        try {
            switch (typeService) {
                case "villa":
                    fileReader = new FileReader("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Villa.csv");
                    break;
                case "house":
                    fileReader = new FileReader("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\House.csv");
                    break;
                case "room":
                    fileReader = new FileReader("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Room.csv");
                    break;
            }
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

    public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
//        System.out.println(readWriteFile.readFile("villa"));
        readWriteFile.writeFile("villa","02,1234.0,2000.0,5,year,4 sao,PlayStation 5,23.0,3");
    }
}
