package CaseStudy.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String LINK_FILE_VILLA = "src\\CaseStudy\\data\\Villa.csv";
    private static final String LINK_FILE_HOUSE = "src\\CaseStudy\\data\\House.csv";
    private static final String LINK_FILE_ROOM = "src\\CaseStudy\\data\\Room.csv";
    private static final String LINK_FILE_CUSTOMER = "src\\CaseStudy\\data\\Customer.csv";
    private static final String LINK_FILE_BOOKING = "src\\CaseStudy\\data\\Booking.csv";
    private static final String LINK_FILE_EMPLOYEE = "src\\CaseStudy\\data\\Employee.csv";

    private static final String HEADER_VILLA = "Id,Name service,Area used,Rental costs,Maximum people,Rent type,Standard room," +
            "Description of other amenities,Pool area,Number of floors,Accompanied service,Unit,Money";
    private static final String HEADER_HOUSE = "Id,Name service,Area used,Rental costs,Maximum people,Rent type,Standard room," +
            "Description of other amenities,Number of floors,Accompanied service,Unit,Money";
    private static final String HEADER_ROOM = "Id,Name service,Area used,Rental costs,Maximum people,Rent type,Free service included," +
            "Unit,Money,Accompanied service,Unit,Money";
    private static final String HEADER_CUSTOMER = "Name,Day of birth,Gender,Id card,Phone number,Email,Type customer," +
            "Address";
    private static final String HEADER_BOOKING = "Id Service,Id Customer";
    private static final String HEADER_EMPLOYEE = "Name,Year old,Address";

    public String writeFile(String typeService, String data){
        try {
            FileWriter fileWriter = null;
            switch (typeService){
                case "villa":
                    switch (this.readFile("villa")) {
                        case "":
                        case "File cannot be read":
                            fileWriter = new FileWriter(LINK_FILE_VILLA);
                            writeHeaderFile(fileWriter, "villa");
                            break;
                        default:
                            fileWriter = new FileWriter(LINK_FILE_VILLA, true);
                            break;
                    }
                    break;
                case "house":
                    switch (this.readFile("house")){
                        case "":
                        case "File cannot be read":
                            fileWriter = new FileWriter(LINK_FILE_HOUSE);
                            writeHeaderFile(fileWriter, "house");
                            break;
                        default:
                            fileWriter = new FileWriter(LINK_FILE_HOUSE,true);
                    }
                    break;
                case "room":
                    switch (this.readFile("room")){
                        case "":
                        case "File cannot be read":
                            fileWriter = new FileWriter(LINK_FILE_ROOM);
                            writeHeaderFile(fileWriter, "room");
                            break;
                        default:
                            fileWriter = new FileWriter(LINK_FILE_ROOM, true);
                    }
                    break;
                case "customer":
                    switch (this.readFile("customer")){
                        case "":
                        case "File cannot be read":
                            fileWriter = new FileWriter(LINK_FILE_CUSTOMER);
                            writeHeaderFile(fileWriter, "customer");
                            break;
                        default:
                            fileWriter = new FileWriter(LINK_FILE_CUSTOMER, true);
                    }
                    break;
                case "booking":
                    switch (this.readFile("booking")){
                        case "":
                        case "File cannot be read":
                            fileWriter = new FileWriter(LINK_FILE_BOOKING);
                            writeHeaderFile(fileWriter, "booking");
                            break;
                        default:
                            fileWriter = new FileWriter(LINK_FILE_BOOKING, true);
                    }
                    break;
                case "employee":
                    switch (this.readFile("employee")){
                        case "":
                        case "File cannot be read":
                            fileWriter = new FileWriter(LINK_FILE_EMPLOYEE);
                            writeHeaderFile(fileWriter, "employee");
                            break;
                        default:
                            fileWriter = new FileWriter(LINK_FILE_EMPLOYEE, true);
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
        String str;
        boolean status=false;
        try {
            FileReader fileReader = choiceFile(typeService);
            if(fileReader == null){
                return "File cannot be read";
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null){
                if(status) {
                    dataReturn.append(str).append("\n");
                }
                status = true;
            }
            fileReader.close();
            return dataReturn.toString();
        }catch (IOException e) {
            return "File cannot be read";
        }
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
            case "employee":
                fileWriter.write(HEADER_EMPLOYEE);
                fileWriter.append(NEW_LINE_SEPARATOR);
                break;
        }
    }

//    private String checkNewFile(String typeService) {
//        StringBuilder dataReturn = new StringBuilder();
//        try {
//            FileReader fileReader = choiceFile(typeService);
//            if(fileReader!=null){
//                int read;
//                while ((read = fileReader.read())!=-1){
//                    if(read!=10 && read!=13) {
//                        dataReturn.append((char) read);
//                    }else break;
//                }
//                fileReader.close();
//            }
//        } catch (IOException e) {
//            return "File cannot be read";
//        }
//        return dataReturn.toString();
//    }

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
            case "employee":
                return new FileReader(LINK_FILE_EMPLOYEE);
            default:
                return null;
        }
    }
    public static void main(String[] args) {
//        ReadWriteFile readWriteFile = new ReadWriteFile();
//        System.out.println(readWriteFile.readFile("customer"));
//        System.out.println(readWriteFile.writeFile("villa","SVVL-0006,Hanami,300,2500,5,Year,5 star,No,70,3,Car,2,1500"));
//        System.out.println(readWriteFile.writeFile("room","SVVL-0003,Salmalia Boutique,50,500,2,Day,Nuoc loc,2,0,Drink,2,10"));
//        System.out.println(readWriteFile.writeFile("room","SVVL-0004,Grand Tourane,32,150,2,Day,Nuoc loc,2,0,Car,2,200"));
//        System.out.println(readWriteFile.writeFile("room","SVVL-0005,Sala Danang Beach,44,300,2,Hour,Nuoc loc,2,0,Karaoke,2,100"));
//        System.out.println(readWriteFile.readFile("booking"));
    }
}
