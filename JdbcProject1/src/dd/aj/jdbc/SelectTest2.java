package dd.aj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=null;
		String desg1=null;
		String desg2=null;
		String desg3=null;
		String cond=null;
		String query=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs =null;
		boolean flag=false;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter desg1");
				desg1=sc.next().toUpperCase();
				System.out.println("enter desg2");
			desg2=sc.next().toUpperCase();
				System.out.println("enter desg3");
						
						
				
				desg3=sc.next().toUpperCase();
			}
			cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			System.out.println(cond);
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr1");
		if(con!=null)
			st=con.createStatement();
		query="SELECT SNO,SAL,JOB FROM EMP WHERE JOB= "+"'"+desg1+"'"+"ORDER BY JOB DESC";
		System.out.println(query);
		if(st!=null) 
			rs=st.executeQuery(query);
			if(rs!=null) {
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt("SNO")+" "
				+" "+rs.getFloat("SAL")+" "+rs.getString("JOB"));
					if(flag)
					System.out.println("records displayed");
					else
						System.out.println("no records found");
					
					
				}
			}
		}
			
			catch(SQLException se) {
				
				se.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			finally {
				try {
					if(rs!=null)
						rs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			try {
				
			if(st!=null)
			
				st.close();
		
			}
			
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
			se.printStackTrace();
		}
		
		try {
					if(sc!=null)
						sc.close();
				}
		   catch(Exception e) {
			e.printStackTrace();
		}
			}
		
	}
}


		

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

