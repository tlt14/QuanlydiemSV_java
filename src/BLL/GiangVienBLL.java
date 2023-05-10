package BLL;



import DAL.GiangVienDAL;
import DTO.GiangVien;

import java.util.ArrayList;

public class GiangVienBLL {
    GiangVienDAL gvDAL =new GiangVienDAL();
    public ArrayList<GiangVien>getAll(){
        return gvDAL.getAllGV();
    }
    public int Insert(GiangVien us){
        int result = gvDAL.insertStudent(us);
        return result;
    }
    public int Update(GiangVien us){
        int result = gvDAL.update(us);
        return result;
    }
    public int Delete(GiangVien us){
        int result = gvDAL.delete(us);
        return result;
    }
}
