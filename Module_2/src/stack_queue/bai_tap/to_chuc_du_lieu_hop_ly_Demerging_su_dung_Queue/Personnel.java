package stack_queue.bai_tap.to_chuc_du_lieu_hop_ly_Demerging_su_dung_Queue;

public class Personnel {
    private String name;
    private String gender;
    private String dayOfBirth;

    public Personnel(String name, String gender, String dayOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getYearOfBirth(){
        StringBuilder year = new StringBuilder();
        for (int i=this.dayOfBirth.length()-4; i<this.dayOfBirth.length(); i++){
            year.append(this.dayOfBirth.charAt(i));
        }
        return Integer.parseInt(year.toString());
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'';
    }
}
