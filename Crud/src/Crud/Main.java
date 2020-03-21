package Crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int n=0;
		Scanner s=new Scanner(System.in);
		while(n!=6)
		{
			System.out.println("Enter your choice\n**********************************************\n1.Create connection\n2.Insert data\n3.Retrive data\n4.delete required value\n5.delete whole tabel\n6.exit\n**************************************\n");
			n=s.nextInt();
			switch(n)
			{
			case 1:getConnection();
			break;
			case 2:insert();
			break;
			case 3:retrive();
			break;
			case 4:delete();
			break;
			case 5:deletew();
			break;
			}
			
		}
	}
	public static Connection getConnection() throws Exception
	{
		try
		{
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/prog";
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,"shashan","shashan");
			System.out.println("Connection established");
			return conn;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public static  void insert() throws Exception
	{
		String a,b,c;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter details");
		 a=sc.next();
		 b=sc.next();
		 c=sc.next();
		try
		{
			
			Connection conn=getConnection();
			PreparedStatement pr=conn.prepareStatement("INSERT INTO detail VALUES('"+a+"','"+b+"','"+c+"')");
			pr.executeUpdate();
			System.out.println("insertion is success");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void retrive() throws Exception
	{
		try
		{
			
		
		Connection conn=getConnection();
		PreparedStatement p=conn.prepareStatement("select * from prog.detail");
		ResultSet r=p.executeQuery();
		
		
			System.out.println("\nfirst name\tmiddle name\tlast name");	
		
		while(r.next())
		{
			String a,b,c;
			a=r.getString(1);
			b=r.getString(2);
			c=r.getString(3);
			
			
			System.out.println(a+"\t\t"+b+"\t\t"+c);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	
	}
	public static void delete() throws Exception
	{
		Scanner sn=new Scanner(System.in);
		System.out.println("Just see the table and decide which value should be deleted");
		String s=sn.next();
		try
		{
			Connection conn=getConnection();
			PreparedStatement p=conn.prepareStatement("DELETE FROM detail where(second=?)");
			p.setString(1,s);
			p.executeUpdate();
				
			System.out.println("data is deleted");
		}
		catch(Exception e)
		{

			System.out.println(e);
		}
	}
	public static void deletew() throws Exception
	{
		try
		{
			Connection conn=getConnection();
			PreparedStatement p=conn.prepareStatement("delete from detail");
			p.executeUpdate();
			System.out.println("whole table is deleted");
			
		}catch(Exception e)
		{
			
		}
	}
		
	

}
