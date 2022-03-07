package couponsProject.dbdao;

import couponsProject.beans.Company;
import couponsProject.dao.CompaniesDAO;
import couponsProject.db.DBManager;
import couponsProject.db.DBTools;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Companies_mySQL implements CompaniesDAO {
    @Override
    public boolean isCompanyExist(String email, String password) throws SQLException {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, email);
        map.put(2, password);
        ResultSet resultSet = null;//DBManager.COMPANY_IS_EXISTS;
        resultSet.next();
        return (resultSet.getInt(1) == 1);
    }

    @Override
    public boolean addCompany(Company company) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company.getName());
        values.put(2, company.getEmail());
        values.put(3, company.getPassword());
        values.put(4, company.getCoupons());

        return DBTools.runQuery(DBManager.CREATE_NEW_COMPANY, values);
    }

    @Override
    public boolean updateCompany(Company company) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, company.getName());
        values.put(2, company.getEmail());
        values.put(3, company.getPassword());
        values.put(4, company.getCoupons());
        values.put(5, company.getId());

        return DBTools.runQuery(DBManager.UPDATE_COMPANY, values);
    }

    @Override
    public void deleteCompany(int companyID) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, companyID);
        DBTools.runQuery(DBManager.DELETE_COMPANY, values);
    }


    @Override
    public List<Company> getAllCompanies(String sql, Map<Integer, Object> values) {
        List<Company> companies = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, values);
        try {
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getObject("id", java.util.UUID.class),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getObject("coupons", ArrayList.class)
                );
                companies.add(company);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return companies;
    }

    @Override
    public Company getOneCompany(int companyID) {
        return null;
    }

    @Override
    public boolean isNameOrEmailExist(String name, String email) throws SQLException {
        return false;
    }
}
