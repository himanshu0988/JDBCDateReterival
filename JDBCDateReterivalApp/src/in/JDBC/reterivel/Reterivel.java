package in.JDBC.reterivel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.JDBC.util.jdbcUtil;

public class Reterivel {

	public static void main(String[] args) {
		
		Connection connection=null;
		PreparedStatement pstm=null;
		ResultSet resultset=null;
		String username="hks";
		
		try {
			connection=jdbcUtil.getConnection();
			if(connection!=null)
			{
				String Query="Select username ,dob from user where username=?";
				pstm=connection.prepareStatement(Query);
			}
			if(pstm!=null)
			{
				pstm.setString(1,username);
				
				resultset=pstm.executeQuery();
			}
			if(resultset!=null)
			{
				if(resultset.next())
				{
					System.out.println("dob");
					System.out.println();
					java.sql.Date strDate=resultset.getDate(2);
				
					 SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy");
					 String date=sm.format(strDate);
					 String username1=resultset.getString(1);
					 System.out.println(date);
					
				}else
				{
					System.out.println(" detail not avilabe");
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try {
				jdbcUtil.clenUp(connection, pstm, resultset);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
