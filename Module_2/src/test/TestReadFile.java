package test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestReadFile {
    public static void main(String[] args) throws IOException
    {
        try {
            File fileDir = new File("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\House.csv");

            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileDir), StandardCharsets.UTF_8));

            out.append("Id, Diện tích, Chi phí, Số người tối đa, Kiểu thuê, Tiêu chuẩn phòng,\\\" +\\n\" +\n" +
                    "                    \"            \\\"Mô tả tiện nghi khác, Số tầng").append("\r\n");
            out.flush();
            out.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
