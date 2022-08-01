package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bean.Item;
public class Allitemdaoimpl implements AllitemDao {

	@Override
	public void showallitem() {
		try( Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root", "wiley");
				Statement statement=connection.createStatement();	) {

			ResultSet resultSet= statement.executeQuery("SELECT * FROM allItems");
			
			while(resultSet.next()) {
				int item_ID = resultSet.getInt("item_Id");
				String item_Name = resultSet.getString("item_Name");
				String item_Category = resultSet.getString("item_Category");
				int item_Quantity = resultSet.getInt("quantity");
				double item_price = resultSet.getDouble("price");
								
				System.out.println(item_ID +" "+item_Name+" "+item_Category+" "+item_Quantity+" "+item_price);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public boolean additem(Item item) {
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO allItems values(?,?,?,?,?)");) {

			preparedStatement.setInt(1, item.getItem_ID());
			preparedStatement.setString(2, item.getItem_Name());
			preparedStatement.setString(3, item.getItem_Category());
			preparedStatement.setInt(4, item.getItem_Quantity());
			preparedStatement.setDouble(5, item.getItem_Price());

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
	public void deleteitem() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean searchItem(int id) {
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/retailstore", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM allitems where item_Id=?");) {

			preparedStatement.setInt(1,id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id1 = resultSet.getInt("item_Id");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

}
