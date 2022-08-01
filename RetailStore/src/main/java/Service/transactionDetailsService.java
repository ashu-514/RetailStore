package Service;

import Bean.Transaction;
import Bean.Transaction_Details;

public interface transactionDetailsService {
	
	void showalltransactions();
	boolean addtransaction(Transaction transaction);
	boolean deletetransaction(int id);
	Transaction_Details searchTransaction(int transid) ;
}
