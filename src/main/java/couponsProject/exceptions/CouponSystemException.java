package couponsProject.exceptions;

public class CouponSystemException extends Exception {
    public CouponSystemException(String msg) {
        super(msg);
    }
    public CouponSystemException(ErrorMsg errors) {
        super(errors.getMsg());
    }
}
