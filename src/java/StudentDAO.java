import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ijhar-A
 */
public class StudentDAO 
{
    public static Connection getConnection() 
    {
    
    
             Connection con=null;  
             try {
                    Class.forName("com.mysql.jdbc.Driver");  
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ijhar","root","root"); 
                  }
             catch(ClassNotFoundException | SQLException  e)
             {
                 System.out.println(e);
             }  
               return con;
    
     }
   public static int save(Student s)
     {  
        int status=0;  
        try{  
            try (Connection con = StudentDAO.getConnection()) {
                String Query="insert into student(Name,Roll_No,Email,Class,Country,Address,Password) values (?,?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(Query);
                        
                ps.setString(1,s.getName());
                ps.setString(2,s.getRoll_No());
                ps.setString(3,s.getEmail());
                ps.setString(4,s.getClasss());
                ps.setString(5,s.getCountry());
                ps.setString(6,s.getAddress());
                ps.setString(7,s.getPassword());
                        
                
                status=ps.executeUpdate();
            }  
          }catch(SQLException ex){}  
          
           return status;  
    } 
 public static Student getStudent(String r)
 {
     Student e=new Student();  
          
        try{  
            try (Connection con = StudentDAO.getConnection()) {
                PreparedStatement ps=con.prepareStatement("select * from Student where Roll_No=?");
                ps.setString(1,r);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                   
                     e.setName(rs.getString(1));
                     e.setRoll_No(rs.getString(2));
                     e.setEmail(rs.getString(3));
                     e.setClasss(rs.getString(4));
                     e.setCountry(rs.getString(5));
                     e.setAddress(rs.getString(6));
                     e.setPassword(rs.getString(7));
                  }
            }  
        }catch(SQLException ex){}  
          
        return e;  
 }
      public static List<Student> getAllStudents(){  
        List<Student> list=new ArrayList<>();  
          
        try{  
            try (Connection con = StudentDAO.getConnection()) {
                PreparedStatement ps=con.prepareStatement("select * from Student");
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    Student e=new Student();
                    e.setName(rs.getString(1));
                     e.setRoll_No(rs.getString(2));
                     e.setEmail(rs.getString(3));
                     e.setClasss(rs.getString(4));
                     e.setCountry(rs.getString(5));
                     e.setAddress(rs.getString(6));
                     e.setPassword(rs.getString(7));
                   
                    
                    list.add(e);
                }
            }  
        }catch(SQLException e){}  
          
        return list;  
    }  
      public static int update(Student s){  
        String r=s.getRoll_No();
        int status=0;  
        try{  
            try (Connection con = StudentDAO.getConnection()) {
                PreparedStatement ps=con.prepareStatement(
                        "update Student set Name=?,Roll_No=?,Email=?,Class=?,Country=?,Address=?,Password=? where Roll_No="+r);
                ps.setString(1,s.getName());
                ps.setString(2,s.getRoll_No());
                ps.setString(3,s.getEmail());
                ps.setString(4,s.getClasss());
                ps.setString(5,s.getCountry());
                ps.setString(6,s.getAddress());
                ps.setString(7,s.getPassword());
                  
                
                status=ps.executeUpdate();
                    if(status!=0)
                {
                    System.out.println("<br>Property has been updated");

                }

                else
                {
                    System.out.println("Failed to update the data");
                }
            }  
        }catch(SQLException ex){}  
          
        return status;  
    } 
}