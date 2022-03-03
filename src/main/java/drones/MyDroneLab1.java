package drones;

import drones.DB.ConnectionPool;
import drones.DB.SQLExamples;

public class MyDroneLab1 {
    public static void main(String[] args) {
        ConnectionPool cp1 = null, cp2 = null, cp3 = null;

        //  ConnectionPool cp = new ConnectionPool();  הבנאי הוא פרייבט, לכן אי אפשר

        cp1 = ConnectionPool.getInstance(); //here we created instance
        cp2 = ConnectionPool.getInstance(); //here we use existing instance
        cp3 = ConnectionPool.getInstance(); //here we use existing instance

        /*
        cp1.showMeTheMoney();
        cp2.showMeTheMoney();
        cp3.showMeTheMoney();

        System.out.println(cp1);
        System.out.println(cp2);
        System.out.println(cp3);
         */

        /*
        try {
            DBtools.runQuery("INSERT INTO student (name, phone, city, course, age) VALUES ('Moshik', '058-901-9909', 'Holon', 'full stack java', 32)");
        } catch (SQLException err) {
            err.printStackTrace();
        }
         */

       // Student student = new Student(0, "Geri G.", "052-833-9014", "Ramat Hagolan", "full stack java", 37);
      //  System.out.println("all is ok? " + SQLExamples.addStudent(student));

        SQLExamples.deleteById(13);
        SQLExamples.deleteById(14);


        try {
            ConnectionPool.getInstance().closeAllConnections();
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
