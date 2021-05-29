package model.bean;

public class Contact {
    private int id;
    private int idEmployee;
    private String idCustomer;
    private String idService;
    private String contactDate;
    private String endDate;
    private double depositMoney;
    private double totalMoney;

    public Contact(int idEmployee, String idCustomer, String idService, String contactDate, String endDate, double depositMoney, double totalMoney) {
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
        this.contactDate = contactDate;
        this.endDate = endDate;
        this.depositMoney = depositMoney;
        this.totalMoney = totalMoney;
    }

    public Contact(int id, int idEmployee, String idCustomer, String idService, String contactDate, String endDate,
                   double depositMoney, double totalMoney) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
        this.contactDate = contactDate;
        this.endDate = endDate;
        this.depositMoney = depositMoney;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
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

    public double getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", idEmployee=" + idEmployee +
                ", idCustomer=" + idCustomer +
                ", idService=" + idService +
                ", contactDate='" + contactDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", depositMoney=" + depositMoney +
                ", totalMoney=" + totalMoney;
    }
}
