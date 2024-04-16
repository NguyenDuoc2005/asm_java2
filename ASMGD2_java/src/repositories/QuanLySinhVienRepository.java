package repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Student;
import utils.DBConnect;
import views.QuanLySinhVien;

public class QuanLySinhVienRepository {

    public List<Student> listSt = new ArrayList<>();
    private Connection conn;

    public QuanLySinhVienRepository() {
        conn = DBConnect.getConnection();
    }
   

     public void getAll() { 
        try {
            String sql = "select masv,hoten,email,sodt,gioitinh,diachi,hinh from Student";
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs =  pr.executeQuery();
            while (rs.next()) {
                String ma, hoTen, email, SDT, diaChi, hinhAnh;
                boolean gioiTinh;
                ma = rs.getString(1);
                hoTen = rs.getString(2);
                email = rs.getString(3);
                SDT = rs.getString(4);
                if (rs.getInt(5) == 0) {
                    gioiTinh = true;
                } else {
                    gioiTinh = false;
                }
                diaChi = rs.getString(6);
                hinhAnh = rs.getString(7);
                Student st = new Student(ma, hoTen, email, SDT, gioiTinh, diaChi, hinhAnh);
                listSt.add(st);     
            }

        } catch (Exception e) {
        }
      
        
    }

    public void addStudent_(Student st) {
        try {
            String sql = "insert into Student values (?,?,?,?,?,?,?)\n" +
"	insert into Grade (masv) values (?)";
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setObject(1, st.getMaSV());
            pr.setObject(2, st.getHoTen());
            pr.setObject(3, st.getEmail());
            pr.setObject(4, st.getSdt());
            if (st.getGioiTinh()) {
                pr.setObject(5, 0);
            } else {
                pr.setObject(5, 1);
            }
            pr.setObject(6, st.getDiaChi());
            pr.setObject(7, st.getHinhAnh());
            pr.setObject(8, st.getMaSV());
            pr.executeUpdate();
        } catch (Exception ex) {

        }
    }
    public void deleteSV(String ma){
        try{
        conn = DBConnect.getConnection();
        String sql = "delete from Grade\n" +
"	where masv = ?\n" +
"	delete from Student\n" +
"	where masv = ?";
        PreparedStatement pr = conn.prepareStatement(sql);
        pr.setString(1, ma);
        pr.setString(2, ma);
        pr.executeUpdate();
        
        }catch(Exception e){
        }
    }
    
    public void updateSV(Student st,String ma){
        try{
         conn = DBConnect.getConnection(); 
         String sql = "update Student\n" +
"	set hoten=?,email=?,sodt =? , gioitinh=?, diachi=?,hinh=?, masv= ? \n" +
"	where masv = ?";
         PreparedStatement pr = conn.prepareStatement(sql);
         
         pr.setString(1,st.getHoTen());
         pr.setString(2,st.getEmail());
         pr.setString(3,st.getSdt());
         if(st.getGioiTinh()){
             pr.setInt(4, 0);
         }else pr.setInt(4, 1);
         pr.setString(5,st.getDiaChi());
         pr.setString(6,st.getHinhAnh()); 
         pr.setString(7,st.getMaSV());   
          // where
          pr.setString(8, ma);
         pr.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
    

}
