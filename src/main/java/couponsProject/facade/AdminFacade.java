package couponsProject.facade;

import couponsProject.beans.Company;
import couponsProject.beans.Customer;
import couponsProject.dao.CompaniesDAO;
import couponsProject.db.DBManager;
import couponsProject.exceptions.CouponSystemException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminFacade extends ClientFacade{

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    /*public void addCompany2(Company company) throws CouponSystemException {
        List<Company> companies = this.companiesDAO.addCompany(DBManager.CREATE_NEW_COMPANY,);
        for (Company comp:companies) {
            if(comp.getName().equals(company.getName())){
                throw new CouponSystemException("Cannot insert a company with exist name");
            }
            if(comp.getEmail().equals(company.getEmail())){
                throw new CouponSystemException("Cannot insert a company with exist email");
            }
        }
        this.companiesDAO.addCompany(company);
    }

     */


    public void addCompany(Company company) throws CouponSystemException, SQLException {

        if(!this.companiesDAO.isNameOrEmailExist(company.getName(),company.getEmail())){
            throw new CouponSystemException("Sorry name or email already exist...");
        }

        this.companiesDAO.addCompany(company);
    }

    public void updateCompany(Company company){

    }

    public void deleteCompany(int CompanyID){

    }

    public List<Company> getAllCompanies(){
        return null;
    }


}
