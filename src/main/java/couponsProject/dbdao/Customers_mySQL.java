package couponsProject.dbdao;

import couponsProject.beans.Customer;
import couponsProject.dao.CustomersDAO;
import couponsProject.db.DBManager;
import couponsProject.db.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customers_mySQL implements CustomersDAO {


    @Override
    public boolean isCustomerExist(String email, String password) throws SQLException {
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, email);
        map.put(2, password);
        ResultSet resultSet = DBTools.runStatementWithResultSet(QUERY_IS_EXISTS, map);
        resultSet.next();
        return (resultSet.getInt(1) == 1);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getFirstName());
        values.put(2, customer.getLastName());
        values.put(3, customer.getEmail());
        values.put(4, customer.getPassword());
        values.put(5, customer.getCoupons());

        return DBTools.runQuery(DBManager.CREATE_NEW_CUSTOMER, values);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer.getFirstName());
        values.put(2, customer.getLastName());
        values.put(3, customer.getEmail());
        values.put(4, customer.getPassword());
        values.put(5, customer.getCoupons());
        values.put(6, customer.getId());

        return DBTools.runQuery(DBManager.UPDATE_CUSTOMER, values);
    }

    @Override
    public void deleteCustomer(int customer_id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, customer_id);
        DBTools.runQuery(DBManager.DELETE_CUSTOMER, values);
    }

    @Override
    public List<Customer> getAllCustomers(String sql, Map<Integer, Object> values) {
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, values);
        try {
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getObject("id", java.util.UUID.class),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getObject("coupons", ArrayList.class)
                );
                customers.add(customer);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return customers;
    }

    @Override
    public Customer getOneCustomer(int customer_id) {
        return null;
    }
}
