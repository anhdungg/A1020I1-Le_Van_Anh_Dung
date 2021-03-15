package CaseStudy.models;

import CaseStudy.manage.ManageEmployee;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FilingCabinets {
    Queue<Employee> queue = new ArrayDeque<>();
    public FilingCabinets() {
    }

    public void updateDataEmployee(){
        ManageEmployee manageEmployee = new ManageEmployee();
        ArrayList<Employee> list = manageEmployee.getListEmployee();
        if (list!=null) {
            queue.addAll(list);
        }else {
            queue = null;
        }
    }

    public Queue<Employee> getDataEmployee(){
        this.updateDataEmployee();
        return queue;
    }

}
