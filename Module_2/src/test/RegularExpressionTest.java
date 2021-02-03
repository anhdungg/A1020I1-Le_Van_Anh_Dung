package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
    public static void main(String[] args) {
        final String MA_DICH_VU = "(SV)(RO|VL|HO)[-]\\d{4}$";
        final String TEN_DICH_VU = "^[A-Z][a-z]{1,}$";
        final String DIEN_TICH = "^[1-9][0-9]{0,}$";
        final String CHI_PHI = "^[1-9][0-9]{0,}$";
        final String SO_NGUOI = "^[1-9][0-9]{0,}$";
        final String DICH_VU_DI_KEM = "(^massage$|^karaoke$|^food$|^drink$|^car$)";
        final String SO_TANG = "^[1-9][0-9]{0,}$";
        final String KIEU_THUE = "^[A-Z][a-z]{1,}$";
        final String NGAY_SINH = "\\d{2}[-|/]\\d{2}[-|/]\\d{4}";
        Pattern pattern = Pattern.compile(MA_DICH_VU, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("SVRO-0001");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }
}
