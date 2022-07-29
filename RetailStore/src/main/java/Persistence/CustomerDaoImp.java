package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import Bean.Customer;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public void showCustomer() {
		try( Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root", "wiley");
				Statement statement=connection.createStatement();	) {

			ResultSet resultSet= statement.executeQuery("SELECT * FROM customer");
			
			while(resultSet.next()) {
				int customer_id=resultSet.getInt("customer_Id");
				String customer_name=resultSet.getString("customer_Name");
				String user_name=resultSet.getString("user_name");
				String password=resultSet.getString("passwords");
								
				System.out.println(customer_id +" "+customer_name+" "+user_name+" "+password);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchCustomer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
