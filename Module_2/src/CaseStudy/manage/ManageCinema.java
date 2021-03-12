package CaseStudy.manage;

import CaseStudy.models.Ticket;
import java.util.Queue;
import java.util.Scanner;

public class ManageCinema {

    public String displayList(Queue<Ticket> queue){
        StringBuilder output = new StringBuilder("Danh sách người mua: " + queue.size() + " người\n");
        Ticket ticket;
        int count = 1;
        while ((ticket = queue.poll()) != null){
            output.append(count).append(". ").append(ticket.getName()).append("\n");
            count++;
        }
        return output.substring(0, output.length()-1);
    }

    public boolean buyTickets(Scanner input, Queue<Ticket> queue){
        System.out.print("Nhập tên: ");
        String name = input.nextLine();
        return queue.offer(new Ticket(name));
    }
}
