package CaseStudy.controllers;

import CaseStudy.manage.ManageCinema;
import CaseStudy.models.Ticket;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ControllerCinema {
    final private ManageCinema manage = new ManageCinema();
    private int maxTickets;
    Queue<Ticket> queue = new ArrayDeque<>();
    public void mainMenu(Scanner input){
        int select;
        while (true){
            System.out.print("1. Mua vé \n" +
                    "2. Kết thúc bán vé \n" +
                    "Chọn menu: ");
            select = input.nextInt();
            input.nextLine();
            switch (select){
                case 1:
                    if(manage.buyTickets(input, queue)){
                        System.out.println("Mua vé thành công\n");
                        this.maxTickets--;
                        if (this.maxTickets==0){
                            System.out.println("Hết vé!!!");
                            System.out.println(manage.displayList(queue));
                            return;
                        }
                    }
                    break;
                case 2:
                    System.out.println(manage.displayList(queue));
                    return;
                default:
                    System.out.println("Chọn sai. Hãy chọn lại!!!");
            }
        }
    }

    public void setMaxTickets(int maxTickets){
        this.maxTickets = maxTickets;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ControllerCinema controller = new ControllerCinema();
        System.out.print("Nhập số vé tối đa: ");
        controller.setMaxTickets(input.nextInt());
        controller.mainMenu(input);
    }
}
