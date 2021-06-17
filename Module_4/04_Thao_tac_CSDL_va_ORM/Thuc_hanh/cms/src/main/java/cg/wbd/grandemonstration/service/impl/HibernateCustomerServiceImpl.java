package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.hibernate.HibernateUtil;
import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class HibernateCustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> list = null;
        try {
            session = HibernateUtil.sessionFactory.openSession();
            list = session.createQuery("From Customer").getResultList();

        }finally {
            if (session != null){
                session.close();
            }
        }
        return list;
    }

    @Override
    public Customer findOne(Long id) {
        Customer customer = null;
        Session session = null;
        try {
            session = HibernateUtil.sessionFactory.openSession();
            customer = session.get(Customer.class, id);
        }finally {
            if (session != null){
                session.close();
            }
        }
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }

}
