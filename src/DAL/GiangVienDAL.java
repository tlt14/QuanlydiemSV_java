package DAL;

import ConnectionDB.Conn;
import DTO.GiangVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GiangVienDAL {
    private Connection conn=null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public ArrayList<GiangVien> getAllGV(){
        ArrayList<GiangVien> result = new ArrayList<GiangVien>();
        String sqlSelectAll = "select * from tblgiangvien";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                GiangVien gv =new GiangVien();
                gv.setMaGV(resultSet.getInt(1));
                gv.setHoten(resultSet.getString(2));
                gv.setMonGiangDay(resultSet.getInt(3));
                gv.setEmail(resultSet.getString(6));
                gv.setNgaySinh(resultSet.getString(4));
                gv.setDiaChi(resultSet.getString(7));
                gv.setGioitinh(resultSet.getInt(5));
                gv.setSDT(resultSet.getString(8));
                result.add(gv);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int insertStudent(GiangVien gv){
        int result = 0;
        String sqlInsert = "INSERT INTO `tblgiangvien` (`TenGV`, `MaMH`, `NgaySinh`, `GioiTinh`, `Email`,`DiaChi`, `SDT`) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setString(1, gv.getHoten());
            preparedStatement.setString(5, gv.getEmail());
            preparedStatement.setInt(2, gv.getMonGiangDay());
            preparedStatement.setString(3,gv.getNgaySinh());
            preparedStatement.setString(6,gv.getDiaChi());
            preparedStatement.setBoolean(4,gv.isGioitinh());
            preparedStatement.setString(7,gv.getSDT());
            result = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public int update(GiangVien gv){
        int result = 0;
        String sqlUpdate = "update tblgiangvien set TenGV = ?, Email = ?, MaMH = ?, Ngaysinh=?,DiaChi=?,GioiTinh=?,SDT=? where MaGV = ?";
        try {
            Connection connection = Conn.getConnect();
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, gv.getHoten());
            preparedStatement.setString(2, gv.getEmail());
            preparedStatement.setInt(3, gv.getMonGiangDay());
            preparedStatement.setString(4, gv.getNgaySinh());
            preparedStatement.setString(5, gv.getDiaChi());
            preparedStatement.setBoolean(6, gv.isGioitinh());
            preparedStatement.setString(7, gv.getSDT());

            preparedStatement.setInt(8, gv.getMaGV());
            result = preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public int delete(GiangVien gv){
        int result = 0;
        String sqlDelete = "delete from tblgiangvien where MaGV = ?";

        try {
            Connection connection = Conn.getConnect();
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, gv.getMaGV());
            result = preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

