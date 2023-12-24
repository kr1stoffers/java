package Lab9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

public class DB {
    Connection conn = null; // объект для связи с БД
    Statement stmt = null; // объект для создания SQL-запросов
    HashMap<String, String> selectsForTables;

    public DB(String curPath) {
        super();
        try {
            conn = DriverManager
                    .getConnection("jdbc:sqlite:C:/Users/kr1stoffers/Documents/java/labs/src/Lab9/t.sqlite");
            stmt = conn.createStatement();
            stmt.setQueryTimeout(30);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                selectsForTables = new HashMap<String, String>();
                selectsForTables.put("Edged", "select name, manufacturer, damage, length, hardness "
                        + " from Edged;");
                selectsForTables.put("Firearm", "select name, manufacturer, damage, caliber, recharge"
                        + " from Firearm;");
                selectsForTables.put("Armouries", "select type,"
                        + " (select count(*) from Edged where Armouries.id = Edged.armID) as 'Count of Edged',"
                        + " (select count(*) from Firearm where Armouries.id = Firearm.armID) as 'Count of Firearm'"
                        + " from Armouries;");
            }
        }
    }

    public JTable getTableWithJoin(String tableName) {
        ArrayList<String> colNames = new ArrayList<>();
        String[][] data = null;
        ResultSet localRS = null;
        try {

            localRS = stmt.executeQuery(selectsForTables.get(tableName));
            ResultSetMetaData rsmd = localRS.getMetaData();

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                colNames.add(rsmd.getColumnName(i));
            }

            // System.out.println(System.getProperty("user.dir"));
            while (localRS.next()) {
            }
            data = new String[localRS.getRow()][colNames.size()];
            localRS.close();
            localRS = stmt.executeQuery(selectsForTables.get(tableName));

            while (localRS.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    data[localRS.getRow() - 1][i - 1] = localRS.getString(i);
                }
            }
        } catch (SQLException e) {
            System.out.println("Trouble with query!!");
            e.printStackTrace();
        }
        return new JTable(data, colNames.toArray());
    }

    public void closeConnection() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
