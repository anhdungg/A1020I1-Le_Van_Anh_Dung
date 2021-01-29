package CaseStudy.models;

public class MainTest {
    public static void main(String[] args) {
        Villa villa = new Villa("01", 200, 3000, 4, "day",
                "5 sao", "Playstation 5", 50, 3);

        House house = new House("02", 200, 2000, 5, "month",
                "4 sao", "Tennis", 3);

        Room room = new Room("03", 100, 1000, 4, "year", "Nước lọc",
                10000, 3);
        room.addAccompanyingService("Karaoke", 12000, 1);
        System.out.println(villa.showInfor());
        System.out.println(house.showInfor());
        System.out.println(room.showInfor());

    }
}
