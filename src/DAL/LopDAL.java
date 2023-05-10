package DAL;

import ConnectionDB.Conn;
import DTO.Khoa;
import DTO.Lop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LopDAL {
    private Connection conn=null;
    private PreparedStatement preparedStatement= null;
    private ResultSet resultSet = null;
    public ArrayList<Lop> getAll(){
        ArrayList<Lop> result =new ArrayList<Lop>();
        String sql ="select * from tbllop";
        try {
            conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Lop lop =new Lop();
                lop.setMaLop(resultSet.getString("MaLop"));
                lop.setTenLop(resultSet.getString("TenLop"));
                lop.setMaKhoa(resultSet.getString("MaKhoa"));
                lop.setKhoaHoc(resultSet.getString("KhoaHoc"));
                result.add(lop);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int Insert(Lop lop){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="insert into tbllop (MaLop,TenLop,MaKhoa,KhoaHoc) values (?,?,?,?)";
            preparedStatement =conn.prepareStatement(sql);
            preparedStatement.setString(1,lop.getMaLop());
            preparedStatement.setString(2,lop.getTenLop());
            preparedStatement.setString(3, lop.getMaKhoa());
            preparedStatement.setString(4,lop.getKhoaHoc());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int Update(Lop lop){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="update tbllop set TenLop=?,MaKhoa=?,KhoaHoc=? where MaLop=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(4,lop.getMaLop());
            preparedStatement.setString(1,lop.getTenLop());
            preparedStatement.setString(2, lop.getMaKhoa());
            preparedStatement.setString(3, lop.getKhoaHoc());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
    public int Delete(Lop lop){
        int result=0;
        try {
            conn=Conn.getConnect();
            String sql="delete from tbllop where MaLop=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,lop.getMaLop());
            result=preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
