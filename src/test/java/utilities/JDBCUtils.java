package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;



    public static void establishConnection(String c_r_p_URL,String c_r_p_UserName,String c_r_p_PassWord) throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty(c_r_p_URL),
                ConfigReader.getProperty(c_r_p_UserName),
                ConfigReader.getProperty(c_r_p_PassWord));

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public static List<Map<String, Object>> runQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);

        List<Map<String, Object>> tableData = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next()) {

            Map<String, Object> rowData = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                rowData.put(metaData.getColumnName(i), resultSet.getString(metaData.getColumnName(i)));
            }
            tableData.add(rowData);
        }


        return tableData;
    }

    public static void closeDataBase() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
