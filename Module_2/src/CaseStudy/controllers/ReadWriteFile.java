package CaseStudy.controllers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String LINK_FILE_VILLA = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\data\\Villa.csv";
    private static final String LINK_FILE_HOUSE = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\data\\House.csv";
    private static final String LINK_FILE_ROOM = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\data\\Room.csv";
    private static final String LINK_FILE_CUSTOMER = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\data\\Customer.csv";
    private static final String LINK_FILE_BOOKING = "D:\\CodeGym\\Module_2\\src\\CaseStudy\\data\\Booking.csv";

    private static final String HEADER_VILLA = "Id,Area used,Rental costs,Maximum people,Rent type,Standard room," +
            "Description of other amenities,Pool area,Number of floors,Accompanied service,Unit,Money";
    private static final String HEADER_HOUSE = "Id,Area used,Rental costs,Maximum people,Rent type,Standard room," +
            "Description of other amenities,Number of floors,Accompanied service,Unit,Money";
    private static final String HEADER_ROOM = "Id,Area used,Rental costs,Maximum people,Rent type,Free service included," +
            "Unit,Money,Accompanied service,Unit,Money";
    private static final String HEADER_CUSTOMER = "Name,Day of birth,Gender,Id card,Phone number,Email,Type customer," +
            "Address";
    private static final String HEADER_BOOKING = "Id Service,Id Customer";

    private String STATUS_CHECK_NEW_FILE_VILLA = this.checkNewFile("villa");
    private String STATUS_CHECK_NEW_FILE_HOUSE = this.checkNewFile("house");
    private String STATUS_CHECK_NEW_FILE_ROOM = this.checkNewFile("room");
    private String STATUS_CHECK_NEW_FILE_CUSTOMER = this.checkNewFile("customer");
    private String STATUS_CHECK_NEW_FILE_BOOKING = this.checkNewFile("booking");

    public String writeFile(String typeService, String data){
        try {
            FileWriter fileWriter = null;
            switch (typeService){
                case "villa":
                    switch (STATUS_CHECK_NEW_FILE_VILLA) {
                        case "":
                            fileWriter = new FileWriter(LINK_FILE_VILLA);
                            writeHeaderFile(fileWriter, "villa");
                            STATUS_CHECK_NEW_FILE_VILLA = "header has been written";
                            break;
                        case "File cannot be read":
                            return "File cannot be write";
                        default:
                            fileWriter = new FileWriter(LINK_FILE_VILLA, true);
                            break;
                    }
                    break;
                case "house":
                    switch (STATUS_CHECK_NEW_FILE_HOUSE){
                        case "":
                            fileWriter = new FileWriter(LINK_FILE_HOUSE);
                            writeHeaderFile(fileWriter, "house");
                            STATUS_CHECK_NEW_FILE_HOUSE = "header has been written";
                            break;
                        case "File cannot be read":
                            return "File cannot be write";
                        default:
                            fileWriter = new FileWriter(LINK_FILE_HOUSE,true);
                    }
                    break;
                case "room":
                    switch (STATUS_CHECK_NEW_FILE_ROOM){
                        case "":
                            fileWriter = new FileWriter(LINK_FILE_ROOM);
                            writeHeaderFile(fileWriter, "room");
                            STATUS_CHECK_NEW_FILE_ROOM = "header has been written";
                            break;
                        case "File cannot be read":
                            return "File cannot be write";
                        default:
                            fileWriter = new FileWriter(LINK_FILE_ROOM, true);
                    }
                    break;
                case "customer":
                    switch (STATUS_CHECK_NEW_FILE_CUSTOMER){
                        case "":
                            fileWriter = new FileWriter(LINK_FILE_CUSTOMER);
                            writeHeaderFile(fileWriter, "customer");
                            STATUS_CHECK_NEW_FILE_CUSTOMER = "header has been written";
                            break;
                        case "File cannot be read":
                            return "File cannot be write";
                        default:
                            fileWriter = new FileWriter(LINK_FILE_CUSTOMER, true);
                    }
                    break;
                case "booking":
                    switch (STATUS_CHECK_NEW_FILE_BOOKING){
                        case "":
                            fileWriter = new FileWriter(LINK_FILE_BOOKING);
                            writeHeaderFile(fileWriter, "booking");
                            STATUS_CHECK_NEW_FILE_BOOKING = "header has been written";
                        case "File cannot be read":
                            return "File cannot be write";
                        default:
                            fileWriter = new FileWriter(LINK_FILE_BOOKING, true);
                    }
                    break;
            }
            if (fileWriter != null){
                fileWriter.append(data);
                fileWriter.append(NEW_LINE_SEPARATOR);
                fileWriter.close();
                return "Write file successful";
            }else {
                return "Write file failed. Check service";
            }
        }catch (IOException io){
            return "File cannot be write";
        }
    }

    public String readFile(String typeService){
        StringBuilder dataReturn = new StringBuilder();
        try {
            FileReader fileReader = choiceFile(typeService);
            int read;
            if(fileReader!=null) {
                while ((read = fileReader.read()) != -1) {
                    dataReturn.append((char) read);
                }
            }
        }catch (IOException e) {
            return "File cannot be read";
        }
        return dataReturn.toString();
    }

    private void writeHeaderFile(FileWriter fileWriter, String typeService) throws IOException{
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
            case "customer":
                fileWriter.write(HEADER_CUSTOMER);
                fileWriter.append(NEW_LINE_SEPARATOR);
                break;
            case "booking":
                fileWriter.write(HEADER_BOOKING);
                fileWriter.append(NEW_LINE_SEPARATOR);
                break;
        }
    }

    private String checkNewFile(String typeService) {
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
        } catch (IOException e) {
            return "File cannot be read";
        }
        return dataReturn.toString();
    }

    private FileReader choiceFile(String typeService) throws IOException {
        switch (typeService) {
            case "villa":
                return new FileReader(LINK_FILE_VILLA);
            case "house":
                return new FileReader(LINK_FILE_HOUSE);
            case "room":
                return new FileReader(LINK_FILE_ROOM);
            case "customer":
                return new FileReader(LINK_FILE_CUSTOMER);
            case "booking":
                return new FileReader(LINK_FILE_BOOKING);
            default:
                return null;
        }
    }

    public static String getHeaderHouse() {
        return HEADER_HOUSE;
    }

    public static String getHeaderVilla() {
        return HEADER_VILLA;
    }

    public static String getHeaderRoom() {
        return HEADER_ROOM;
    }

    public static String getHeaderCustomer() {
        return HEADER_CUSTOMER;
    }

        public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        System.out.println(readWriteFile.readFile("customer"));
//        readWriteFile.writeFile("villa","02,1234.0,2000.0,5,year,4 sao,PlayStation 5,23.0,3");
    }
}
