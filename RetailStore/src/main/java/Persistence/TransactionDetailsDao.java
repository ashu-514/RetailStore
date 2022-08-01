package Persistence;

import java.util.List;
import Bean.Transaction_Details;

public interface TransactionDetailsDao {
	void showalltransactionDetails();
	boolean addtransactionDetail(Transaction_Details trans_details);
	void deletetransactionDetail();
	List<Transaction_Details> searchTransactionDetails(int transid);
}

