package IO_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFile {
    final static String LINK_FILE_1 = "src\\IO_text_file\\bai_tap\\copy_file_text\\file_1.txt";
    final static String LINK_FILE_2 = "src\\IO_text_file\\bai_tap\\copy_file_text\\file_2.txt";

    public static void main(String[] args) {
        FileReader fileReader1;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        String str;
        StringBuilder tempFile = new StringBuilder();
        try {
            fileReader1 = new FileReader(LINK_FILE_1);
            bufferedReader = new BufferedReader(fileReader1);
        }catch (FileNotFoundException e){
            System.out.println("Không tìm thấy File 1");
            return;
        }
        try {
            while ((str = bufferedReader.readLine()) != null){
                tempFile.append(str);
            }
        }catch (IOException io){
            System.out.println("Không đọc được dữ liệu từ File 1");
            return;
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(LINK_FILE_2));
            bufferedWriter.write(tempFile.toString());
            bufferedWriter.close();
            System.out.println("Ghi file thành công");
        }catch (IOException e){
            System.out.println("Không ghi được dữ liệu từ File 2");
        }


    }
}
