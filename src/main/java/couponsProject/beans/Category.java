package couponsProject.beans;

public enum Category {
    Food,
    Electricity,
    Restaurant,
    Vacation;

    public final int value = 1 + ordinal();

}
