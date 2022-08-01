package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Bean.Cart;
import Bean.Transaction;
import Bean.Transaction_Details;
import Persistence.TransactionDetailsDaoImpl;
import Persistence.transactionDaoImpl;

public class transactionDetailsServiceImpl implements transactionDetailsService {

	TransactionDetailsDaoImpl td=new TransactionDetailsDaoImpl();
	
     @Override
	public boolean addToCart(Cart cart) {
		Transaction_Details transaction=null;
		
		int custid = cart.getCustomer_id();
		int item_id= cart.getItem_Id();
		int quantity = cart.getQuantity();
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM transaction where customer_Id=?");) {

			preparedStatement.setInt(1,custid);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int transaction_id = resultSet.getInt("transaction_Id");
				transaction=new Transaction_Details(transaction_id,item_id,quantity);
				td.addtransactionDetail(transaction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}

	@Override
	public void showalltransactionDetails() {
		td.showalltransactionDetails();
		
	}

	@Override
	public boolean addtransactionDetail(Transaction_Details trans_details) {
		return td.addtransactionDetail(trans_details);
	}

	@Override
	public boolean deletetransactionDetail(int id) {
		return td.deletetransactionDetail(id);
	}

	@Override
	public List<Transaction_Details> searchTransactionDetails(int transid) {
		return td.searchTransactionDetails(transid);
	}

	
}
