package practiceJDBC;

import utilities.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTest3 {
    public static void main(String[] args) throws SQLException {
        JDBCUtils.establishConnection("DBURL","DBUsername","DBPassword");
        List<Map<String, Object>> tableData=JDBCUtils.runQuery("select * from employees where first_name like '%a%' " +
                "order by first_name desc");

        for (Map<String, Object> data: tableData){
            System.out.println(data.get("last_name"));
        }

        JDBCUtils.closeDataBase();
    }
}
