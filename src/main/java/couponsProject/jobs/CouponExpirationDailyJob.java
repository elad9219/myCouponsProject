package couponsProject.jobs;

import couponsProject.beans.Coupon;
import couponsProject.dao.CouponsDAO;

import java.util.Date;
import java.util.Set;

public class CouponExpirationDailyJob implements Runnable{
    private Set<Coupon> coupons;
    private boolean isRunning;
    private CouponsDAO couponsDAO;
    private boolean quit;

    public CouponExpirationDailyJob(Set<Coupon> coupons, boolean isRunning, CouponsDAO couponsDAO, boolean quit) {
        this.coupons = coupons;
        this.isRunning = isRunning;
        this.couponsDAO = couponsDAO;
        this.quit = quit;
    }

    @Override
    public void run() { while (true) {
        for (Coupon item : coupons) {
            if (!item.isExpired()) {
                //check date
                if (item.getStart_date().before(new Date(System.currentTimeMillis()))) {
                    item.setExpired(true);
                    System.out.println("Coupon is expired  \n==============\n");
                    //anonymous thread
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int counter = 0; counter < 3; counter++) {
                                try{Thread.sleep(30_000);}catch (Exception e){}
                                System.out.println("Coupon is expired!!!");
                            }
                        }
                    }).start();
                }
            }
        }
        try {
            Thread.sleep(1000 * 60 * 60 * 24);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
    }
}
