package bai_tap_them.models;

public class Study {
    String id;
    String name;
    String dayOfBirth;
    String gender;
    String nameClass;

    public Study(String id, String name, String gender, String dayOfBirth, String nameClass) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.nameClass = nameClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Id: " + this.id +
                ", Name: " + this.name +
                ", Gender: " + this.gender +
                ", Day of birth: " + this.dayOfBirth +
                ", Class: " + this.nameClass;
    }
}
