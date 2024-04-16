package repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Grade;
import models.Student;
import utils.DBConnect;

public class QuanLyDiemRepository {

    public List<Grade> listD = new ArrayList<>();
    private Connection conn;

    public QuanLyDiemRepository() {
        conn = DBConnect.getConnection();
    }

    public void getAll() {
        try {
            listD.clear();
            conn = DBConnect.getConnection();
            String sql = "select g.id, g.masv,g.tienganh,g.tinhoc,g.gdtc,st.hoten ,(g.gdtc+g.tienganh+g.tinhoc) /3.0 as 'diemTB' from Grade g \n"
                    + "	inner join Student st on g.masv = st.masv ";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String masv, id, hoTen;
                int tiengAnh, tinHoc, GDTC;
                float diemTB;
                id = rs.getString(1);
                masv = rs.getString(2);
                tiengAnh = rs.getInt(3);
                tinHoc = rs.getInt(4);
                GDTC = rs.getInt(5);
                hoTen = rs.getString(6);
                diemTB = rs.getFloat(7);
                Grade gr = new Grade(id, masv, tiengAnh, tinHoc, GDTC, hoTen, diemTB);
                listD.add(gr);

            }

        } catch (Exception e) {
        }

    }

         public void AddGrade(Grade gr ){
             try {
                  conn = DBConnect.getConnection();
             String sql = "update Grade\n" +
"	set tienganh = ? , tinhoc = ? , gdtc = ? \n" +
"	where masv = ?";
             PreparedStatement pr = conn.prepareStatement(sql);
             pr.setInt(1, gr.getTiengAnh());
             pr.setInt(2, gr.getTinHoc());
             pr.setInt(3, gr.getGDTC());
             pr.setString(4,gr.getMaSV());
                   
             pr.executeUpdate();
             
             } catch (Exception e) {
             } 
         }
         
         public Grade search(String ma){
             try{
             conn = DBConnect.getConnection(); 
             String sql = "select g.id, g.masv,g.tienganh,g.tinhoc,g.gdtc,st.hoten ,(g.gdtc+g.tienganh+g.tinhoc) /3.0 as 'diemTB'from Grade  g\n" +
"	inner join Student st on g.masv = st.masv\n" +
"	where g.masv = ?";
             PreparedStatement pr = conn.prepareStatement(sql);
             ResultSet rs = pr.executeQuery(); 
             pr.setObject(1,ma);
             pr.executeUpdate(); 
             while(rs.next()){
                    String masv, id, hoTen;
                int tiengAnh, tinHoc, GDTC;
                float diemTB;
                id = rs.getString(1);
                masv = rs.getString(2);
                tiengAnh = rs.getInt(3);
                tinHoc = rs.getInt(4);
                GDTC = rs.getInt(5);
                hoTen = rs.getString(6);
                diemTB = rs.getFloat(7);
                Grade gr = new Grade(id, masv, tiengAnh, tinHoc, GDTC, hoTen, diemTB);
                return gr; 
             }
                
             }catch(Exception e){
                 
             }
               return null;       
             
         }
        public void deleteDiem(String ma){
             try {
                  conn = DBConnect.getConnection();
             String sql = "update Grade\n" +
"	set tienganh = null, tinhoc= null , gdtc = null\n" +
"	where masv = ? ";
             PreparedStatement pr = conn.prepareStatement(sql);
             
             pr.setString(1,ma);
                   
             pr.executeUpdate();
             
             } catch (Exception e) {
             } 
         }
        public void updateGrade(){
            try{ 
            conn = DBConnect.getConnection(); 
            String sql = "select top 3 g.id, g.masv,g.tienganh,g.tinhoc,g.gdtc,st.hoten ,(g.gdtc+g.tienganh+g.tinhoc) /3.0 as 'diemTB' from Grade g \n" +
"	inner join Student st on g.masv = st.masv\n" +
"	order by diemTB desc";
            PreparedStatement pr= conn.prepareStatement(sql);
            ResultSet rs= pr.executeQuery();
            listD.clear();
            while(rs.next()){
                 String masv, id, hoTen;
                int tiengAnh, tinHoc, GDTC;
                float diemTB;
                id = rs.getString(1);
                masv = rs.getString(2);
                tiengAnh = rs.getInt(3);
                tinHoc = rs.getInt(4);
                GDTC = rs.getInt(5);
                hoTen = rs.getString(6);
                diemTB = rs.getFloat(7);
                Grade gr = new Grade(id, masv, tiengAnh, tinHoc, GDTC, hoTen, diemTB);
                listD.add(gr);
            }
            
            }catch(Exception e){
                
            }
                    
        }
    
   
    
            
            
    
}
