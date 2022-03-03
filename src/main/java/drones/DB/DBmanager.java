package drones.DB;

public class DBmanager {
    public static final String URL = "jdbc:mysql://localhost:3306/";//שרת מקומי של המחשב
    public static final String SQL_USER = "root";  //שם משתמש ב- sql workbench
    public static final String SQL_PASSWORD = "12345678";  // סיסמא ב- sql workbench

    //Databases
    public static final String CREATE_DB = "CREATE SCHEMA `drone_lab` ";
    public static final String DROP_DB = "DROP SCHEMA `drone_lab` ";

    // Tables
    public static final String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS `drone_lab`.`customers` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `name` VARCHAR(45) NOT NULL," +
            "  `phone` VARCHAR(12) NOT NULL," +
            "  `city` VARCHAR(45) NOT NULL," +
            "  `vip` TINYINT NOT NULL," +
            "  `urgent` VARCHAR(45) NOT NULL," +
            "  PRIMARY KEY (`id`));";

    public static final String CREATE_DRONES_TABLE = "CREATE TABLE IF NOT EXISTS `drone_lab`.`drones` (" +
            "  `id` INT NOT NULL AUTO_INCREMENT," +
            "  `client_id` INT NULL," +
            "  `manufacture` VARCHAR(45) NULL," +
            "  `model` VARCHAR(45) NULL," +
            "  `eta` DATETIME NULL," +
            "  `entered` DATETIME NULL," +
            "  PRIMARY KEY (`id`));";

    public static final String CREATE_NEW_CUSTOMER = "INSERT INTO `drone_lab`.`customers` " +
            "(`name`, `phone`, `city`, `vip`, `urgent`) " +
            "VALUES (?,?,?,?,?)";


    public static final String DELETE_CUSTOMER = "DELETE FROM `drone_lab`.`customers` WHERE id = ? ";

    public static final String UPDATE_CUSTOMER = "UPDATE `drone_lab`.`customers` " +
            "SET name = ?, phone = ?, city = ?, vip = ?, urgent = ? " +
            "WHERE id = ? ";

    public static final String GET_ALL_CUSTOMER = "SELECT * FROM `drone_lab`.`customers` ";
    public static final String GET_SINGLE_CUSTOMER = "SELECT * FROM `drone_lab`.`customers` WHERE id = ? ";
    public static final String GET_ALL_CITY = "SELECT * FROM `drone_lab`.`customers` WHERE city = ? ";

    public static final String CREATE_DRONE = "INSERT INTO `drone_lab`.`drones` " +
            "(`client_id`, `manufacture`, `model`, `eta`, `entered`) " +
            "VALUES (?,?,?,?,?)";
}

