package com.example.collegeadmission.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.collegeadmission.model.CollegeModel;
import com.example.collegeadmission.service.CollegeService;
import com.example.collegeadmission.service.impl.Database.Database;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Override
	public String savecollege(CollegeModel collmod) {
		try {
			Connection conn = Database.getConnection();

			if (conn != null) {
				String insertQuery = "INSERT INTO collegeservice (courseforadmission,counsellingdetails, dateofadmission, feestructure) VALUES ('" + collmod.getCourseforadmission() + "','" + collmod.getCounsellingdetails()
						+ "', '" + collmod.getDateofadmission() + "', '" + collmod.getFeesstructure() + "')";

				// String insertQuery="insert into collegeservice
				// values(7,'MCA','distinct','2023-12-07','newplan')";
				System.out.println(insertQuery);
				Statement createstatement = conn.createStatement();
				int row = createstatement.executeUpdate(insertQuery);
				if (row >= 1) {
					return "Data Inserted Succcessfully";
				} else {
					return "Internal server error";
				}
			} else

			{
				return "Internal server error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Internal server error";
	}

	@Override
	public String updatecollege(CollegeModel coll) {
		try {
			Connection con=Database.getConnection();
			if(con!=null)
			{
				String updateQuery = "UPDATE collegeservice " +
	                     "SET Admissionid = '" + coll.getAdmissionid() + "', " +
	                     "courseforadmission = '" + coll.getCourseforadmission() + "', " +
	                     "counsellingdetails = '" + coll.getCounsellingdetails() + "', " +
	                     "dateofadmission = '" + coll.getDateofadmission() + "', " +
	                     "feestructure = '" + coll.getFeesstructure() + "' " +
	                     "WHERE Admissionid = '" + coll.getAdmissionid() + "'";

//				String UpdateQuery="Update collegeservice"+
//						"SET Admissionid = '" + coll.getAdmissionid() + "', " +
//	                     "Courseforadmission = '" + coll.getCourseforadmission() + "', " +
//	                     "Counsellingdetails = '" + coll.getCounsellingdetails() + "', " +
//	                     "setDateodadmission = '" + coll.getDateodadmission()+ "', " +
//	                     "setFeesstruture='"+coll.getFeesstructure()+"', "+
//	                     "WHERE admissionid = '" + coll.getAdmissionid();
		System.out.println("updatequery:"+updateQuery);
				Statement createStatement=con.createStatement();
				int row=createStatement.executeUpdate(updateQuery);
				if(row>=1)
				{
					System.out.println("College details Updated Successfully");
				}
				else
				{
					System.out.println("Error in updating");
				}
			}
				else
				{
					System.out.println("Internal Error");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return e.getMessage();
			}
		return null;
		}

	@Override
	public List<CollegeModel> getuser() {
	List<CollegeModel>b=new ArrayList <CollegeModel>();
	try
	{
		Connection connection=Database.getConnection();
		if(connection!=null)
		{
			
			String SelectQuery= "select * from collegeservice order by admissionid desc";
			System.out.println("SelectQuery"+SelectQuery);
			Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SelectQuery);
            while(resultSet.next()) {
            	int admissionid = resultSet.getInt("admissionid");
            	String Courseforadmission=resultSet.getString("courseforadmission");
           	    String counsellingdetails=resultSet.getString("counsellingdetails");
           	    int Dateofadmission=resultSet.getInt("dateofadmission");
           	    String Feesstructure=resultSet.getString("feestructure");
           	    CollegeModel resp=new CollegeModel();
           	    resp.setAdmissionid(admissionid);
           	    resp.setCourseforadmission(Courseforadmission);
           	    resp.setCounsellingdetails(counsellingdetails);
           	    resp.setDateofadmission(Dateofadmission);
           	    resp.setFeesstructure(Feesstructure);
           	    b.add(resp);
           	    System.out.println("AdmissionId:"+admissionid+" ");
           	    System.out.println("Counsellingdetails:"+counsellingdetails+" ");
            }
            
		}
		else
		{
			System.out.println("Error in selecting");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return b;
	}

	@Override
	public String deleteuser(Integer Id) {
try 
{
	Connection conn=Database.getConnection();
	if(conn!=null)
	{
	String deleteQuery="Delete from collegeservice where admissionid="+Id;
	System.out.println("DeleteQuery"+deleteQuery);
	  PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
	  //Execute the Query
	  int rowsaffected=preparedStatement.executeUpdate();
	  if (rowsaffected > 0) {
          System.out.println("Records deleted successfully");
      } else {
          System.out.println("No records found for the given counsellingdetails");
      }
	}
	else
	{
		System.out.println("Error in connecting to the database");
	}
}
catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Error in executing DELETE query: " + e.getMessage());
}
	
		return null;
}

}
