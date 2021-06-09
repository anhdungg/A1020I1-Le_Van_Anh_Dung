package customer.repository;

import customer.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(0, "Nguyen Van A", "a@gmail.com", "Da Nang"));
        customerList.add(new Customer(1, "Nguyen Van B", "b@gmail.com", "Quang Nam"));
        customerList.add(new Customer(2, "Nguyen Van C", "c@gmail.com", "Hue"));
        customerList.add(new Customer(3, "Nguyen Van D", "d@gmail.com", "Quang Binh"));
        customerList.add(new Customer(4, "Nguyen Van E", "e@gmail.com", "Quang Tri"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }
}
