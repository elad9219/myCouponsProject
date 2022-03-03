package couponsProject.beans;

import java.util.ArrayList;
import java.util.UUID;

public class Customer {

    private UUID id = UUID.randomUUID();
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private ArrayList<Coupon> coupons;


    public Customer(UUID id, String firstName, String lastName, String email, String password, ArrayList<Coupon> coupons) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.email = email;
        this.password = password;
        this.coupons = coupons;
    }


    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first name='" + first_name + '\'' +
                ", last name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", coupons=" + coupons +
                '}';
    }
}
