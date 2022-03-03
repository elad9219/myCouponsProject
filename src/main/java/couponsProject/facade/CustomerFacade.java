package couponsProject.facade;

import couponsProject.beans.Category;
import couponsProject.beans.Coupon;
import couponsProject.beans.Customer;

import java.util.ArrayList;

public class CustomerFacade extends ClientFacade {


    public CustomerFacade() {
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    public void purchaseCoupon(Coupon coupon) {

    }

    public ArrayList<Coupon> getCustomerCoupons() {

        return null;
    }

    public ArrayList<Coupon> getCustomerCoupons(Category category) {

        return null;
    }

    public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {

        return null;
    }

    public Customer getCustomerDetails() {

        return null;
    }


}
