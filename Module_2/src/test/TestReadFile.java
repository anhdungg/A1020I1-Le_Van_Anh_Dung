package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
    public static void main(String[] args) throws IOException
    {
        // variable declaration
        int ch;
        StringBuilder dataRead = new StringBuilder();
        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("D:\\CodeGym\\Module_2\\src\\CaseStudy\\controllers\\data\\Villa.csv");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        // read from FileReader till the end of file
        while ((ch=fr.read())!=10) {

//            if (ch!=10 && ch!=13){
//                System.out.print((char) ch);
                dataRead.append(Character.toString((char) ch));
//            }else break;
        }
        System.out.println(dataRead.toString());
        // close the file
        fr.close();
    }
}
