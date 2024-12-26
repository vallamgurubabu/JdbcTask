package com.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HospitalPatientManagement {
	
	//	creating connection method
	public static Connection createConnection()throws ClassNotFoundException, SQLException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db","root","root");
	}
	
	// insert patient details into Database
	public void add(int patientid, String name, int age, String gender, String condition) throws ClassNotFoundException, SQLException {
          Connection con = createConnection();
          String query = "INSERT INTO patients (patientid,name,age,gender,conditions) values(?,?,?,?,?)";
          PreparedStatement pstmt = con.prepareStatement(query);
          pstmt.setInt(1,patientid);
          pstmt.setString(2,name);
          pstmt.setInt(3,age);
          pstmt.setString(4,gender);
          pstmt.setString(5,condition);
          pstmt.executeUpdate();
          System.out.println("Patients data added successfully");
          pstmt.close();
          con.close();
	}
	// update patient name and condition by asking the patients id
	public void updateConditions(int id,String condition) throws ClassNotFoundException, SQLException{
		Connection con = createConnection();
		String query = "UPDATE patients SET Conditions = ? where patientid = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setInt(2,id);
		pstmt.setString(1, condition);
		pstmt.executeUpdate();
		System.out.println("Updated Patient's"+condition+" of a patient's_id"+id+" Successfully");
		pstmt.close();
		con.close();
	}
	
	//remove data based on id 
		public void deleteById(int id)throws ClassNotFoundException, SQLException {
			Connection con = createConnection();
			String query = "DELETE FROM patients WHERE patientid = ? ";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("REMOVED Patient's data based on Patient's id: "+id+" Successfully");
			pstmt.close();
			con.close();
		}

	// remove data based on condition
	public void deleteByCondition(String condition)throws ClassNotFoundException, SQLException {
		Connection con = createConnection();
		String query = "DELETE FROM patients WHERE Conditions = ? ";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, condition);
		pstmt.executeUpdate();
		System.out.println("REMOVED Patient's data based on condition"+condition+" Successfully");
		pstmt.close();
		con.close();
	}
	
	// display all patient details
		public void display()throws ClassNotFoundException, SQLException {
			 Connection con = createConnection();
			 String query ="SELECT * FROM patients";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 System.out.println("Patientid,  Name,  Age,  Gender,  Condition");
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(4)+", "+rs.getString(5));
			 }
			 stmt.close();
			 con.close();	 
		}
	// display only those patient details whose age < 30 years
	public void displayDetailsByAgeLess30Years() throws ClassNotFoundException, SQLException{
		 Connection con = createConnection();
		 String query ="SELECT * FROM patients where age<30";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 System.out.println("Patientid,  Name,  Age,  Gender,  Condition");
		 while(rs.next()) {
			 System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(4)+", "+rs.getString(5));
		 }
		 stmt.close();
		 con.close();	

	}
}
