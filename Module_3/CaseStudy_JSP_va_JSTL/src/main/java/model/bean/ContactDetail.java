package model.bean;

public class ContactDetail {
    private int id;
    private int idContact;
    private int accompanyingServices;
    private int amount;

    public ContactDetail(int idContact, int accompanyingServices, int amount) {
        this.idContact = idContact;
        this.accompanyingServices = accompanyingServices;
        this.amount = amount;
    }

    public ContactDetail(int id, int idContact, int accompanyingServices, int amount) {
        this.id = id;
        this.idContact = idContact;
        this.accompanyingServices = accompanyingServices;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public int getAccompanyingServices() {
        return accompanyingServices;
    }

    public void setAccompanyingServices(int accompanyingServices) {
        this.accompanyingServices = accompanyingServices;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
