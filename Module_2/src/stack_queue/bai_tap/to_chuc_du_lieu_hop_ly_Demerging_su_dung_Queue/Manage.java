package stack_queue.bai_tap.to_chuc_du_lieu_hop_ly_Demerging_su_dung_Queue;

import java.util.*;

public class Manage {
    public static void main(String[] args) {
        Personnel[] person = new Personnel[10];
        person[0] = new Personnel("Dung", "Nam", "05/11/1997");
        person[1] = new Personnel("Linh", "Nu", "14/05/1995");
        person[2] = new Personnel("Thanh", "Nu", "08/03/1972");
        person[3] = new Personnel("Dao", "Nam", "25/10/1969");
        person[4] = new Personnel("Son", "Nam", "25/10/1970");
        person[5] = new Personnel("Kien", "Nam", "25/10/1991");
        person[6] = new Personnel("Hoa", "Nu", "25/10/2000");
        person[7] = new Personnel("Duc", "Nam", "25/10/2002");
        person[8] = new Personnel("Hoang", "Nam", "25/10/1991");
        person[9] = new Personnel("Tai", "Nam", "25/10/1999");

        LinkedList<Personnel> male = new LinkedList<>();
        LinkedList<Personnel> female = new LinkedList<>();

        for (Personnel value : person) {
            if (value.getGender().equals("Nam")) {
                male.add(value);
            } else if (value.getGender().equals("Nu")) {
                female.add(value);
            }
        }

        Collections.sort(male);
        Collections.sort(female);

        System.out.println("Dữ liệu nguyên bản: ");
        for (Personnel personnel : person){
            System.out.println(personnel.toString());
        }
        System.out.println("Dữ liệu sau khi được tổ chức lại: ");
        for (int i=0; i<person.length; i++){
            if(i<female.size()){
                person[i] = female.get(i);
            }else {
                person[i] = male.get(i-female.size());
            }
        }
        for (Personnel personnel : person){
            System.out.println(personnel.toString());
        }
    }

    static private void sortList(Personnel person, LinkedList<Personnel> list){
        if (list.isEmpty()) {
            list.add(person);
        } else {
            int sizeMale = list.size();
            if (sizeMale == 1) {
                if (person.getYearOfBirth() >= list.get(0).getYearOfBirth()) {
                    list.addLast(person);
                } else {
                    list.addFirst(person);
                }
            } else {
                for (int j = 0; j < sizeMale; j++) {
                    if (j == 0) {
                        if (person.getYearOfBirth() <= list.get(j).getYearOfBirth()) {
                            list.addFirst(person);
                            break;
                        }
                    } else if(j<sizeMale-1){
                        if (person.getYearOfBirth() >= list.get(j - 1).getYearOfBirth() &&
                                person.getYearOfBirth() < list.get(j).getYearOfBirth()) {
                            list.add(j, person);
                            break;
                        }
                    } else {
                        if(person.getYearOfBirth() >= list.get(j).getYearOfBirth()){
                            list.addLast(person);
                        }else {
                            list.add(j, person);
                        }
                    }
                }
            }
        }
    }
}
