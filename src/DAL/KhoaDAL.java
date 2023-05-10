package DAL;

import ConnectionDB.Conn;
import DTO.Khoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KhoaDAL {
    private Connection conn=null;
    private PreparedStatement preparedStatement= null;
    private ResultSet resultSet = null;
    public ArrayList<Khoa>getAll(){
        ArrayList<Khoa> result =new ArrayList<Khoa>();
        String sql ="select * from tblkhoa";
        try {
            conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Khoa cat =new Khoa();
                cat.setMaKhoa(resultSet.getString("MaKhoa"));
                cat.setTenKhoa(resultSet.getString("TenKhoa"));
                cat.setSDT(resultSet.getString("SDT"));
                result.add(cat);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int InsertCat(Khoa cat){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="insert into tblkhoa (MaKhoa,TenKhoa,SDT) values (?,?,?)";
            preparedStatement =conn.prepareStatement(sql);
            preparedStatement.setString(1,cat.getMaKhoa());
            preparedStatement.setString(2,cat.getTenKhoa());
            preparedStatement.setString(3, cat.getSDT());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int UpdateCat(Khoa cat){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="update tblkhoa set TenKhoa=?,SDT=? where MaKhoa=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(3,cat.getMaKhoa());
            preparedStatement.setString(1,cat.getTenKhoa());
            preparedStatement.setString(2, cat.getSDT());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int Delete(Khoa cat){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="delete from tblKhoa where MaKhoa=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,cat.getMaKhoa());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
