package Persistence;

import Bean.Customer;

public interface CustomerDao {

	
	int addCustomer(Customer customer);
	void deleteCustomer();
	boolean searchCustomer(int id);
	void showCustomer();
}
