package practiceJDBC;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {


        /**
         * Three steps when connecting to Data Base
         *
         * 1. Connection Object
         * 2. Statement Object
         * 3. ResultSet Object
         */

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/HR_Production",
                "postgres",
                "admin");

        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery("select * from employees");

//        resultSet.next();
//        System.out.println(resultSet.getString(1));

        int count=0;
        while (resultSet.next()){
            count++;
           // System.out.println(count+": "+resultSet.getString(2)+" "+resultSet.getString(3));
           // System.out.println(resultSet.getString("first_name"));
        }

        /**
         * ResultSetMetaData --> It holds data about data(Data about table);
         */

        ResultSetMetaData metaData= resultSet.getMetaData();
        System.out.println(metaData.getColumnCount());
        System.out.println(metaData.getTableName(1));

        for (int i=1; i<metaData.getColumnCount();i++){
            System.out.println("Column Name: "+metaData.getColumnName(i));
        }
    }
}
