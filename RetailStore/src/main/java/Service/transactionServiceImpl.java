package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Bill;
import Bean.Transaction;
import Bean.Transaction_Details;
import Persistence.TransactionDetailsDaoImpl;
import Persistence.transactionDaoImpl;

public class transactionServiceImpl implements transactionService {
	transactionDaoImpl td=new transactionDaoImpl();
	@Override
	public List<Bill> generatebill(int customer_id) {
		
		List<Transaction_Details> list = new ArrayList<Transaction_Details>();
		List<Bill> billlist = new ArrayList<Bill>();
		
		TransactionDetailsDaoImpl td=new TransactionDetailsDaoImpl();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM transaction where customer_Id=?");
				PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM allitems where customer_Id=?");
				PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM customer where customer_Id=?");) {

			preparedStatement.setInt(1,customer_id);
			preparedStatement1.setInt(1,customer_id);
			preparedStatement2.setInt(1,customer_id);


			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSet resultSet1 = preparedStatement.executeQuery();
			ResultSet resultSet2 = preparedStatement.executeQuery();
			
			String item_name=null;
			int price=0;
			if(resultSet1.next()) {
				item_name=resultSet1.getString("item_name");
				price=resultSet1.getInt("price");
			}
            String name=null;
            if(resultSet2.next()) {
				name=resultSet1.getString("customer_name");
			}
			if (resultSet.next()) {
				int transaction_id = resultSet.getInt("transaction_Id");
			    list=td.searchTransactionDetails(transaction_id);
			    
			    for(Transaction_Details tdd:list){
			    	
			    	int item_id=tdd.getItem_ID();
			    	int quantity=tdd.getQuantity();
			    	billlist.add(new Bill(customer_id,transaction_id,name,item_id,item_name,quantity,price));
			    }
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billlist;
		// TODO Auto-generated method stub

	}
	@Override
	public void showbill(int customer_id) {
		
	}
	@Override
	public void showalltransactions() {
		td.showalltransactions();
		
	}
	@Override
	public boolean addtransaction(Transaction transaction) {
		
		return td.addtransaction(transaction);
	}
	@Override
	public boolean deletetransaction(int id) {
		return td.deletetransaction(id);
	}
	@Override
	public Transaction_Details searchTransaction(int transid) {
		return td.searchTransaction(transid);
	}

	
	

}
