package com.example.yyonlineorder.dao;

import com.example.yyonlineorder.entity.Authorities;
import com.example.yyonlineorder.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setEmail(customer.getEmail());
        authorities.setAuthorities("ROLE_USER");

        Session session = null;

        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(session != null) session.getTransaction().rollback();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    public Customer getCustomer(String email) {
        Customer customer = null;
        try (Session session = sessionFactory.openSession()) {
            customer = session.get(Customer.class, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }
}
