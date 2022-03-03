package couponsProject.db;



import java.sql.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DBTools {
    public static boolean runQuery(String sql) {
        // use connection from connection sql to sent queries to our db
        Connection connection = null;

        try {
            //get a connection for connection pool
            connection = couponsProject.db.ConnectionPool.getInstance().getConnection();

            //prepare our sql (String) and convert it to a language that mySQL will understand
            PreparedStatement statement = connection.prepareStatement(sql);

            //run statement
            statement.execute();

            return true;
        } catch (InterruptedException | SQLException err) {
            System.out.println(err.getMessage());

            return false;
        } finally {
            couponsProject.db.ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    public static boolean runQuery(String sql, Map<Integer, Object> parameters) {
        Connection connection = null;
        try {
            connection = couponsProject.db.ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            parameters.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    }
                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }
            });
            preparedStatement.execute();
            return true;
        } catch (InterruptedException | SQLException err) {
            err.printStackTrace();
        } finally {
            couponsProject.db.ConnectionPool.getInstance().returnConnection(connection);
        }


        return false;
    }

    public static ResultSet runQueryForResult(String sql, Map<Integer, Object> parameters) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            parameters.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        preparedStatement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        preparedStatement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        preparedStatement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        preparedStatement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        preparedStatement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        preparedStatement.setFloat(key, (Float) value);
                    }
                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }
            });

            return preparedStatement.executeQuery();
        } catch (InterruptedException | SQLException err) {
            System.out.println(err.getMessage());
            return null;
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

}
