package Persistence;

public interface CustomerDao {

	
	int addCustomer();
	int deleteCustomer();
	Customer searchCustomer(int id);
}
