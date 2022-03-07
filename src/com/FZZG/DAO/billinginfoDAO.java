package com.FZZG.DAO;

import com.FZZG.Model.billinginfo;
import com.FZZG.Utility.SQLHelper;
import com.mysql.cj.protocol.x.ReusableOutputStream;

import java.sql.*;

public class billinginfoDAO {
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;

    public static void addBillinginfo(billinginfo billing) {
        String sql = "insert into billinginfo values(?, ?, ?, ?)";
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, billing.getItem());
            preparedStatement.setDate(2, billing.getTime());
            preparedStatement.setFloat(3, billing.getPrices());
            preparedStatement.setString(4, billing.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ResultSet searhcBillinginfo() {
        String sql = "select category from billinginfo";
        ResultSet rs = null;
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet searchBillinginfo(String item) {
        String sql = "select * from billinginfo where item = ?";
        ResultSet rs = null;
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, item);
            rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet searchBillinginfoByCategory(String category) {
        String sql = "select * from billinginfo where category = ?";
        ResultSet rs = null;
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category);
            rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static int updateBillinginfo(billinginfo newInfo, String oldItem) {
        String sql = "update billinginfo set item = ? , time = ?, prices = ? , category = ? where  item = ?";
        int result = 0;
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newInfo.getItem());
            preparedStatement.setDate(2, newInfo.getTime());
            preparedStatement.setFloat(3,newInfo.getPrices());
            preparedStatement.setString(4, newInfo.getCategory());
            preparedStatement.setString(5, oldItem);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
