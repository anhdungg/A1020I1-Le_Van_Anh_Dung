package model.bean;

public class ContactView {
    private String nameCustomer;
    private String typeCustomer;
    private String nameService;
    private String typeService;
    private String contactDate;
    private String endDate;

    public ContactView(String nameCustomer, String typeCustomer, String nameService, String typeService, String contactDate,
                       String endDate) {
        this.nameCustomer = nameCustomer;
        this.typeCustomer = typeCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
        this.contactDate = contactDate;
        this.endDate = endDate;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
