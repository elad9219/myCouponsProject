package couponsProject.dbdao;

import couponsProject.beans.Coupon;
import couponsProject.dao.CouponsDAO;
import couponsProject.db.DBManager;
import couponsProject.db.DBTools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coupons_mySQL implements CouponsDAO {
    @Override
    public boolean addCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getCategory());
        values.put(2, coupon.getTitle());
        values.put(3, coupon.getDescription());
        values.put(4, coupon.getStart_date());
        values.put(5, coupon.getEnd_date());
        values.put(6, coupon.getAmount());
        values.put(7, coupon.getPrice());
        values.put(8, coupon.getImage());

        return DBTools.runQuery(DBManager.CREATE_NEW_COUPON, values);
    }

    @Override
    public boolean updateCoupon(Coupon coupon) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon.getCategory());
        values.put(2, coupon.getTitle());
        values.put(3, coupon.getDescription());
        values.put(4, coupon.getStart_date());
        values.put(5, coupon.getEnd_date());
        values.put(6, coupon.getAmount());
        values.put(7, coupon.getPrice());
        values.put(8, coupon.getImage());
        values.put(9, coupon.getId());
        values.put(10, coupon.getCompany_id());


        return DBTools.runQuery(DBManager.UPDATE_COUPON, values);
    }

    @Override
    public void deleteCoupon(int coupon_id) {
        Map<Integer, Object> values = new HashMap<>();
        values.put(1, coupon_id);
        DBTools.runQuery(DBManager.DELETE_COUPON, values);
    }

    @Override
    public List<Coupon> getAllCoupons(String sql, Map<Integer, Object> values) {
        List<Coupon> coupons = new ArrayList<>();
        ResultSet resultSet = DBTools.runQueryForResult(sql, values);
        try {
            while (resultSet.next()) {
                Coupon coupon = new Coupon(
                        resultSet.getObject("id", java.util.UUID.class),
                        resultSet.getObject("company_id", java.util.UUID.class),
                        resultSet.getInt("category"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getInt("amount"),
                        resultSet.getDouble("price"),
                        resultSet.getString("image")
                        );
                coupons.add(coupon);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return coupons;
    }

    @Override
    public Coupon getOneCoupon(int coupon_id) {
        return null;
    }

    @Override
    public void addCouponPurchase(int customer_id, int coupon_id) {

    }

    @Override
    public void deleteCouponPurchase(int customer_id, int coupon_id) {

    }
}
