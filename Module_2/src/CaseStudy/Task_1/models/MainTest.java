package CaseStudy.Task_1.models;

public class MainTest {
    public static void main(String[] args) {
        Villa villa = new Villa(200, 3000, 4, "day",
                "5 star", "Playstation 5", 50, 3);

        House house = new House(200, 2000, 5, "month",
                "4 star", "Tennis", 3);

        Room room = new Room(100, 1000, 4, "year", "5 star",
                "Playstation 4");
        System.out.println(villa.showInfor());
        System.out.println(house.showInfor());
        System.out.println(room.showInfor());

    }
}
