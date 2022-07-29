package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
	public void addtransactionDetail() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletetransactionDetail() {
		// TODO Auto-generated method stub

	}

}
