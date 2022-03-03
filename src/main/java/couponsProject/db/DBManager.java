package couponsProject.db;

public class DBManager {
    public static final String URL = "jdbc:mysql://localhost:3306/";//שרת מקומי של המחשב
    public static final String SQL_USER = "root";  //שם משתמש ב- sql workbench
    public static final String SQL_PASSWORD = "12345678";  // סיסמא ב- sql workbench

    //Databases
    public static final String CREATE_DB = "CREATE SCHEMA `coupons_lab` ";
    public static final String DROP_DB = "DROP SCHEMA `coupons_lab` ";


    //tables

    public static final String CREATE_COMPANIES_TABLE = "CREATE TABLE IF NOT EXISTS `coupons_lab`.`companies` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  `email` VARCHAR(45) NOT NULL," +
            "  `password` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`));";


    public static final String CREATE_NEW_COMPANY = "INSERT INTO `coupons_lab`.`companies` " +
            "(`name`, `email`, `password`, `coupons`) " +
            "VALUES (?,?,?,?)";


    public static final String UPDATE_COMPANY = "UPDATE `coupons_lab`.`companies` " +
            "SET name = ?, email = ?, password = ?, coupons = ? " +
            "WHERE id = ? ";


    public static final String DELETE_COMPANY = "DELETE FROM `coupons_lab`.`companies` WHERE id = ? ";



    public static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS `coupons_lab`.`customers` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `first_name` VARCHAR(45) NOT NULL," +
            "  `last_name` VARCHAR(45) NOT NULL," +
            "  `email` VARCHAR(45) NOT NULL," +
            "  `password` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`));";


    public static final String CREATE_NEW_CUSTOMER = "INSERT INTO `coupons_lab`.`customers` " +
            "(`first_name`, `last_name`, `email`, `password`, `coupons`) " +
            "VALUES (?,?,?,?,?)";


    public static final String UPDATE_CUSTOMER = "UPDATE `coupons_lab`.`customers` " +
            "SET first_name = ?, last_name = ?, email = ?, password = ?, coupons = ? " +
            "WHERE id = ? ";


    public static final String DELETE_CUSTOMER = "DELETE FROM `coupons_lab`.`customers` WHERE id = ? ";


    public static final String CREATE_NEW_COUPON = "INSERT INTO `coupons_lab`.`coupons` " +
            "(`category`, `title`, `description`, `start_date`, `end_date`, `amount`, `price`, `image`) " +
            "VALUES (?,?,?,?,?,?,?,?)";


    public static final String UPDATE_COUPON = "UPDATE `coupons_lab`.`coupons` " +
            "SET category=?, title=?, description=?, start_date=?, end_date=?, amount=?, price=?, image=? " +
            "WHERE id = ? ";


    public static final String DELETE_COUPON = "DELETE FROM `coupons_lab`.`coupons` WHERE id = ? ";


    public static final String CREATE_CATEGORIES_TABLE = "CREATE TABLE IF NOT EXISTS `coupons_lab`.`categories` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`));";


    public static final String CREATE_COUPONS_TABLE = "CREATE TABLE IF NOT EXISTS `coupons_lab`.`coupons` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `company_id` INT NOT NULL," +
            "  `category` INT NOT NULL," +
            "  `title` VARCHAR(45) NOT NULL," +
            "  `description` VARCHAR(45) NOT NULL," +
            "  `start_date` DATETIME NOT NULL," +
            "  `end_date` DATETIME NOT NULL," +
            "  `amount` INT NOT NULL," +
            "  `price` DOUBLE NOT NULL," +
            "  `image` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`))," +
            "  INDEX `company_id_idx` (`company_id` ASC) VISIBLE," +
            "  INDEX `category_id_idx` (`category_id` ASC) VISIBLE," +
            "  CONSTRAINT `company_id`" +
            "  FOREIGN KEY (`company_id`)" +
            "  REFERENCES `bhp-g1-coup-sys-p1`.`companies` (`id`)" +
            "  ON DELETE NO ACTION" +
            "  ON UPDATE NO ACTION," +
            "  CONSTRAINT `category_id`" +
            "  FOREIGN KEY (`category_id`)" +
            "  REFERENCES `bhp-g1-coup-sys-p1`.`categories` (`id`)" +
            "  ON DELETE NO ACTION" +
            "  ON UPDATE NO ACTION)";


    public static final String CREATE_CUSTOMERS_VS_COUPONS_TABLE = "CREATE TABLE IF NOT EXISTS `coupons_lab`.`categories` (" +
            " `customer_id` INT NOT NULL," +
            " `coupon` INT NOT NULL," +
            "  PRIMARY KEY (`customer_id`, `coupon_id`)," +
            "  INDEX `coupon_id_idx` (`coupon_id` ASC) VISIBLE," +
            "  CONSTRAINT `customer_id`" +
            "  FOREIGN KEY (`customer_id`)" +
            " REFERENCES `bhp-g1-coup-sys-p1`.`customers` (`id`)" +
            " ON DELETE NO ACTION" +
            " ON UPDATE NO ACTION," +
            " CONSTRAINT `coupon_id`" +
            " FOREIGN KEY (`coupon_id`)" +
            " REFERENCES `bhp-g1-coup-sys-p1`.`coupons` (`id`)" +
            " ON DELETE NO ACTION" +
            " ON UPDATE NO ACTION)";

}
