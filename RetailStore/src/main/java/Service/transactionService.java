package Service;

import java.util.List;

import Bean.Transaction_Details;

public interface transactionService {
	
	void generatebill(int customer_id);
	void showbill(int customer_id);
	void showalltransactionDetails();
	boolean addtransactionDetail(Transaction_Details trans_details);
	boolean deletetransactionDetail(int id);
	List<Transaction_Details> searchTransactionDetails(int transid);

}
