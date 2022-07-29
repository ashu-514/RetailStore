package Persistence;

import Bean.Transaction;

public interface TransactionDao {
	void showalltransactions();
	boolean addtransaction(Transaction transaction);
	void deletetransaction();
}
