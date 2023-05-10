package DAL;

import ConnectionDB.Conn;
import DTO.Monhoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonHocDAL {
    private Connection conn=null;
    private PreparedStatement preparedStatement= null;
    private ResultSet resultSet = null;
    public ArrayList<Monhoc> getAll(){
        ArrayList<Monhoc> result =new ArrayList<Monhoc>();
        String sql ="select * from tblMonhoc";
        try {
            conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Monhoc mh =new Monhoc();
                mh.setMaMH(resultSet.getInt(1));
                mh.setTenMH(resultSet.getString(2));
                mh.setSTC(resultSet.getInt(3));
                mh.setHinhThucThi(resultSet.getString(4));
                mh.setHocKy(resultSet.getInt(5));
                mh.setPhongHoc(resultSet.getString(6));
                result.add(mh);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public ArrayList<Monhoc> getWithMaSV(String Masv){
        ArrayList<Monhoc> result =new ArrayList<Monhoc>();
        String sql ="select * from tblMonhoc where MaMH=?";
        try {
            conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,Masv);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Monhoc mh =new Monhoc();
                mh.setMaMH(resultSet.getInt(1));
                mh.setTenMH(resultSet.getString(2));
                mh.setSTC(resultSet.getInt(3));
                mh.setHinhThucThi(resultSet.getString(4));
                mh.setHocKy(resultSet.getInt(5));
                mh.setPhongHoc(resultSet.getString(6));
                result.add(mh);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int InsertMH(Monhoc mh){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="insert into tblmonhoc (TenMH,STC,HinhThucThi,HocKy,PhongHoc) values (?,?,?,?,?)";
            preparedStatement =conn.prepareStatement(sql);
            preparedStatement.setString(1,mh.getTenMH());
            preparedStatement.setInt(2,mh.getSTC());
            preparedStatement.setString(3,mh.getHinhThucThi());
            preparedStatement.setInt(4,mh.getHocKy());
            preparedStatement.setString(5,mh.getPhongHoc());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int UpdateMH(Monhoc mh){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="update tblmonhoc set TenMH=?,STC=?,HinhThucThi=?,HocKy=?,PhongHoc=? where MaMH=? ";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,mh.getTenMH());
            preparedStatement.setInt(2,mh.getSTC());
            preparedStatement.setString(3,mh.getHinhThucThi());
            preparedStatement.setInt(4,mh.getHocKy());
            preparedStatement.setString(5,mh.getPhongHoc());
            preparedStatement.setInt(6,mh.getMaMH());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int Delete(Monhoc mh){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="delete from tblmonhoc where MaMH=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,mh.getMaMH());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
