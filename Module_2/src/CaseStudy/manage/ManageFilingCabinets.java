package CaseStudy.manage;

import CaseStudy.models.Employee;
import CaseStudy.models.FilingCabinets;

import java.util.Queue;

public class ManageFilingCabinets {
    final private FilingCabinets filingCabinets = new FilingCabinets();

    public String findFileEmployee(String type, String data){
        StringBuilder output = new StringBuilder();
        Queue<Employee> queue = filingCabinets.getDataEmployee();
        if (queue==null){
            return "Không tìm thấy hồ sơ nhân viên";
        }else {
            Employee employee;
            while ((employee = queue.poll()) != null){
                switch (type){
                    case "name":
                        if (employee.getName().equalsIgnoreCase(data)){
                            output.append(employee.toString()).append("\n");
                        }
                        break;
                    case "yearOld":
                        if (employee.getYearOld() == Integer.parseInt(data)){
                            output.append(employee.toString()).append("\n");
                        }
                        break;
                    default:
                        if (employee.getAddress().equalsIgnoreCase(data)){
                            output.append(employee.toString()).append("\n");
                        }
                }
            }
        }
        if (output.length()>1) {
            return output.substring(0, output.length() - 1);
        }else {
            return "Không tìm thấy hồ sơ nhân viên";
        }
    }
}
