package couponsProject.facade;

import couponsProject.dao.CompaniesDAO;
import couponsProject.dao.CouponsDAO;
import couponsProject.dao.CustomersDAO;

public abstract class ClientFacade {

    protected CompaniesDAO companiesDAO;
    protected CustomersDAO customersDAO;
    protected CouponsDAO couponsDAO;


    public boolean login(String email, String password) {
        return false;
    }
}
