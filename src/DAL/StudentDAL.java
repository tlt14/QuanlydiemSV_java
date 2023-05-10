package DAL;

import ConnectionDB.Conn;
import DTO.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAL {
    private Connection conn=null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public ArrayList<Student>getAllStudent(){
        ArrayList<Student> result = new ArrayList<Student>();
        String sqlSelectAll = "select * from tblsinhvien";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student =new Student();
                student.setMaSV(resultSet.getInt(1));
                student.setHoten(resultSet.getString(2));
                student.setMaLop(resultSet.getString(3));
                student.setHedaotao(resultSet.getString(4));
                student.setNgaySinh(resultSet.getString(5));
                student.setDiaChi(resultSet.getString(6));
                student.setGioitinh(resultSet.getInt(7));
                student.setSDT(resultSet.getString(8));
                result.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Student>getWithMaLop(String Malop){
        ArrayList<Student> result = new ArrayList<Student>();
        String sqlSelectAll = "select * from tblsinhvien where MaLop=?";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,Malop);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student =new Student();
                student.setMaSV(resultSet.getInt(1));
                student.setHoten(resultSet.getString(2));
                student.setMaLop(resultSet.getString(3));
                student.setHedaotao(resultSet.getString(4));
                student.setNgaySinh(resultSet.getString(5));
                student.setDiaChi(resultSet.getString(6));
                student.setGioitinh(resultSet.getInt(7));
                student.setSDT(resultSet.getString(8));
                result.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Student>getWithMaSV(String Masv){
        ArrayList<Student> result = new ArrayList<Student>();
        String sqlSelectAll = "select * from tblsinhvien where MaSV=?";
        try {
            Connection conn= Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlSelectAll);
            preparedStatement.setString(1,Masv);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student =new Student();
                student.setMaSV(resultSet.getInt(1));
                student.setHoten(resultSet.getString(2));
                student.setMaLop(resultSet.getString(3));
                student.setHedaotao(resultSet.getString(4));
                student.setNgaySinh(resultSet.getString(5));
                student.setDiaChi(resultSet.getString(6));
                student.setGioitinh(resultSet.getInt(7));
                student.setSDT(resultSet.getString(8));
                result.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int insertStudent(Student student){
        int result = 0;
        String sqlInsert = "INSERT INTO `tblsinhvien` (`HoTen`, `MaLop`, `HeDaoTao`, `NgaySinh`, `DiaChi`, `GioiTinh`, `SDT`) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        try {
            Connection conn = Conn.getConnect();
            preparedStatement = conn.prepareStatement(sqlInsert);
            preparedStatement.setString(1, student.getHoten());
            preparedStatement.setString(2, student.getMaLop());
            preparedStatement.setString(3, student.getHedaotao());
            preparedStatement.setString(4,student.getNgaySinh());
            preparedStatement.setString(5,student.getDiaChi());
            preparedStatement.setBoolean(6,student.isGioitinh());
            preparedStatement.setString(7,student.getSDT());
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
    public int updateSt(Student student){
        int result = 0;
        String sqlUpdate = "update tblsinhvien set HoTen = ?, MaLop = ?, HeDaoTao = ?, Ngaysinh=?,DiaChi=?,GioiTinh=?,SDT=? where MaSV = ?";
        try {
            Connection connection = Conn.getConnect();
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, student.getHoten());
            preparedStatement.setString(2, student.getMaLop());
            preparedStatement.setString(3, student.getHedaotao());
            preparedStatement.setString(4, student.getNgaySinh());
            preparedStatement.setString(5, student.getDiaChi());
            preparedStatement.setBoolean(6, student.isGioitinh());
            preparedStatement.setString(7, student.getSDT());

            preparedStatement.setInt(8, student.getMaSV());
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
    public int deleteSt(Student student){
        int result = 0;
        String sqlDelete = "delete from tblsinhvien where MaSV = ?";

        try {
            Connection connection = Conn.getConnect();
            preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, student.getMaSV());
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

