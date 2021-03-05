package CaseStudy.models;

public class Customer {
    private String name;
    private String gender;
    private String dayOfBirth;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services service;

    public Customer(){

    }

    public Customer(String name, String gender, String dayOfBirth, String idCard, String phoneNumber, String email,
                    String typeCustomer, String address) {
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public String showInfor(){
        String showService;
        if(service instanceof Villa){
            showService = ((Villa) service).showInfor();
        }else if(service instanceof House){
            showService = ((House) service).showInfor();
        }else {
            showService = ((Room) service).showInfor();
        }
        return "Name: " + this.name + ", Gender: " + this.gender + ", Day of birth: " + this.dayOfBirth
                +", Id card: " + this.idCard + ", Phone number: " + this.phoneNumber
                + ", Type customer: " +  this.typeCustomer + ", Address: " + this.address + "\nService: " + showService;
    }
}
