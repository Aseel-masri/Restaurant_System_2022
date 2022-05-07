package myproject.software.restaurants_rating_2022;
import java.sql.Connection;
import java.sql.DriverManager;
public class conection {
    public Connection connection;
    public  Connection getConnection(){


        String dbName="rrr3";
        String userName="root";
        String password="";

        try {

            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
