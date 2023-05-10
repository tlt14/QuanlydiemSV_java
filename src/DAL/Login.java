package DAL;

import ConnectionDB.Conn;
import DTO.Loger;
import DTO.Student;
import GUI.MainPage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Login {
    private Connection conn=null;
    private PreparedStatement preparedStatement= null;
    private ResultSet resultSet = null;
    public boolean checkData(String inputUserName, char[] inputPassword) {
        String userName="";
        char []password=null;
        try {
            conn=Conn.getConnect();
            String sql="select * from tbldangnhap where TenDangNhap=? and Matkhau=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,inputUserName);
            preparedStatement.setString(2,String.copyValueOf(inputPassword));
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                userName=resultSet.getString(1);
                password=resultSet.getString(2).toCharArray();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return (Arrays.equals(inputPassword, password) && userName
                .equals(inputUserName));
    }
    public Loger getUserlogin(String inputUserName, char[] inputPassword){
        Loger result=new Loger();
        if(checkData(inputUserName,inputPassword)){
            try {
                conn=Conn.getConnect();
                String sql="select * from tbldangnhap where TenDangNhap=? and Matkhau=?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,inputUserName);
                preparedStatement.setString(2,String.copyValueOf(inputPassword));
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    result.setTenDN(resultSet.getString("TenDangNhap"));
                    result.setHoten(resultSet.getString("HoTen"));
                    result.setEmail(resultSet.getString("Email"));
                    result.setMatKhau(resultSet.getString("MatKhau"));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }
}
