package Modules;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Get_TABLE_Data {

    public Get_TABLE_Data(String Data_Select, JTable Table_Name) throws SQLException {
        // Connection and the Statement
        Connection c = Connection_fun.con();
        Statement statement = c.createStatement();

        // Table Code
        DefaultTableModel TableModels = (DefaultTableModel) Table_Name.getModel();
        TableModels.setRowCount(0);  // Clear the table

        // Execute the query and retrieve the result set
        ResultSet Result = statement.executeQuery(Data_Select);
        ResultSetMetaData metaData = Result.getMetaData();
        int columnCount = metaData.getColumnCount();
        Object[] Array_Tabel;

        // Iterate through the result set
        while (Result.next()) {
            // Create an array with the size of the number of columns in the result set
            Array_Tabel = new Object[columnCount];

            // Loop through each column and add its value to the array
            for (int i = 0; i < columnCount; i++) {
                // Retrieve the object and check if it is NULL
                Object value = Result.getObject(i + 1);  // ResultSet column indices start from 1

                // If the value is NULL
                Array_Tabel[i] = (value != null) ? value : "N/A";
            }

            // Add the row to the table model
            TableModels.addRow(Array_Tabel);
        }

    }
}
