package repositories;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Users;
import utils.DBConnect;
public class LoginRepository {
        private Connection conn; 
        public ArrayList<Users> listUS = new ArrayList<>();
         public LoginRepository(){
            this.conn = DBConnect.getConnection();  
        }
       
       public void Login(){
            try{
            String sql = "select username,password,role from Users";
            Statement st = conn.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                String userName, passWord; 
                Boolean role ;
                userName = rs.getString("username");
                passWord = rs.getString("password");
                if(rs.getString("role").equals("user")){
                    role = true ;      
                }else role = false; 
                Users us = new Users(userName, passWord,role);
                
                listUS.add(us);
                
            }
            
            
            }catch(Exception e){
              
            }
            
        }
        
        
        
}
