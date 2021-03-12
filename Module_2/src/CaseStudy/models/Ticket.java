package CaseStudy.models;

public class Ticket {
    private String name;
    private int maxTickets;

    public Ticket() {

    }

    public Ticket(String name) {
        this.name = name;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public int getMaxTickets(){
        return this.maxTickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "name='" + name + '\'' +
                '}';
    }
}
