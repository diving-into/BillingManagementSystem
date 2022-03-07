package com.FZZG.DAO;

import com.FZZG.Model.categoryinfo;
import com.FZZG.Utility.SQLHelper;
import jdk.jfr.Category;

import java.sql.*;

public class categoryDAO {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static int addCategory(categoryinfo category) {
        String sql = "insert into categoryinfo values(?)";
        int result = 0;
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategory());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  result;
    }
    public static int updateCategory(categoryinfo oldCategory, categoryinfo newCategory ) {
        String sql = "update categoryinfo  set category = ? where category = ?";
        int result = 0;
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newCategory.getCategory());
            preparedStatement.setString(2, oldCategory.getCategory());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static ResultSet searchCategory() {
        try {
            connection = SQLHelper.getConnection();
            String SQLofSelect = "SELECT * FROM categoryinfo";

            preparedStatement = connection.prepareStatement(SQLofSelect);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return resultSet;
    }
    public static ResultSet searchCategory(String category) {
        try {
            connection = SQLHelper.getConnection();
            String SQLofSelect = "SELECT * FROM categoryinfo where category = ?";

            preparedStatement = connection.prepareStatement(SQLofSelect);
            preparedStatement.setString(1, category);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
