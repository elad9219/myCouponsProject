package couponsProject;

import couponsProject.beans.Category;
import couponsProject.beans.Coupon;
import couponsProject.db.DBManager;
import couponsProject.db.DBTools;

import java.sql.Date;
import java.time.LocalDate;

public class TestMain {
    public static void main(String[] args) {
        boolean allok = DBTools.runQuery(DBManager.CREATE_COUPONS_TABLE);
        Coupon coupon = new Coupon(null,1, Category.Electricity,"Computer Discount","a discount on computers", Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now().plusDays(12)),20,50,"google.com");
        System.out.println("command run successfully: ");
    }
}
