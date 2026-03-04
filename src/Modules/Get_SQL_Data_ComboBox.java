/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

/**
 *
 * @author Omar
 */
public class Get_SQL_Data_ComboBox {
    public Get_SQL_Data_ComboBox(String SQL_Count_Query,String SQL_select_Query,String SQL_Column_Name,JComboBox<String> ComboBox_Name) throws SQLException{
        //Connection and Variables
        String Data_arr [];
        Connection c = Connection_fun.con();
        Statement s =c.createStatement();
        ResultSet rs;
        //Get The count
        rs = s.executeQuery(SQL_Count_Query);
        rs.next();
        int var_count =rs.getInt(1);
        Data_arr = new String[var_count];
        //Get the data
        rs = s.executeQuery(SQL_select_Query);
        int index=0;
        while(rs.next()){
            Data_arr[index] =rs.getString(SQL_Column_Name);
            index++;
            }
        ComboBox_Name.setModel(new javax.swing.DefaultComboBoxModel(Data_arr));
    }
}


