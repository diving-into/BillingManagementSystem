package com.FZZG.DAO;

import com.FZZG.Model.userinfo;
import com.FZZG.Utility.SQLHelper;

import java.sql.*;

public class userinfoDAO {
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;

    public static userinfo Login(String username){
        String SQLofLogin = "SELECT * FROM userinfo WHERE username = ?";
        userinfo user = null;
        try {
            connection = SQLHelper.getConnection();
            preparedStatement = connection.prepareStatement(SQLofLogin);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new userinfo(resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("ifAdmin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(connection, preparedStatement, resultSet);
        }
        return user;
    }

    public static void Register(userinfo user){

        try {
            connection = SQLHelper.getConnection();
            String SQLofRegister = "INSERT INTO userinfo VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(SQLofRegister);

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getIfAdmin());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
            SQLHelper.close(connection, preparedStatement, resultSet);
        }
    }
}
