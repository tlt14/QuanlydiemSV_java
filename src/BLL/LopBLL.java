package BLL;

import DAL.LopDAL;
import DTO.Lop;

import java.util.ArrayList;

public class LopBLL {
    LopDAL lopDAL=new LopDAL();
    public ArrayList<Lop>getAll(){
        return lopDAL.getAll();
    }
    public int Insert(Lop lop){
        return lopDAL.Insert(lop);
    }
    public int Update(Lop lop){
        return lopDAL.Update(lop);
    }
    public int Delete(Lop lop){
        return lopDAL.Delete(lop);
    }
}
