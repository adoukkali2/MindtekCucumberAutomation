package practiceJDBC;

import utilities.JDBCUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProjectDayJDBC {
    public static void main(String[] args) throws SQLException {
        JDBCUtils.establishConnection("ELARDBURL","ElarDBUsername","ElarDBPassword");
        List<Map<String, Object>> tableData=JDBCUtils.runQuery("select * from core_yard");

        for (Map<String, Object> data: tableData){
            System.out.println(data.get("location"));
        }

    }
}
