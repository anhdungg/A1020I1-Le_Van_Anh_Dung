package CaseStudy.manage;

import CaseStudy.common.ReadWriteFile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageBooking {
    final private ManageService manageService = new ManageService();
    final private ManageCustomer manageCustomer = new ManageCustomer();
    final private ReadWriteFile readWriteFile = new ReadWriteFile();


    public boolean selectMenu(Scanner input, String type){
        String statusService = "";
        do {
            switch (type){
                case "villa":
                    statusService = select(input, "villa");
                    break;
                case "house":
                    statusService = select(input, "house");
                    break;
                case "room":
                    statusService = select(input, "room");
                    break;
            }

            if (statusService.equals("-1")){
                return false;
            }else if (!statusService.equals("0")){
                String statusCustomer = select(input, "customer");
                if (statusCustomer.equals("-1")){
                    return false;
                }else if (!statusCustomer.equals("0")){
                    this.writeBooking(statusService, statusCustomer);
                    statusService = "0";
                }
            }
        }while (!statusService.equals("0"));
        return true;
    }

    private String select(Scanner input, String typeService){
        String dataShow = "";
        switch (typeService){
            case "villa":
                dataShow = this.getService("villa");
                break;
            case "house":
                dataShow = this.getService("house");
                break;
            case "room":
                dataShow = this.getService("room");
                break;
            case "customer":
                dataShow = this.getCustomer();
                break;
        }
        if(dataShow.contains("no data")){
            System.out.println(dataShow + "\n");
            return "-1";
        }else if (dataShow.equals("File cannot be read")){
            System.out.println(dataShow + "\n");
            return "-1";
        }
        String maxSelectStr = dataShow.substring(dataShow.indexOf(":")+2, dataShow.indexOf("available")-1);
        int maxSelect = Integer.parseInt(maxSelectStr) + 1;
        int select;
        do {
            System.out.print(dataShow + "\n" + maxSelect + ". Back\n" + (maxSelect+1) + ". Exit\n" + "Please select menu:");
            try {
                select = input.nextInt();
            }catch (InputMismatchException e){
                select = 0;
            }
            input.nextLine();
            if(select<=0 || select>maxSelect+1){
                System.out.println("Error. Please select menu\n");
            }
        }while (select<=0 || select>maxSelect+1);
        if (select<maxSelect){
            switch (typeService){
                case "villa":
                case "house":
                case "room":
                    dataShow = dataShow.substring(dataShow.indexOf(select+". Id:"));
                    return dataShow.substring(dataShow.indexOf(select+". Id:")+7, dataShow.indexOf(","));
                default:
                    for (int i=0; i<select; i++){
                        dataShow = dataShow.substring(dataShow.indexOf("\n") + 1);
                    }
                    dataShow = dataShow.substring(dataShow.indexOf("Id card:"));
                    return dataShow.substring(dataShow.indexOf("Id card:") + 9, dataShow.indexOf(","));
            }

        }else if(select == maxSelect){
            return "0";
        }else {
            return "-1";
        }
    }

    public String getService(String typeService){
        switch (typeService){
            case "villa":
                return manageService.showServices("villa");
            case "house":
                return manageService.showServices("house");
            case "room":
                return manageService.showServices("room");
        }
        return "";
    }

    public String getCustomer(){
        return manageCustomer.showInformationCustomer();
    }

    public void writeBooking(String idService, String idCustomer){
        System.out.println(readWriteFile.writeFile("booking", idService + "," + idCustomer) + "\n");
    }
}
