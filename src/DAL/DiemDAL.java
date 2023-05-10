package DAL;

import ConnectionDB.Conn;
import DTO.Diem;
import DTO.GiangVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiemDAL {
    private Connection conn=null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public ArrayList<Diem> getAll(){
        ArrayList<Diem> result = new ArrayList<Diem>();
        String sqlSelectAll = "select * from tbldiem,tblsinhvien where tbldiem.MaSV=tblsinhvien.MaSV";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Diem d =new Diem();
                d.setMaSV(resultSet.getInt(1));
                d.setMaMH(resultSet.getInt(2));
                d.setLanThi(resultSet.getInt(3));
                d.setHeso(resultSet.getInt("HeSo"));
                d.setDiem(resultSet.getInt("Diem"));
                d.setTrangThai(resultSet.getInt("TrangThai"));
                d.setTenSV(resultSet.getString("HoTen"));
                result.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Diem> Thapdencao(){
        ArrayList<Diem> result = new ArrayList<Diem>();
        String sqlSelectAll = "select * from tbldiem,tblsinhvien where tbldiem.MaSV=tblsinhvien.MaSV ORDER BY Diem";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Diem d =new Diem();
                d.setMaSV(resultSet.getInt(1));
                d.setMaMH(resultSet.getInt(2));
                d.setLanThi(resultSet.getInt(3));
                d.setHeso(resultSet.getInt("HeSo"));
                d.setDiem(resultSet.getInt("Diem"));
                d.setTrangThai(resultSet.getInt("TrangThai"));
                d.setTenSV(resultSet.getString("HoTen"));
                result.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Diem> ExportMark(String s){
        ArrayList<Diem> result = new ArrayList<Diem>();
        String sqlSelectAll = "select * from tbldiem,tblsinhvien where tbldiem.MaSV=tblsinhvien.MaSV and tblsinhvien.MaLop=? ORDER BY tblsinhvien.HoTen";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,s);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Diem d =new Diem();
                d.setMaSV(resultSet.getInt("MaSV"));
                d.setMaMH(resultSet.getInt("MaMH"));
                d.setLanThi(resultSet.getInt("LanThi"));
                d.setHeso(resultSet.getInt("HeSo"));
                d.setDiem(resultSet.getInt("Diem"));
                d.setTrangThai(resultSet.getInt("TrangThai"));
                d.setTenSV(resultSet.getString("HoTen"));
                result.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Diem> Caodenthap(){
        ArrayList<Diem> result = new ArrayList<Diem>();
        String sqlSelectAll = "select * from tbldiem,tblsinhvien where tbldiem.MaSV=tblsinhvien.MaSV ORDER BY Diem DESC";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Diem d =new Diem();
                d.setMaSV(resultSet.getInt(1));
                d.setMaMH(resultSet.getInt(2));
                d.setLanThi(resultSet.getInt(3));
                d.setHeso(resultSet.getInt("HeSo"));
                d.setDiem(resultSet.getInt("Diem"));
                d.setTrangThai(resultSet.getInt("TrangThai"));
                d.setTenSV(resultSet.getString("HoTen"));
                result.add(d);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int insert(Diem d){
        int result = 0;
        String sqlInsert = "INSERT INTO `tbldiem` (`MaSV`, `MaMH`, `LanThi`, `HeSo`, `Diem`,`TrangThai`) VALUES ( ?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, d.getMaSV());
            preparedStatement.setInt(2, d.getMaMH());
            preparedStatement.setInt(3, d.getLanThi());
            preparedStatement.setInt(4,d.getHeso());
            preparedStatement.setFloat(5,d.getDiem());
            preparedStatement.setBoolean(6,d.isTrangThai());
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
    public int update(Diem d){
        int result = 0;
        String sqlUpdate = "update tbldiem set HeSo = ?, Diem = ?, TrangThai = ? where MaSV = ? and MaMH=?";
        try {
            Connection connection = Conn.getConnect();
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, d.getHeso());
            preparedStatement.setFloat(2, d.getDiem());
            preparedStatement.setBoolean(3, d.isTrangThai());
            preparedStatement.setInt(4, d.getMaSV());
            preparedStatement.setInt(5,d.getMaMH());
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
    public int delete(Diem gv){
        int result = 0;
        String sqlDelete = "delete from tbldiem where MaSV = ? and MaMH=? and LanThi=?";

        try {
            Connection connection = Conn.getConnect();
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, gv.getMaSV());
            preparedStatement.setInt(2, gv.getMaMH());
            preparedStatement.setInt(3, gv.getLanThi());
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

