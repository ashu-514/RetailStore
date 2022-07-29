package Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bean.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class transactionDaoImpl implements TransactionDao {

	@Override
	public void showalltransactions() {
		try( Connection connection=DriverManager.
				getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root", "wiley");
				Statement statement=connection.createStatement();	) {

			ResultSet resultSet= statement.executeQuery("SELECT * FROM Transaction");
			
			while(resultSet.next()) {
				int Transaction_ID=resultSet.getInt("Transaction_Id");
				int Customer_ID=resultSet.getInt("Customer_ID");

				
				System.out.println(Transaction_ID+" "+Customer_ID);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean addtransaction(Transaction transaction) {
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO Transaction values(?,?)");) {

			preparedStatement.setInt(1, transaction.getTransaction_ID());
			preparedStatement.setInt(2, transaction.getCustomer_ID());
			
			

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows>0)
		   return true;
		else
			return false;

	}

	@Override
	public void deletetransaction() {
		// TODO Auto-generated method stub

	}

}
