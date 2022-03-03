package couponsProject.dao;


import couponsProject.beans.Coupon;
import couponsProject.beans.Customer;

import java.util.List;
import java.util.Map;

public interface CouponsDAO {

    boolean addCoupon(Coupon coupon);

    boolean updateCoupon(Coupon coupon);

    void deleteCoupon(int coupon_id);

    List<Coupon> getAllCoupons(String sql, Map<Integer, Object> values);

    Coupon getOneCoupon(int coupon_id);

    void addCouponPurchase(int customer_id, int coupon_id);

    void deleteCouponPurchase(int customer_id, int coupon_id);

}
