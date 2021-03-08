package CaseStudy.manage;

import CaseStudy.models.Customer;

import java.util.Comparator;

public class SortCustomer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int value = o1.getName().compareTo(o2.getName());
        if(value==0){
            return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth());
        }else {
            return value;
        }
    }
}
