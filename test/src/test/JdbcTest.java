package test;

import java.sql.*;

public class JdbcTest {
   // JDBC �����������ƺ����ݿ��ַ
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";


   static final String USER = "root";
   static final String PASS = "";

   public static void main(String[] args) {
       Connection conn = null;
       PreparedStatement stmt = null;
       try{
           //ע�� JDBC ������
           Class.forName("com.mysql.jdbc.Driver");

           //������
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //ִ�в�ѯ
           System.out.println("Creating statement...");
           //��������Ҫ����һ��ͬѧ�����䣬��������
           String sql = "UPDATE Students set age=? WHERE id=?";
           stmt = conn.prepareStatement(sql);

           //��ֵ�󶨵����������������������Ϊ1��2...
           stmt.setInt(1, 22);  // �� age ��ֵ(���Ϊ1)
           stmt.setInt(2, 1); // �� ID ��ֵ

           // ���� ID Ϊ1��ͬѧ������
           int rows = stmt.executeUpdate();
           System.out.println("��Ӱ������� : " + rows );
           
           String sql1 = "select * from user where id=?";
           stmt = conn.prepareStatement(sql1);
           stmt.setInt(1,1);
           ResultSet rs1 = stmt.executeQuery();

           // ��ѯ���м�¼������ʾ.
           sql = "SELECT id, name, age FROM Students";
           ResultSet rs = stmt.executeQuery(sql);

           //��������
           while(rs.next()){
               //����
               int id  = rs.getInt("id");
               int age = rs.getInt("age");
               String name = rs.getString("name");


               //��ʾ
               System.out.print("ID: " + id);
               System.out.print(", Age: " + age);
               System.out.print(", Name: " + name);
               System.out.println();
           }
           //����
           rs.close();
           stmt.close();
           conn.close();
       }catch(SQLException se){
           se.printStackTrace();
       }catch(Exception e){
           e.printStackTrace();
       }finally{
           try{
               if(stmt!=null)
                   stmt.close();
           }catch(SQLException se2){
           }
    try{
         if(conn!=null)
                 conn.close();
      }catch(SQLException se){
              se.printStackTrace();
          }
       }
           System.out.println("Goodbye!");
   }
}
