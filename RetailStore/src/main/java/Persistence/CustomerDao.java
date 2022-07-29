package Persistence;

import Bean.Customer;

public interface CustomerDao {

	
	int addCustomer(Customer customer);
	void deleteCustomer();
	void searchCustomer();
	void showCustomer();
}
