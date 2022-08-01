package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Transaction_Details;


public class TransactionDetailsDaoImpl implements TransactionDetailsDao {

	@Override
	public void showalltransactionDetails() {            
		try( Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root", "wiley");
				Statement statement=connection.createStatement();	) {

			ResultSet resultSet= statement.executeQuery("SELECT * FROM transaction_details");
			
			while(resultSet.next()) {
				int Transaction_id=resultSet.getInt("transaction_id");
				int Item_Id=resultSet.getInt("item_Id");
				int quantity=resultSet.getInt("quantity");
	
				System.out.println(Transaction_id+" "+Item_Id+" "+quantity);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}


	@Override
	public void deletetransactionDetail() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addtransactionDetail(Transaction_Details trans_details) {
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO transaction_details values(?,?,?)");) {

			preparedStatement.setInt(1, trans_details.getTransaction_ID());
			preparedStatement.setInt(2, trans_details.getItem_ID());
			preparedStatement.setInt(3, trans_details.getQuantity());			

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
	public List<Transaction_Details> searchTransactionDetails(int transid) {
		List<Transaction_Details> list = new ArrayList<Transaction_Details>();
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM transaction_details where transaction_Id=?");) {

			preparedStatement.setInt(1,transid);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id1 = resultSet.getInt("transaction_Id");
				int id2 = resultSet.getInt("Item_Id");
				int quantity = resultSet.getInt("quantity");
				
				list.add(new Transaction_Details(id1,id2,quantity) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
