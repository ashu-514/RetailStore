package Persistence;

import Bean.Customer;

public interface CustomerDao {

	
	boolean addCustomer(Customer customer);
	void deleteCustomer();
	boolean searchCustomer(int id);
	void showCustomer();
}
