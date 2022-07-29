package Service;

import Bean.Customer;

public interface customerService {
	
	int addCustomer(Customer customer);
	void deleteCustomer();
	void searchCustomer();
	void showCustomer();

}
