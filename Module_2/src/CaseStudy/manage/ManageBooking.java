package CaseStudy.manage;

import CaseStudy.controllers.ReadWriteFile;

public class ManageBooking {
    final private ManageService manageService = new ManageService();
    final private ManageCustomer manageCustomer = new ManageCustomer();
    final private ReadWriteFile readWriteFile = new ReadWriteFile();
    public String getService(String typeService){
        switch (typeService){
            case "villa":
                return manageService.showServices("villa");
            case "house":
                return manageService.showServices("house");
            case "room":
                return manageService.showServices("room");
        }
        return "";
    }

    public String getCustomer(){
        return manageCustomer.showInformationCustomer();
    }

    public void writeBooking(String idService, String idCustomer){
        readWriteFile.writeFile("booking", idService + "," + idCustomer);
    }
}
