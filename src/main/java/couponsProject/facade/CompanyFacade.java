package couponsProject.facade;

import couponsProject.beans.Category;
import couponsProject.beans.Company;
import couponsProject.beans.Coupon;
import couponsProject.dbdao.Companies_mySQL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompanyFacade extends ClientFacade {


    public CompanyFacade() {
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    public void addCoupon(Coupon coupon) {

    }

    public void updateCoupon(Coupon coupon) {

    }

    public void deleteCoupon(int coupon_id) {

    }

    public List<Coupon> getAllCoupons() {
        return null;
    }

    public ArrayList<Coupon> getCompanyCoupons(Category category) {

        return null;
    }

    public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {

        return null;
    }

    public Company getCompanyDetails() {

        return null;
    }
}
