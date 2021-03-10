package CaseStudy.controllers;

import CaseStudy.manage.ManageBooking;

import java.util.Scanner;

public class ControllerBooking {
    private final static ManageBooking manage = new ManageBooking();
    public void displayMainMenu(Scanner input){
        int select;
        String statusService;
        do {
            System.out.print("1. Booking Villa. \n" +
                    "2. Booking House. \n" +
                    "3. Booking Room. \n" +
                    "4. Exit. \n" +
                    "Please select menu: ");
            select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1:
                    selectMenu(input, "villa");
                    break;
                case 2:
                    selectMenu(input, "house");
                    break;
                case 3:
                    selectMenu(input, "room");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error. Please select menu");
            }
        }while (select!=4);
    }

    private void selectMenu(Scanner input, String type){
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
                return;
            }else if (!statusService.equals("0")){
                String statusCustomer = select(input, "customer");
                if (statusCustomer.equals("-1")){
                    return;
                }else if (!statusCustomer.equals("0")){
                    manage.writeBooking(statusService, statusCustomer);
                    statusService = "0";
                }
            }
        }while (!statusService.equals("0"));
    }
    private String select(Scanner input, String typeService){
        String dataShow = "";
        switch (typeService){
            case "villa":
                dataShow = manage.getService("villa");
                break;
            case "house":
                dataShow = manage.getService("house");
                break;
            case "room":
                dataShow = manage.getService("room");
                break;
            case "customer":
                dataShow = manage.getCustomer();
                break;
        }
        if(dataShow.contains("no data")){
            System.out.println(dataShow + "\n");
            return "-1";
        }
        String maxSelectStr = dataShow.substring(dataShow.indexOf(":")+2, dataShow.indexOf("available")-1);
        int maxSelect = Integer.parseInt(maxSelectStr) + 1;
        int select;
        do {
            System.out.print(dataShow + "\n" + maxSelect + ". Back\n" + (maxSelect+1) + ". Exit\n" + "Please select menu:");
            select = input.nextInt();
            input.nextLine();
            if(select<=0 || select>maxSelect+1){
                System.out.println("Error. Please select menu");
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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ControllerBooking booking = new ControllerBooking();
        booking.displayMainMenu(input);
    }
}
