package CaseStudy.manage;

import CaseStudy.controllers.ReadWriteFile;
import CaseStudy.models.Employee;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class ManageEmployee {

    public String showInformationEmployee(){
        StringBuilder output = new StringBuilder();
        TreeMap<String, Employee> map = new TreeMap<>();
        ArrayList<Employee> list = this.getListEmployee();
        for (int i=0; i<list.size(); i++){
            if(i+1<10){
                map.put("00" + (i+1), list.get(i));
            }else if (i+1<100){
                map.put("0" + (i+1), list.get(i));
            }else {
                map.put("" + (i+1), list.get(i));
            }
        }
        Set<String> set = map.keySet();
        for (String key : set){
            output.append("Id: ").append(key).append(", ").append(map.get(key).toString()).append("\n");
        }
        return output.toString().substring(0, output.length()-2);
    }

    public ArrayList<Employee> getListEmployee(){
        ArrayList<Employee> list = new ArrayList<>();
        String dataRead = this.getDataEmployee();
        String[] strData = new String[3];
        StringBuilder str = new StringBuilder();
        int count=0;
        for (int i=0; i<dataRead.length(); i++){
            if(dataRead.charAt(i) == ','){
                strData[count] = str.toString();
                count++;
                str = new StringBuilder();
                continue;
            }else if ((int)dataRead.charAt(i) == 10){
                strData[count] = str.toString();
                count=0;
                str = new StringBuilder();
                list.add(new Employee(strData[0], Integer.parseInt(strData[1]), strData[2]));
                continue;
            }
            str.append(dataRead.charAt(i));
        }
        return list;
    }

    public String getDataEmployee(){
        ReadWriteFile readWriteFile = new ReadWriteFile();
        return readWriteFile.readFile("employee").substring(ReadWriteFile.getHeaderEmployee().length()+1);
    }

//    public static void main(String[] args) {
//        ManageEmployee manage = new ManageEmployee();
//        System.out.println(manage.showInformationEmployee());
//    }
}
