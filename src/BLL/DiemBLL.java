package BLL;

import DAL.DiemDAL;
import DTO.Diem;

import java.util.ArrayList;

public class DiemBLL {
    DiemDAL diemDAL=new DiemDAL();
    public ArrayList<Diem>getAll(){
        return diemDAL.getAll();
    }
    public ArrayList<Diem>exportMark(String s){
        return diemDAL.ExportMark(s);
    }
    public ArrayList<Diem>Thapdencao(){
        return diemDAL.Thapdencao();
    }
    public ArrayList<Diem>Caodenthap(){
        return diemDAL.Caodenthap();
    }
    public int Insert(Diem d){
        return diemDAL.insert(d);
    }
    public int Update(Diem cat){
        return diemDAL.update(cat);
    }
    public int Delete(Diem cat){
        return diemDAL.delete(cat);
    }

}
