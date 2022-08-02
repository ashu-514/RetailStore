package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Bill;
import Bean.Transaction_Details;
import Persistence.TransactionDetailsDaoImpl;

public class generate_billServiceImpl implements generate_billService {

	@Override
	public void generate_bill(int customer_id) {
					
				final double Cd_tax=0.1,Cosmetics_tax=0.12;
				double grand_total=0;
				
				int transaction_id=0,item_id=0,quantity=0;
				Double price=0.0;
				
			TransactionDetailsDaoImpl td=new TransactionDetailsDaoImpl();
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
					"wiley");
					PreparedStatement preparedStatementfortransaction = connection.prepareStatement("SELECT * FROM transaction where customer_Id=?");
					PreparedStatement preparedStatementforTransdetails = connection.prepareStatement("SELECT * FROM transaction_detail where transaction_Id=?");
					PreparedStatement preparedStatement2allitems = connection.prepareStatement("SELECT * FROM allItems where item_Id=?");){
				
				preparedStatementfortransaction.setInt(1,customer_id);
					ResultSet resultSetfortransactions = preparedStatementfortransaction.executeQuery();
					if (resultSetfortransactions.next()) {
						transaction_id = resultSetfortransactions.getInt("transaction_Id");
					}
					
					preparedStatementforTransdetails.setInt(1,transaction_id);
					ResultSet resultSetforTransDetais = preparedStatementfortransaction.executeQuery();
					List<Transaction_Details> list =new ArrayList<Transaction_Details>();
					if(resultSetforTransDetais.next()) {
		                  item_id=resultSetforTransDetais.getInt("item_Id");
		                  quantity=resultSetforTransDetais.getInt("quantity");
		                  list.add(new Transaction_Details(transaction_id,item_id,quantity));
		                  }
					
					System.out.println("Generated Bill : ");
					System.out.println("Customer Id :"+customer_id);
					//System.out.println("Customer Name:"+customer_name);
					System.out.println("Transaction Id : "+transaction_id);
					
					for(Transaction_Details tdd:list) {
						
						System.out.println("Item_id"+tdd.getItem_ID());
						

						preparedStatement2allitems.setInt(1,item_id);
						ResultSet resultSetallitems = preparedStatementfortransaction.executeQuery();
						
						if(resultSetallitems.next()) {
			                  String item_name=resultSetallitems.getString("Item_name");
			                  String item_category=resultSetallitems.getString("item_category");
			                  price=resultSetallitems.getDouble("price");
			                  if(item_category=="CD")
			                	  grand_total=grand_total+price*quantity*Cd_tax;
			                  else if(item_category=="Cosmetics")
			                	  grand_total=grand_total+price*quantity*Cosmetics_tax;
			                  else
			                	  grand_total=grand_total+price*quantity;
			                  
			                  System.out.println("Item_name:"+item_name);
			                  			                  }
						System.out.println("Item Quantity:"+tdd.getQuantity());
						System.out.println("Price:"+price);

					}
					System.out.println("Grand Total : "+grand_total);

			}
					
	
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			// TODO Auto-generated method stub

		}
}

