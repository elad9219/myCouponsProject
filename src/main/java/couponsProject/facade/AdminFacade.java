package couponsProject.facade;

import couponsProject.beans.Company;
import couponsProject.beans.Customer;
import couponsProject.dao.CompaniesDAO;

import java.util.ArrayList;

public class AdminFacade extends ClientFacade {


    public AdminFacade() {
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    public void addCompany(Company company) {

    }



    public void updateCompany(Company company) {

    }

    public void deleteCompany(int company_id) {

    }

    public ArrayList<Company>  getAllCompanies() {

        return null;
    }

    public Company getOneCompany(int company_id) {

        return null;
    }

    public void addCustomer(Customer customer) {

    }

    public void updateCustomer(Customer customer) {

    }

    public void deleteCustomer(int customer_id) {

    }

    public ArrayList<Customer> getAllCustomers() {

        return null;
    }

    public Customer getOneCustomer(int customer_id) {

        return null;
    }





}
