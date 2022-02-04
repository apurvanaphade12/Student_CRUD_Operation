package CIUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CIUD_Test {
	
	
	public static void main(String[] args) {
		CIUD_Test objTest = new CIUD_Test();
	      objTest.create("1", "Apurva", "1999- 08-12", "2022-01-15");
		  objTest.create("2", "Purvi", "2001-01-24", "2022-01-05");
		  objTest.read("1");
		  objTest.update("3", "3", "Lakshmi", "1999-0s5-28","2022-02-01");
		  objTest.delete("3");
	}
	
	
	public void create(String student_no, String student_name, String student_dob, String student_doj) 
	{
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		
		PreparedStatement ps=null;
		try {
			
			String query="insert into student(student_no, student_name, student_dob, student_doj) values (?,?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, student_no);
			ps.setString(2, student_name);
			ps.setString(3, student_doj);
			ps.setString(4, student_doj);
			System.out.println(ps);
			ps.executeUpdate();
			
			}catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void read(String student_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		
		PreparedStatement ps=null;
		
		ResultSet rs=null;
		try {
			String query="select * from student where student_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, student_no);
			System.out.println(ps);
			rs=ps.executeQuery();
			while(rs.next()){
			System.out.println("stud no -"+rs.getString("student_no"));
			System.out.println("stud name -"+rs.getString("student_name"));
			System.out.println("stud dob -"+rs.getString("student_dob"));
			System.out.println("stud doj -"+rs.getString("student_doj"));
			System.out.println("---------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(String student_no,String new_student_no, String student_name, String student_dob, String student_doj){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="update student set student_no=?,student_name=?,student_dob=?,student_doj=? where student_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, student_no);
			ps.setString(2, student_name );
			ps.setString(3, student_dob );
			ps.setString(4, student_doj);
			ps.setString(5, student_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(String student_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="delete from student where student_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, student_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}



