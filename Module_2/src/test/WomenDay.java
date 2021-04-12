package test;

public class WomenDay {
    public static void main(String[] args) {
        final int HEIGHT = 15;
        final int WIDTH = 38;
        final String DOWNLINE = "\n";
        for (int i=0; i<WIDTH; i++)
        {
            for (int j=0; j<HEIGHT; j++)
            {
                System.out.println(DOWNLINE);
            }
        }
        String dateOfFemale = "      *******            *******" + "\n" +
                              "   *************      *************" + "\n" +
                              " *****************  *****************" + "\n" +
                              "**************************************" + "\n" +
                              "**************************************" + "\n" +
                              " ************************************" + "\n" +
                              "   ********************************" + "\n" +
                              "     ****************************" + "\n" +
                              "       ************************" + "\n" +
                              "          *******************" + "\n" +
                              "            ***************" + "\n" +
                              "              ***********" + "\n" +
                              "                *******" + "\n" +
                              "                  ***" + "\n" +
                              "                   *" ;
        System.out.println(dateOfFemale + "\n");
        System.out.println("          8/3 HAPPY WOMEN'S DAY");
    }
}
