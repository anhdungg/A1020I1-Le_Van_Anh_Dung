package CaseStudy.controllers;

import CaseStudy.models.Villa;
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
    private static  boolean STATUS_NEW_FILE_VILLA = true;
    private static  boolean STATUS_NEW_FILE_HOUSE = true;
    private static  boolean STATUS_NEW_FILE_ROOM = true;

    FileWriter  fileWriter = null;
    public void writeFile(Villa villa){
        try {
            fileWriter = new FileWriter("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Villa.csv");
            if (STATUS_NEW_FILE_VILLA){
                fileWriter.write(HEADER_VILLA);
                STATUS_NEW_FILE_VILLA = false;
            }
            fileWriter.append(villa.writeFile());
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void writeFile(House house){
//
//    }
//
//    public void writeFile(Room room){
//
//    }
}
