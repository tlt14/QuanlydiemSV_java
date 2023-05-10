package BLL;

import DAL.KhoaDAL;
import DTO.Khoa;

import java.util.ArrayList;

public class KhoaBLL {
    KhoaDAL catDAL=new KhoaDAL();
    public ArrayList<Khoa>getAllCat(){
        return catDAL.getAll();
    }
    public int InsertCat(Khoa cat){
        return catDAL.InsertCat(cat);
    }
    public int UpdateCat(Khoa cat){
        return catDAL.UpdateCat(cat);
    }
    public int DeleteCat(Khoa cat){
        return catDAL.Delete(cat);
    }
}
