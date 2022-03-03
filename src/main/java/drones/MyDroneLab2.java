package drones;

import drones.DB.DBmanager;
import drones.DB.DBtools;
import drones.beans.Customer;
import drones.beans.Drones;
import drones.dao.CustomerDao;
import drones.dbdao.Customer_mysql;
import drones.dbdao.Drone_mysql;
import drones.jobs.RepairScanner;

import java.util.*;

public class MyDroneLab2 {
    public static void main(String[] args) {

        // boolean allOk = DBtools.runQuery(DBmanager.CREATE_DB);
        // System.out.println("command run successfully: " + allOk);

        // boolean allOk = DBtools.runQuery(DBmanager.DROP_DB);
        // System.out.println("command run successfully: " + allOk);

        boolean allOk = DBtools.runQuery(DBmanager.CREATE_CUSTOMER_TABLE);
        System.out.println("command run successfully: " + allOk);

        allOk = DBtools.runQuery(DBmanager.CREATE_DRONES_TABLE);
        System.out.println("command run successfully: " + allOk);


        //Customer customer = new Customer(7, "Yoav Hacmon", "052-890-9321", "Karnei Shomron", true, true);

        CustomerDao dbCustomer = new Customer_mysql();  // כאן אפשר לשנות בין SQL ל-database אחר
        // dbCustomer.addCustomer(customer);
        // dbCustomer.updateCustomer(customer);
        //dbCustomer.deleteCustomer(6);  // מחיקת משתמש במיקום מסוים
        //System.out.println("command run successfully: " + allOk);

       // Customer talBechor = dbCustomer.getCustomerById(5);
       // System.out.println(talBechor == null? "User not found" : talBechor);

        Map<Integer, Object> values = new HashMap<>();
        values.put(1,"Tel Aviv");
        List<Customer> allCustomers = dbCustomer.getCustomers(DBmanager.GET_ALL_CITY, values);
        allCustomers.forEach(System.out::println);



        //running thread...
        Drone_mysql dronesDBdao = new Drone_mysql();
        Set<Drones> drones = dronesDBdao.getAllDrones();


        //Runnable !!!
        RepairScanner droneScanner = new RepairScanner(drones);
        //THREAD !!!!
        Thread theScanner = new Thread(droneScanner);
        //START
        theScanner.start();

    }
}
